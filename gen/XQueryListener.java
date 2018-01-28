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
	 * Enter a parse tree produced by {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRp(XQueryParser.RpContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRp(XQueryParser.RpContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterFilter(XQueryParser.FilterContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitFilter(XQueryParser.FilterContext ctx);
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