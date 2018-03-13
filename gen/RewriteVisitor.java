// Generated from /home/shunjen013/232b/src/Rewrite.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link RewriteParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface RewriteVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code slash}
	 * labeled alternative in {@link RewriteParser#ap}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSlash(RewriteParser.SlashContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dSlash}
	 * labeled alternative in {@link RewriteParser#ap}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDSlash(RewriteParser.DSlashContext ctx);
	/**
	 * Visit a parse tree produced by the {@code paren}
	 * labeled alternative in {@link RewriteParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParen(RewriteParser.ParenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code star}
	 * labeled alternative in {@link RewriteParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStar(RewriteParser.StarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code filterRP}
	 * labeled alternative in {@link RewriteParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilterRP(RewriteParser.FilterRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code commaRP}
	 * labeled alternative in {@link RewriteParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommaRP(RewriteParser.CommaRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dot}
	 * labeled alternative in {@link RewriteParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDot(RewriteParser.DotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tag}
	 * labeled alternative in {@link RewriteParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTag(RewriteParser.TagContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ddot}
	 * labeled alternative in {@link RewriteParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDdot(RewriteParser.DdotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code text}
	 * labeled alternative in {@link RewriteParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText(RewriteParser.TextContext ctx);
	/**
	 * Visit a parse tree produced by the {@code attribute}
	 * labeled alternative in {@link RewriteParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribute(RewriteParser.AttributeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dslashRP}
	 * labeled alternative in {@link RewriteParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDslashRP(RewriteParser.DslashRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code slashRP}
	 * labeled alternative in {@link RewriteParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSlashRP(RewriteParser.SlashRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eqFilter}
	 * labeled alternative in {@link RewriteParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqFilter(RewriteParser.EqFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notFilter}
	 * labeled alternative in {@link RewriteParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotFilter(RewriteParser.NotFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andFilter}
	 * labeled alternative in {@link RewriteParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndFilter(RewriteParser.AndFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code isFilter}
	 * labeled alternative in {@link RewriteParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsFilter(RewriteParser.IsFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rpFilter}
	 * labeled alternative in {@link RewriteParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpFilter(RewriteParser.RpFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orFilter}
	 * labeled alternative in {@link RewriteParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrFilter(RewriteParser.OrFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenFilter}
	 * labeled alternative in {@link RewriteParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenFilter(RewriteParser.ParenFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code strXQ}
	 * labeled alternative in {@link RewriteParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrXQ(RewriteParser.StrXQContext ctx);
	/**
	 * Visit a parse tree produced by the {@code flwrXQ}
	 * labeled alternative in {@link RewriteParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlwrXQ(RewriteParser.FlwrXQContext ctx);
	/**
	 * Visit a parse tree produced by the {@code slashXQ}
	 * labeled alternative in {@link RewriteParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSlashXQ(RewriteParser.SlashXQContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tagXQ}
	 * labeled alternative in {@link RewriteParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagXQ(RewriteParser.TagXQContext ctx);
	/**
	 * Visit a parse tree produced by the {@code apXQ}
	 * labeled alternative in {@link RewriteParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApXQ(RewriteParser.ApXQContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenXQ}
	 * labeled alternative in {@link RewriteParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenXQ(RewriteParser.ParenXQContext ctx);
	/**
	 * Visit a parse tree produced by the {@code letXQ}
	 * labeled alternative in {@link RewriteParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetXQ(RewriteParser.LetXQContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dslashXQ}
	 * labeled alternative in {@link RewriteParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDslashXQ(RewriteParser.DslashXQContext ctx);
	/**
	 * Visit a parse tree produced by the {@code commaXQ}
	 * labeled alternative in {@link RewriteParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommaXQ(RewriteParser.CommaXQContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varXQ}
	 * labeled alternative in {@link RewriteParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarXQ(RewriteParser.VarXQContext ctx);
	/**
	 * Visit a parse tree produced by the {@code joinXQ}
	 * labeled alternative in {@link RewriteParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoinXQ(RewriteParser.JoinXQContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forCl}
	 * labeled alternative in {@link RewriteParser#forClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForCl(RewriteParser.ForClContext ctx);
	/**
	 * Visit a parse tree produced by the {@code letCl}
	 * labeled alternative in {@link RewriteParser#letClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetCl(RewriteParser.LetClContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whereCl}
	 * labeled alternative in {@link RewriteParser#whereClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhereCl(RewriteParser.WhereClContext ctx);
	/**
	 * Visit a parse tree produced by the {@code retCl}
	 * labeled alternative in {@link RewriteParser#returnClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRetCl(RewriteParser.RetClContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orCond}
	 * labeled alternative in {@link RewriteParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrCond(RewriteParser.OrCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code empCond}
	 * labeled alternative in {@link RewriteParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmpCond(RewriteParser.EmpCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andCond}
	 * labeled alternative in {@link RewriteParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndCond(RewriteParser.AndCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code someCond}
	 * labeled alternative in {@link RewriteParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSomeCond(RewriteParser.SomeCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenCond}
	 * labeled alternative in {@link RewriteParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenCond(RewriteParser.ParenCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code isCond}
	 * labeled alternative in {@link RewriteParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsCond(RewriteParser.IsCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eqCond}
	 * labeled alternative in {@link RewriteParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqCond(RewriteParser.EqCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notCond}
	 * labeled alternative in {@link RewriteParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotCond(RewriteParser.NotCondContext ctx);
	/**
	 * Visit a parse tree produced by {@link RewriteParser#varList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarList(RewriteParser.VarListContext ctx);
	/**
	 * Visit a parse tree produced by {@link RewriteParser#fileName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFileName(RewriteParser.FileNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link RewriteParser#tagName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagName(RewriteParser.TagNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link RewriteParser#attName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttName(RewriteParser.AttNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link RewriteParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(RewriteParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by {@link RewriteParser#stringConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringConstant(RewriteParser.StringConstantContext ctx);
}