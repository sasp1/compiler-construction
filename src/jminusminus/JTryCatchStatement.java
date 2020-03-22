package jminusminus;

public class JTryCatchStatement extends JStatement{


    /** Body of try block*/
    private JStatement tryBody;

    /** Declaration of exception "catch (Exception e) { }"*/
    private JFormalParameter exceptionDeclaration;

    /** Body of catch block*/
    private JStatement catchBody;
    private final JStatement finallyBody;

    /**
     * Construct an AST node for a statement given its line number.
     *  @param line line in which the statement occurs in the source file.
     *
     * @param tryBody body of try
     *@param exceptionDeclaration declaration of exception
     *@param catchBody body of catch block
     * @param finallyBody body of optional finally body
     */
    protected JTryCatchStatement(int line, JStatement tryBody, JFormalParameter exceptionDeclaration, JStatement catchBody, JStatement finallyBody) {
        super(line);
        this.tryBody = tryBody;
        this.exceptionDeclaration = exceptionDeclaration;
        this.catchBody = catchBody;
        this.finallyBody = finallyBody;
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
        p.println("<TryPart>");
        p.indentRight();
        tryBody.writeToStdOut(p);
        p.indentLeft();
        p.printf("</TryPart>\n");
        p.printf("<ExceptionDeclaration>\n");
        p.indentRight();
        exceptionDeclaration.writeToStdOut(p);
        p.indentLeft();
        p.printf("</ExceptionDeclaration>\n");
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
