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
}