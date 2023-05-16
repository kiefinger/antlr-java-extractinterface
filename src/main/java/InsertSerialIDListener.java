import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.TokenStreamRewriter;

/**
 * This sample comes from The definitive ANTLR4 Reference, page 52,
 * to show how to Rewrite the input stream.
 * 
 * @author ki
 *
 */
public class InsertSerialIDListener extends JavaParserBaseListener {
	TokenStreamRewriter rewriter;

	public InsertSerialIDListener(TokenStream tokens) {
		rewriter = new TokenStreamRewriter(tokens);
	}

	@Override
	public void enterClassBody(JavaParser.ClassBodyContext ctx) {
		String field = "\n\tpublic static final long serialVersionUID = 1L;";
		rewriter.insertAfter(ctx.start, field);
	}
}