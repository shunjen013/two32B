// Generated from /Users/weiwei/work/two32B/src/XQuery.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link XQueryParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface XQueryVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code slash}
	 * labeled alternative in {@link XQueryParser#ap}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSlash(XQueryParser.SlashContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dSlash}
	 * labeled alternative in {@link XQueryParser#ap}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDSlash(XQueryParser.DSlashContext ctx);
	/**
	 * Visit a parse tree produced by the {@code paren}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParen(XQueryParser.ParenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code star}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStar(XQueryParser.StarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code filterRP}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilterRP(XQueryParser.FilterRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code commaRP}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommaRP(XQueryParser.CommaRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dot}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDot(XQueryParser.DotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tag}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTag(XQueryParser.TagContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ddot}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDdot(XQueryParser.DdotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code text}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText(XQueryParser.TextContext ctx);
	/**
	 * Visit a parse tree produced by the {@code attribute}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribute(XQueryParser.AttributeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dslashRP}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDslashRP(XQueryParser.DslashRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code slashRP}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSlashRP(XQueryParser.SlashRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eqFilter}
	 * labeled alternative in {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqFilter(XQueryParser.EqFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notFilter}
	 * labeled alternative in {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotFilter(XQueryParser.NotFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andFilter}
	 * labeled alternative in {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndFilter(XQueryParser.AndFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code isFilter}
	 * labeled alternative in {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsFilter(XQueryParser.IsFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rpFilter}
	 * labeled alternative in {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpFilter(XQueryParser.RpFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orFilter}
	 * labeled alternative in {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrFilter(XQueryParser.OrFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenFilter}
	 * labeled alternative in {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenFilter(XQueryParser.ParenFilterContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#fileName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFileName(XQueryParser.FileNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#tagName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagName(XQueryParser.TagNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#attName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttName(XQueryParser.AttNameContext ctx);
}