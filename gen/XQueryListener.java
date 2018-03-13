// Generated from /Users/weiwei/work/two32B/src/XQuery.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link XQueryParser}.
 */
public interface XQueryListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code slash}
	 * labeled alternative in {@link XQueryParser#ap}.
	 * @param ctx the parse tree
	 */
	void enterSlash(XQueryParser.SlashContext ctx);
	/**
	 * Exit a parse tree produced by the {@code slash}
	 * labeled alternative in {@link XQueryParser#ap}.
	 * @param ctx the parse tree
	 */
	void exitSlash(XQueryParser.SlashContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dSlash}
	 * labeled alternative in {@link XQueryParser#ap}.
	 * @param ctx the parse tree
	 */
	void enterDSlash(XQueryParser.DSlashContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dSlash}
	 * labeled alternative in {@link XQueryParser#ap}.
	 * @param ctx the parse tree
	 */
	void exitDSlash(XQueryParser.DSlashContext ctx);
	/**
	 * Enter a parse tree produced by the {@code paren}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterParen(XQueryParser.ParenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code paren}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitParen(XQueryParser.ParenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code star}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterStar(XQueryParser.StarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code star}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitStar(XQueryParser.StarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code filterRP}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterFilterRP(XQueryParser.FilterRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code filterRP}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitFilterRP(XQueryParser.FilterRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code commaRP}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterCommaRP(XQueryParser.CommaRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code commaRP}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitCommaRP(XQueryParser.CommaRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dot}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterDot(XQueryParser.DotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dot}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitDot(XQueryParser.DotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tag}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterTag(XQueryParser.TagContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tag}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitTag(XQueryParser.TagContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ddot}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterDdot(XQueryParser.DdotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ddot}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitDdot(XQueryParser.DdotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code text}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterText(XQueryParser.TextContext ctx);
	/**
	 * Exit a parse tree produced by the {@code text}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitText(XQueryParser.TextContext ctx);
	/**
	 * Enter a parse tree produced by the {@code attribute}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterAttribute(XQueryParser.AttributeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code attribute}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitAttribute(XQueryParser.AttributeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dslashRP}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterDslashRP(XQueryParser.DslashRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dslashRP}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitDslashRP(XQueryParser.DslashRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code slashRP}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterSlashRP(XQueryParser.SlashRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code slashRP}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitSlashRP(XQueryParser.SlashRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eqFilter}
	 * labeled alternative in {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterEqFilter(XQueryParser.EqFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eqFilter}
	 * labeled alternative in {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitEqFilter(XQueryParser.EqFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notFilter}
	 * labeled alternative in {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterNotFilter(XQueryParser.NotFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notFilter}
	 * labeled alternative in {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitNotFilter(XQueryParser.NotFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andFilter}
	 * labeled alternative in {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterAndFilter(XQueryParser.AndFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andFilter}
	 * labeled alternative in {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitAndFilter(XQueryParser.AndFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code isFilter}
	 * labeled alternative in {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterIsFilter(XQueryParser.IsFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code isFilter}
	 * labeled alternative in {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitIsFilter(XQueryParser.IsFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rpFilter}
	 * labeled alternative in {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterRpFilter(XQueryParser.RpFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rpFilter}
	 * labeled alternative in {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitRpFilter(XQueryParser.RpFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orFilter}
	 * labeled alternative in {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterOrFilter(XQueryParser.OrFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orFilter}
	 * labeled alternative in {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitOrFilter(XQueryParser.OrFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenFilter}
	 * labeled alternative in {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterParenFilter(XQueryParser.ParenFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenFilter}
	 * labeled alternative in {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitParenFilter(XQueryParser.ParenFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code strXQ}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterStrXQ(XQueryParser.StrXQContext ctx);
	/**
	 * Exit a parse tree produced by the {@code strXQ}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitStrXQ(XQueryParser.StrXQContext ctx);
	/**
	 * Enter a parse tree produced by the {@code flwrXQ}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterFlwrXQ(XQueryParser.FlwrXQContext ctx);
	/**
	 * Exit a parse tree produced by the {@code flwrXQ}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitFlwrXQ(XQueryParser.FlwrXQContext ctx);
	/**
	 * Enter a parse tree produced by the {@code slashXQ}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterSlashXQ(XQueryParser.SlashXQContext ctx);
	/**
	 * Exit a parse tree produced by the {@code slashXQ}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitSlashXQ(XQueryParser.SlashXQContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tagXQ}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterTagXQ(XQueryParser.TagXQContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tagXQ}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitTagXQ(XQueryParser.TagXQContext ctx);
	/**
	 * Enter a parse tree produced by the {@code apXQ}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterApXQ(XQueryParser.ApXQContext ctx);
	/**
	 * Exit a parse tree produced by the {@code apXQ}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitApXQ(XQueryParser.ApXQContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenXQ}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterParenXQ(XQueryParser.ParenXQContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenXQ}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitParenXQ(XQueryParser.ParenXQContext ctx);
	/**
	 * Enter a parse tree produced by the {@code letXQ}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterLetXQ(XQueryParser.LetXQContext ctx);
	/**
	 * Exit a parse tree produced by the {@code letXQ}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitLetXQ(XQueryParser.LetXQContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dslashXQ}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterDslashXQ(XQueryParser.DslashXQContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dslashXQ}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitDslashXQ(XQueryParser.DslashXQContext ctx);
	/**
	 * Enter a parse tree produced by the {@code commaXQ}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterCommaXQ(XQueryParser.CommaXQContext ctx);
	/**
	 * Exit a parse tree produced by the {@code commaXQ}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitCommaXQ(XQueryParser.CommaXQContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varXQ}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterVarXQ(XQueryParser.VarXQContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varXQ}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitVarXQ(XQueryParser.VarXQContext ctx);
	/**
	 * Enter a parse tree produced by the {@code joinXQ}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterJoinXQ(XQueryParser.JoinXQContext ctx);
	/**
	 * Exit a parse tree produced by the {@code joinXQ}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitJoinXQ(XQueryParser.JoinXQContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forCl}
	 * labeled alternative in {@link XQueryParser#forClause}.
	 * @param ctx the parse tree
	 */
	void enterForCl(XQueryParser.ForClContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forCl}
	 * labeled alternative in {@link XQueryParser#forClause}.
	 * @param ctx the parse tree
	 */
	void exitForCl(XQueryParser.ForClContext ctx);
	/**
	 * Enter a parse tree produced by the {@code letCl}
	 * labeled alternative in {@link XQueryParser#letClause}.
	 * @param ctx the parse tree
	 */
	void enterLetCl(XQueryParser.LetClContext ctx);
	/**
	 * Exit a parse tree produced by the {@code letCl}
	 * labeled alternative in {@link XQueryParser#letClause}.
	 * @param ctx the parse tree
	 */
	void exitLetCl(XQueryParser.LetClContext ctx);
	/**
	 * Enter a parse tree produced by the {@code whereCl}
	 * labeled alternative in {@link XQueryParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void enterWhereCl(XQueryParser.WhereClContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whereCl}
	 * labeled alternative in {@link XQueryParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void exitWhereCl(XQueryParser.WhereClContext ctx);
	/**
	 * Enter a parse tree produced by the {@code retCl}
	 * labeled alternative in {@link XQueryParser#returnClause}.
	 * @param ctx the parse tree
	 */
	void enterRetCl(XQueryParser.RetClContext ctx);
	/**
	 * Exit a parse tree produced by the {@code retCl}
	 * labeled alternative in {@link XQueryParser#returnClause}.
	 * @param ctx the parse tree
	 */
	void exitRetCl(XQueryParser.RetClContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterOrCond(XQueryParser.OrCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitOrCond(XQueryParser.OrCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code empCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterEmpCond(XQueryParser.EmpCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code empCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitEmpCond(XQueryParser.EmpCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterAndCond(XQueryParser.AndCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitAndCond(XQueryParser.AndCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code someCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterSomeCond(XQueryParser.SomeCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code someCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitSomeCond(XQueryParser.SomeCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterParenCond(XQueryParser.ParenCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitParenCond(XQueryParser.ParenCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code isCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterIsCond(XQueryParser.IsCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code isCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitIsCond(XQueryParser.IsCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eqCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterEqCond(XQueryParser.EqCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eqCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitEqCond(XQueryParser.EqCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterNotCond(XQueryParser.NotCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitNotCond(XQueryParser.NotCondContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#varList}.
	 * @param ctx the parse tree
	 */
	void enterVarList(XQueryParser.VarListContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#varList}.
	 * @param ctx the parse tree
	 */
	void exitVarList(XQueryParser.VarListContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#fileName}.
	 * @param ctx the parse tree
	 */
	void enterFileName(XQueryParser.FileNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#fileName}.
	 * @param ctx the parse tree
	 */
	void exitFileName(XQueryParser.FileNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#tagName}.
	 * @param ctx the parse tree
	 */
	void enterTagName(XQueryParser.TagNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#tagName}.
	 * @param ctx the parse tree
	 */
	void exitTagName(XQueryParser.TagNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#attName}.
	 * @param ctx the parse tree
	 */
	void enterAttName(XQueryParser.AttNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#attName}.
	 * @param ctx the parse tree
	 */
	void exitAttName(XQueryParser.AttNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(XQueryParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(XQueryParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#stringConstant}.
	 * @param ctx the parse tree
	 */
	void enterStringConstant(XQueryParser.StringConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#stringConstant}.
	 * @param ctx the parse tree
	 */
	void exitStringConstant(XQueryParser.StringConstantContext ctx);
}