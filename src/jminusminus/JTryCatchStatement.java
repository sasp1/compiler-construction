package jminusminus;

public class JTryCatchStatement extends JStatement{


    /** Body of try block*/
    private JBlock tryBody;

    /** Declaration of exception "catch (Exception e) { }"*/
    private JFormalParameter exceptionDeclaration;

    /** Body of catch block*/
    private JBlock catchBody;
    private final JBlock finallyBody;

    /**
     * Construct an AST node for a statement given its line number.
     *  @param line line in which the statement occurs in the source file.
     *
     * @param tryBody body of try
     *@param exceptionDeclaration declaration of exception
     *@param catchBody body of catch block
     * @param finallyBody body of optional finally body
     */
    protected JTryCatchStatement(int line, JBlock tryBody, JFormalParameter exceptionDeclaration, JBlock catchBody, JBlock finallyBody) {
        super(line);
        this.tryBody = tryBody;
        this.exceptionDeclaration = exceptionDeclaration;
        this.catchBody = catchBody;
        this.finallyBody = finallyBody;
    }

    @Override
    public JAST analyze(Context context) {
        tryBody.analyze(context);

        Type exceptionType = exceptionDeclaration.type().resolve(context);

        exceptionDeclaration.setType(exceptionType);
        exceptionType.mustInheritFromType(line, Throwable.class, context);
        catchBody.analyze(context);

        if (finallyBody != null) {
            finallyBody.analyze(context);
        }

        return this;
    }

    @Override
    public void codegen(CLEmitter output) {
//        String tryStartLabel = output.createLabel();
//        String tryEndLabel = output.createLabel();
//        String catchLabel = output.createLabel();
//        String finallyLabel = output.createLabel();
        System.out.println(exceptionDeclaration.type().toString());
        System.out.println("HEEEEJ");
//        output.addLabel(tryStartLabel);
//        output.addLabel(tryEndLabel);
//        output.addLabel(catchLabel);
//        output.addExceptionHandler(tryStartLabel, tryEndLabel, catchLabel, exceptionDeclaration.type().jvmName());
//        tryBody.codegen(output);
    }

    @Override
    public void writeToStdOut(PrettyPrinter p) {
        p.printf("<JTryCatchStatement line=\"%d\">\n", line());
        p.indentRight();
        p.println("<TryPart>");
        p.indentRight();
        tryBody.writeToStdOut(p);
        p.indentLeft();
        p.printf("</TryPart>\n");

//        TODO: Might have to be refactored as exception declaration is mandatory
        if (exceptionDeclaration.type().classRep() != null) {
            p.printf("<ExceptionDeclaration>\n");
            p.indentRight();
            exceptionDeclaration.writeToStdOut(p);
            p.indentLeft();
            p.printf("</ExceptionDeclaration>\n");
        }

        p.printf("<CatchPart>\n");
        p.indentRight();
        catchBody.writeToStdOut(p);
        p.indentLeft();
        p.printf("</CatchPart>\n");
        if (finallyBody != null) {
            p.printf("<FinallyPart>\n");
            p.indentRight();
            finallyBody.writeToStdOut(p);
            p.indentLeft();
            p.printf("</FinallyPart>\n");
        }
        p.indentLeft();
        p.printf("</JTryCatchStatement>\n");
    }
}
