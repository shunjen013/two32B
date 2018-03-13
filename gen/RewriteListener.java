// Generated from /home/shunjen013/232b/src/Rewrite.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link RewriteParser}.
 */
public interface RewriteListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code slash}
	 * labeled alternative in {@link RewriteParser#ap}.
	 * @param ctx the parse tree
	 */
	void enterSlash(RewriteParser.SlashContext ctx);
	/**
	 * Exit a parse tree produced by the {@code slash}
	 * labeled alternative in {@link RewriteParser#ap}.
	 * @param ctx the parse tree
	 */
	void exitSlash(RewriteParser.SlashContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dSlash}
	 * labeled alternative in {@link RewriteParser#ap}.
	 * @param ctx the parse tree
	 */
	void enterDSlash(RewriteParser.DSlashContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dSlash}
	 * labeled alternative in {@link RewriteParser#ap}.
	 * @param ctx the parse tree
	 */
	void exitDSlash(RewriteParser.DSlashContext ctx);
	/**
	 * Enter a parse tree produced by the {@code paren}
	 * labeled alternative in {@link RewriteParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterParen(RewriteParser.ParenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code paren}
	 * labeled alternative in {@link RewriteParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitParen(RewriteParser.ParenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code star}
	 * labeled alternative in {@link RewriteParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterStar(RewriteParser.StarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code star}
	 * labeled alternative in {@link RewriteParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitStar(RewriteParser.StarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code filterRP}
	 * labeled alternative in {@link RewriteParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterFilterRP(RewriteParser.FilterRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code filterRP}
	 * labeled alternative in {@link RewriteParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitFilterRP(RewriteParser.FilterRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code commaRP}
	 * labeled alternative in {@link RewriteParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterCommaRP(RewriteParser.CommaRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code commaRP}
	 * labeled alternative in {@link RewriteParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitCommaRP(RewriteParser.CommaRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dot}
	 * labeled alternative in {@link RewriteParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterDot(RewriteParser.DotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dot}
	 * labeled alternative in {@link RewriteParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitDot(RewriteParser.DotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tag}
	 * labeled alternative in {@link RewriteParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterTag(RewriteParser.TagContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tag}
	 * labeled alternative in {@link RewriteParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitTag(RewriteParser.TagContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ddot}
	 * labeled alternative in {@link RewriteParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterDdot(RewriteParser.DdotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ddot}
	 * labeled alternative in {@link RewriteParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitDdot(RewriteParser.DdotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code text}
	 * labeled alternative in {@link RewriteParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterText(RewriteParser.TextContext ctx);
	/**
	 * Exit a parse tree produced by the {@code text}
	 * labeled alternative in {@link RewriteParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitText(RewriteParser.TextContext ctx);
	/**
	 * Enter a parse tree produced by the {@code attribute}
	 * labeled alternative in {@link RewriteParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterAttribute(RewriteParser.AttributeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code attribute}
	 * labeled alternative in {@link RewriteParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitAttribute(RewriteParser.AttributeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dslashRP}
	 * labeled alternative in {@link RewriteParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterDslashRP(RewriteParser.DslashRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dslashRP}
	 * labeled alternative in {@link RewriteParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitDslashRP(RewriteParser.DslashRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code slashRP}
	 * labeled alternative in {@link RewriteParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterSlashRP(RewriteParser.SlashRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code slashRP}
	 * labeled alternative in {@link RewriteParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitSlashRP(RewriteParser.SlashRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eqFilter}
	 * labeled alternative in {@link RewriteParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterEqFilter(RewriteParser.EqFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eqFilter}
	 * labeled alternative in {@link RewriteParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitEqFilter(RewriteParser.EqFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notFilter}
	 * labeled alternative in {@link RewriteParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterNotFilter(RewriteParser.NotFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notFilter}
	 * labeled alternative in {@link RewriteParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitNotFilter(RewriteParser.NotFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andFilter}
	 * labeled alternative in {@link RewriteParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterAndFilter(RewriteParser.AndFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andFilter}
	 * labeled alternative in {@link RewriteParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitAndFilter(RewriteParser.AndFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code isFilter}
	 * labeled alternative in {@link RewriteParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterIsFilter(RewriteParser.IsFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code isFilter}
	 * labeled alternative in {@link RewriteParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitIsFilter(RewriteParser.IsFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rpFilter}
	 * labeled alternative in {@link RewriteParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterRpFilter(RewriteParser.RpFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rpFilter}
	 * labeled alternative in {@link RewriteParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitRpFilter(RewriteParser.RpFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orFilter}
	 * labeled alternative in {@link RewriteParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterOrFilter(RewriteParser.OrFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orFilter}
	 * labeled alternative in {@link RewriteParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitOrFilter(RewriteParser.OrFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenFilter}
	 * labeled alternative in {@link RewriteParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterParenFilter(RewriteParser.ParenFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenFilter}
	 * labeled alternative in {@link RewriteParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitParenFilter(RewriteParser.ParenFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code strXQ}
	 * labeled alternative in {@link RewriteParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterStrXQ(RewriteParser.StrXQContext ctx);
	/**
	 * Exit a parse tree produced by the {@code strXQ}
	 * labeled alternative in {@link RewriteParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitStrXQ(RewriteParser.StrXQContext ctx);
	/**
	 * Enter a parse tree produced by the {@code flwrXQ}
	 * labeled alternative in {@link RewriteParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterFlwrXQ(RewriteParser.FlwrXQContext ctx);
	/**
	 * Exit a parse tree produced by the {@code flwrXQ}
	 * labeled alternative in {@link RewriteParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitFlwrXQ(RewriteParser.FlwrXQContext ctx);
	/**
	 * Enter a parse tree produced by the {@code slashXQ}
	 * labeled alternative in {@link RewriteParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterSlashXQ(RewriteParser.SlashXQContext ctx);
	/**
	 * Exit a parse tree produced by the {@code slashXQ}
	 * labeled alternative in {@link RewriteParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitSlashXQ(RewriteParser.SlashXQContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tagXQ}
	 * labeled alternative in {@link RewriteParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterTagXQ(RewriteParser.TagXQContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tagXQ}
	 * labeled alternative in {@link RewriteParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitTagXQ(RewriteParser.TagXQContext ctx);
	/**
	 * Enter a parse tree produced by the {@code apXQ}
	 * labeled alternative in {@link RewriteParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterApXQ(RewriteParser.ApXQContext ctx);
	/**
	 * Exit a parse tree produced by the {@code apXQ}
	 * labeled alternative in {@link RewriteParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitApXQ(RewriteParser.ApXQContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenXQ}
	 * labeled alternative in {@link RewriteParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterParenXQ(RewriteParser.ParenXQContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenXQ}
	 * labeled alternative in {@link RewriteParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitParenXQ(RewriteParser.ParenXQContext ctx);
	/**
	 * Enter a parse tree produced by the {@code letXQ}
	 * labeled alternative in {@link RewriteParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterLetXQ(RewriteParser.LetXQContext ctx);
	/**
	 * Exit a parse tree produced by the {@code letXQ}
	 * labeled alternative in {@link RewriteParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitLetXQ(RewriteParser.LetXQContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dslashXQ}
	 * labeled alternative in {@link RewriteParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterDslashXQ(RewriteParser.DslashXQContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dslashXQ}
	 * labeled alternative in {@link RewriteParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitDslashXQ(RewriteParser.DslashXQContext ctx);
	/**
	 * Enter a parse tree produced by the {@code commaXQ}
	 * labeled alternative in {@link RewriteParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterCommaXQ(RewriteParser.CommaXQContext ctx);
	/**
	 * Exit a parse tree produced by the {@code commaXQ}
	 * labeled alternative in {@link RewriteParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitCommaXQ(RewriteParser.CommaXQContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varXQ}
	 * labeled alternative in {@link RewriteParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterVarXQ(RewriteParser.VarXQContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varXQ}
	 * labeled alternative in {@link RewriteParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitVarXQ(RewriteParser.VarXQContext ctx);
	/**
	 * Enter a parse tree produced by the {@code joinXQ}
	 * labeled alternative in {@link RewriteParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterJoinXQ(RewriteParser.JoinXQContext ctx);
	/**
	 * Exit a parse tree produced by the {@code joinXQ}
	 * labeled alternative in {@link RewriteParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitJoinXQ(RewriteParser.JoinXQContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forCl}
	 * labeled alternative in {@link RewriteParser#forClause}.
	 * @param ctx the parse tree
	 */
	void enterForCl(RewriteParser.ForClContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forCl}
	 * labeled alternative in {@link RewriteParser#forClause}.
	 * @param ctx the parse tree
	 */
	void exitForCl(RewriteParser.ForClContext ctx);
	/**
	 * Enter a parse tree produced by the {@code letCl}
	 * labeled alternative in {@link RewriteParser#letClause}.
	 * @param ctx the parse tree
	 */
	void enterLetCl(RewriteParser.LetClContext ctx);
	/**
	 * Exit a parse tree produced by the {@code letCl}
	 * labeled alternative in {@link RewriteParser#letClause}.
	 * @param ctx the parse tree
	 */
	void exitLetCl(RewriteParser.LetClContext ctx);
	/**
	 * Enter a parse tree produced by the {@code whereCl}
	 * labeled alternative in {@link RewriteParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void enterWhereCl(RewriteParser.WhereClContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whereCl}
	 * labeled alternative in {@link RewriteParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void exitWhereCl(RewriteParser.WhereClContext ctx);
	/**
	 * Enter a parse tree produced by the {@code retCl}
	 * labeled alternative in {@link RewriteParser#returnClause}.
	 * @param ctx the parse tree
	 */
	void enterRetCl(RewriteParser.RetClContext ctx);
	/**
	 * Exit a parse tree produced by the {@code retCl}
	 * labeled alternative in {@link RewriteParser#returnClause}.
	 * @param ctx the parse tree
	 */
	void exitRetCl(RewriteParser.RetClContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orCond}
	 * labeled alternative in {@link RewriteParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterOrCond(RewriteParser.OrCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orCond}
	 * labeled alternative in {@link RewriteParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitOrCond(RewriteParser.OrCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code empCond}
	 * labeled alternative in {@link RewriteParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterEmpCond(RewriteParser.EmpCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code empCond}
	 * labeled alternative in {@link RewriteParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitEmpCond(RewriteParser.EmpCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andCond}
	 * labeled alternative in {@link RewriteParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterAndCond(RewriteParser.AndCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andCond}
	 * labeled alternative in {@link RewriteParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitAndCond(RewriteParser.AndCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code someCond}
	 * labeled alternative in {@link RewriteParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterSomeCond(RewriteParser.SomeCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code someCond}
	 * labeled alternative in {@link RewriteParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitSomeCond(RewriteParser.SomeCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenCond}
	 * labeled alternative in {@link RewriteParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterParenCond(RewriteParser.ParenCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenCond}
	 * labeled alternative in {@link RewriteParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitParenCond(RewriteParser.ParenCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code isCond}
	 * labeled alternative in {@link RewriteParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterIsCond(RewriteParser.IsCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code isCond}
	 * labeled alternative in {@link RewriteParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitIsCond(RewriteParser.IsCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eqCond}
	 * labeled alternative in {@link RewriteParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterEqCond(RewriteParser.EqCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eqCond}
	 * labeled alternative in {@link RewriteParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitEqCond(RewriteParser.EqCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notCond}
	 * labeled alternative in {@link RewriteParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterNotCond(RewriteParser.NotCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notCond}
	 * labeled alternative in {@link RewriteParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitNotCond(RewriteParser.NotCondContext ctx);
	/**
	 * Enter a parse tree produced by {@link RewriteParser#varList}.
	 * @param ctx the parse tree
	 */
	void enterVarList(RewriteParser.VarListContext ctx);
	/**
	 * Exit a parse tree produced by {@link RewriteParser#varList}.
	 * @param ctx the parse tree
	 */
	void exitVarList(RewriteParser.VarListContext ctx);
	/**
	 * Enter a parse tree produced by {@link RewriteParser#fileName}.
	 * @param ctx the parse tree
	 */
	void enterFileName(RewriteParser.FileNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link RewriteParser#fileName}.
	 * @param ctx the parse tree
	 */
	void exitFileName(RewriteParser.FileNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link RewriteParser#tagName}.
	 * @param ctx the parse tree
	 */
	void enterTagName(RewriteParser.TagNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link RewriteParser#tagName}.
	 * @param ctx the parse tree
	 */
	void exitTagName(RewriteParser.TagNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link RewriteParser#attName}.
	 * @param ctx the parse tree
	 */
	void enterAttName(RewriteParser.AttNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link RewriteParser#attName}.
	 * @param ctx the parse tree
	 */
	void exitAttName(RewriteParser.AttNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link RewriteParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(RewriteParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link RewriteParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(RewriteParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by {@link RewriteParser#stringConstant}.
	 * @param ctx the parse tree
	 */
	void enterStringConstant(RewriteParser.StringConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link RewriteParser#stringConstant}.
	 * @param ctx the parse tree
	 */
	void exitStringConstant(RewriteParser.StringConstantContext ctx);
}