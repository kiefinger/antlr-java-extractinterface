import org.antlr.v4.runtime.TokenStream;

public class ExtractInterfaceListener extends JavaParserBaseListener {

	JavaParser parser;

	public ExtractInterfaceListener(JavaParser parser) {
		this.parser = parser;
	}

	@Override
	public void enterClassDeclaration(JavaParser.ClassDeclarationContext ctx) {
		System.out.println("interface I" + ctx.identifier().getText() + " {");
	}

	@Override
	public void exitClassDeclaration(JavaParser.ClassDeclarationContext ctx) {
		System.out.println("}");
	}

	@Override
	public void enterMethodDeclaration(JavaParser.MethodDeclarationContext ctx) {
		TokenStream tokens = parser.getTokenStream();
		String type = tokens.getText(ctx.typeTypeOrVoid() );
		String args = tokens.getText(ctx.formalParameters());
		System.out.println("\t" + type + " " + ctx.identifier().getText() + args + ";");
	}


}