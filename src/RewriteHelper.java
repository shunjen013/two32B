import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;

public class RewriteHelper extends RewriteBaseVisitor <String> {
    Integer tableCnt = 0;
    ArrayList<ArrayList<Pair<String, String>>> tables = new ArrayList<>();
    HashMap<String, Integer> varOwner = new HashMap<>();
    HashMap<Pair<Integer, Integer>, ArrayList<Pair<String, String>>> joinItem = new HashMap<>();
    ArrayList<ArrayList<Pair<String, String>>> selfCond = new ArrayList<>();
    String rpVarName = null;

    public String visitFlwrXQ(RewriteParser.FlwrXQContext ctx) {
        visit(ctx.forClause());
        visit(ctx.whereClause());
        //System.err.println(tables);
        //System.err.println(varOwner);
        //System.err.println(joinItem);
        //System.err.println(selfCond);
        if (joinItem.size() == 0) {
            return ctx.getText();
        }

        ArrayList<StringBuilder> stringBuilders = new ArrayList<>();
        for (int i = 0; i < tableCnt; i ++) {
            // build for clause
            StringBuilder sb = new StringBuilder("for");
            for (Pair<String, String> p: tables.get(i)) {
                sb.append("\t$" + p.getKey() + " in " + p.getValue() + ",\n");
            }
            sb.deleteCharAt(sb.length() - 2);

            // build where clause
            if (selfCond.get(i).size() != 0) {
                sb.append("where\n");
                for (Pair<String, String> p : selfCond.get(i)) {
                    sb.append("\t$" + p.getKey() + " eq " + p.getValue() + ",\n");
                }
                sb.deleteCharAt(sb.length() - 2);
            }

            // build return clause
            sb.append("return <tuple> {\n");
            for (Pair<String, String> p: tables.get(i)) {
                String key = p.getKey();
                sb.append("\t<" + key + "> {$" + key + "} </" + key + ">,\n");
            }
            sb.deleteCharAt(sb.length() - 2);
            sb.append("} </tuple>");
            stringBuilders.add(sb);
        }

        UnionFind uf = new UnionFind(stringBuilders, tableCnt, joinItem);
        //System.err.println("joinItem size: " + joinItem.size());
        for (Pair<Integer, Integer> p: joinItem.keySet()) {
            uf.union(p);
        }
        for (int i = 1; i < tableCnt; i ++) {
            uf.union(0, i);
        }

        StringBuilder retCl = new StringBuilder(ctx.returnClause().getText());
        for (String key: varOwner.keySet()) {
            Integer keyLen = key.length();
            Integer pos = retCl.indexOf("$" + key);
            while (pos != -1) {
                retCl.insert(pos + keyLen + 1, "/*");
                retCl.insert(pos + 1, "tuple/");
                pos = retCl.indexOf("$" + key);
            }
        }

        StringBuilder ret = new StringBuilder("for $tuple in ");
        ret.append(uf.findSb(0));
        ret.append("\n");
        ret.append(retCl);

        return ret.toString();
    }

    public String visitForCl(RewriteParser.ForClContext ctx) {
        int varNum = ctx.var().size();
        for (int i = 0; i < varNum; i ++) {
            String varName = ctx.var(i).STRING().getText();
            rpVarName = null;
            visit(ctx.xq(i));
            if (rpVarName == null) {    // ap
                varOwner.put(varName, tableCnt - 1);
                tables.get(tableCnt - 1).add(new Pair<>(varName, ctx.xq(i).getText()));
            }
            else {                      // rp
                Integer owner = varOwner.get(rpVarName);
                varOwner.put(varName, owner);
                tables.get(owner).add(new Pair<>(varName, ctx.xq(i).getText()));
            }
        }
        return null;
    }

    public String visitApXQ(RewriteParser.ApXQContext ctx) {
        tables.add(new ArrayList<>());
        tableCnt ++;
        selfCond.add(new ArrayList<>());
        return null;
    }

    public String visitSlashXQ(RewriteParser.SlashXQContext ctx) {
        rpVarName = ctx.xq().getText().substring(1);
        //System.err.println("slashXq: " + rpVarName);
        return null;
    }

    public String visitDslashXQ(RewriteParser.DslashXQContext ctx) {
        rpVarName = ctx.xq().getText().substring(1);
        return null;
    }

    public String visitEqCond(RewriteParser.EqCondContext ctx) {
        Integer small = -1;
        Integer big = -1;
        String selfCondConst = null;

        String left = ctx.xq(0).getText();
        String right = ctx.xq(1).getText();

        if (left.startsWith("$")) {
            left = left.substring(1);
            small = varOwner.get(left);
        }
        else {
            selfCondConst = left;
        }
        if (right.startsWith("$")) {
            right = right.substring(1);
            big = varOwner.get(right);
        }
        else {
            selfCondConst = right;
        }
        // swap if small > big
        if (small > big) {
            Integer tempInt = small;
            small = big;
            big = tempInt;
            String tempStr = left;
            left = right;
            right = tempStr;

        }

        //System.err.println(small);
        //System.err.println(big);

        if (selfCondConst == null) {
            Pair<Integer, Integer> key = new Pair<>(small, big);
            if (!joinItem.containsKey(key)) {
                joinItem.put(key, new ArrayList<>());
            }
            joinItem.get(key).add(new Pair<>(left, right));
        }
        else {
            selfCond.get(big).add(new Pair<>(right, left));
        }

        return null;
    }

}
