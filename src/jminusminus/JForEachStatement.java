package jminusminus;

public class JForEachStatement extends JStatement {

    private final JVariableDeclarator init;
    private final JExpression iterable;
    private final JStatement statement;

    protected JForEachStatement(int line, JVariableDeclarator init, JExpression iterable, JStatement statement) {
        super(line);
        this.init = init;
        this.iterable = iterable;
        this.statement = statement;
    }

    @Override
    public JAST analyze(Context context) {
        System.out.println("HEEEJ");
        init.analyze(context);

        int offset = ((LocalContext) context).nextOffset();
        LocalVariableDefn defn = new LocalVariableDefn(init.type().resolve(
                context), offset);
        context.addEntry(line, init.name(), defn);

        iterable.analyze(context);
        statement.analyze(context);

        if (!Type.ITERABLE.isJavaAssignableFrom(iterable.type()) && !iterable.type().isArray()) {
            JAST.compilationUnit.reportSemanticError(line, "Variable must have have type iterable or array: \"%s\"", iterable.type().toString());
        }
        init.type().mustMatchExpected(line, iterable.type().componentType());
        return this;
    }

    @Override
    public void codegen(CLEmitter output) {

    }

    @Override
    public void writeToStdOut(PrettyPrinter p) {
        p.printf("<JForStatement line = \"%d\">\n", line());
        p.indentRight();

        p.printf("<VariableDeclaration>\n");
        p.indentRight();
        init.writeToStdOut(p);
        p.printf("</VariableDeclaration>\n");

        p.printf("<Iterable>\n");
        p.indentRight();
        iterable.writeToStdOut(p);
        p.indentLeft();
        p.printf("</Iterable>\n");


        p.printf("<Body>\n");
        p.indentRight();
        statement.writeToStdOut(p);
        p.indentLeft();
        p.printf("</Body>\n");

        p.indentLeft();
        p.printf("</JForStatement>\n");
    }
}
