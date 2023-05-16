import static org.junit.jupiter.api.Assertions.fail;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.jupiter.api.Test;


/**
 * This sample comes from The definitive ANTLR4 Reference, page 52,
 * to show how to Rewrite the input stream.
 * 
 * @author ki
 *
 */
class TestRewriteInputStream{

	@Test
	void test() throws Exception{
		String text = new String ( Files.readAllBytes( Paths.get("src/test/resources/Test.java")));
		JavaLexer lexer = new JavaLexer( new ANTLRInputStream(text));
		
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		JavaParser parser = new JavaParser(tokens);
		ParseTree tree = parser.compilationUnit(); // parse
		ParseTreeWalker walker = new ParseTreeWalker(); // create standard walker
		
		InsertSerialIDListener extractor = new InsertSerialIDListener(tokens);
		walker.walk(extractor, tree); //
		
		System.out.println(extractor.rewriter.getText());


	}

}
