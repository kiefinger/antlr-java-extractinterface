import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class ExtractInterfaceTool {

	
	public static void main(String[] args) {
		
		ANTLRInputStream input;
		try {
			input = new ANTLRInputStream(System.in);
			JavaLexer lexer = new JavaLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			JavaParser parser = new JavaParser(tokens);
			ParseTree tree = parser.compilationUnit(); // parse
			ParseTreeWalker walker = new ParseTreeWalker(); // create standard walker
			ExtractInterfaceListener extractor = new ExtractInterfaceListener(parser);
			walker.walk(extractor, tree); // initiate walk of tree with listener
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
