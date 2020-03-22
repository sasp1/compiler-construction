package jminusminus;

public class JTryCatchStatement extends JStatement{


    /** Body of try block*/
    private JStatement tryBody;

    /** Declaration of exception "catch (Exception e) { }"*/
    private JFormalParameter exceptionDeclaration;

    /** Body of catch block*/
    private JStatement catchBody;

    /**
     * Construct an AST node for a statement given its line number.
     *
     * @param line line in which the statement occurs in the source file.
     *
     * @param tryBody body of try
     *
     * @param exceptionDeclaration declaration of exception
     *
     * @param catchBody body of catch block
     */


    protected JTryCatchStatement(int line, JStatement tryBody, JFormalParameter exceptionDeclaration, JStatement catchBody) {
        super(line);
        this.tryBody = tryBody;
        this.exceptionDeclaration = exceptionDeclaration;
        this.catchBody = catchBody;
    }

    @Override
    public JAST analyze(Context context) {
        return null;
    }

    @Override
    public void codegen(CLEmitter output) {

    }

    @Override
    public void writeToStdOut(PrettyPrinter p) {
        p.printf("<JTryCatchStatement line=\"%d\">\n", line());
        p.indentRight();
        tryBody.writeToStdOut(p);
        p.indentLeft();
        p.printf("<CatchPart>\n");
        p.indentRight();
        p.printf("<ExceptionDeclaration>\n");
        p.indentRight();
        exceptionDeclaration.writeToStdOut(p);
        p.indentLeft();
        p.printf("</ExceptionDeclaration>\n");
        catchBody.writeToStdOut(p);
        p.indentLeft();
        p.printf("</CatchPart>\n");
        p.indentLeft();
        p.printf("</JTryCatchStatement>\n");
    }
}
