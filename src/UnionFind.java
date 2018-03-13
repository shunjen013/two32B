import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;

public class UnionFind {
    ArrayList<StringBuilder> sbs;
    ArrayList<Integer> parents;
    Integer groupNum;
    HashMap<Pair<Integer, Integer>, ArrayList<Pair<String, String>>> joinItem;

    public UnionFind (ArrayList<StringBuilder> stringBuilders, Integer tableNum,
                      HashMap<Pair<Integer, Integer>, ArrayList<Pair<String, String>>> joinItem) {
        this.sbs = stringBuilders;
        this.groupNum = tableNum;
        this.joinItem = joinItem;
        parents = new ArrayList<>();
        for (int i = 0; i < tableNum; i ++) {
            parents.add(i);
        }
    }

    public void union (Integer a, Integer b) {
        Pair<Integer, Integer> key = a < b ? new Pair<>(a, b) : new Pair<>(b, a);
        a = find(a);
        b = find(b);
        if (a == b) {
            return;
        }
        StringBuilder sbA = sbs.get(a);
        StringBuilder sbB = sbs.get(b);

        sbA.insert(0, "join (");
        sbA.append(",\n\n");
        sbA.append(sbB);
        sbA.append(",\n\n");
        if (joinItem.get(key) == null) {
            sbA.append("[ ], [ ]\n)");
        }
        else {
            StringBuilder varsA = new StringBuilder();
            StringBuilder varsB = new StringBuilder();
            for (Pair<String, String> p: joinItem.get(key)) {
                varsA.append(p.getKey() + ", ");
                varsB.append(p.getValue() + ", ");
            }
            varsA.delete(varsA.length() - 2, varsA.length());
            varsB.delete(varsB.length() - 2, varsB.length());
            sbA.append("[" + varsA + "], [" + varsB + "]\n)");
        }

        parents.set(b, a);
        groupNum --;

    }

    public void union (Pair<Integer, Integer> p) {
        union(p.getKey(), p.getValue());
    }

    public Integer find (Integer idx) {
        while (parents.get(idx) != idx) {
            idx = parents.get(idx);
        }
        return idx;
    }

    public StringBuilder findSb (Integer idx) {
        return sbs.get(find(idx));
    }
}
