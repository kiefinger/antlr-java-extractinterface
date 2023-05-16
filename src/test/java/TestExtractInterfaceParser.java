import static org.junit.jupiter.api.Assertions.fail;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.jupiter.api.Test;

class TestExtractInterfaceParser {

	@Test
	void test() throws Exception{
		String text = new String ( Files.readAllBytes( Paths.get("src/test/resources/Test.java")));
		JavaLexer lexer = new JavaLexer( new ANTLRInputStream(text));
		
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		JavaParser parser = new JavaParser(tokens);
		ParseTree tree = parser.compilationUnit(); // parse
		ParseTreeWalker walker = new ParseTreeWalker(); // create standard walker
		ExtractInterfaceListener extractor = new ExtractInterfaceListener(parser);
		
		walker.walk(extractor, tree); // initiate walk of tree with listener


	}

}
