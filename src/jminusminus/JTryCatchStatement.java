package jminusminus;

import java.util.ArrayList;

public class JTryCatchStatement extends JStatement{


    /** Body of try block*/
    private final JBlock tryBody;

    /** Declaration of exception "catch (Exception e) { }"*/
    private final JFormalParameter exceptionDeclaration;

    /** Body of catch block*/
    private final JBlock catchBody;
    private final JBlock finallyBody;
    private int offset;

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

        LocalContext localContext = new LocalContext(context);

        Type exceptionType = exceptionDeclaration.type().resolve(localContext);
        exceptionDeclaration.setType(exceptionType);

        exceptionType.mustInheritFromType(line, Throwable.class, localContext);

        offset = localContext.nextOffset();

        exceptionDeclaration.analyze(localContext);
        LocalVariableDefn defn = new LocalVariableDefn(exceptionDeclaration.type(),
                offset);
        defn.initialize();
        localContext.addEntry(exceptionDeclaration.line(), exceptionDeclaration.name(), defn);

        catchBody.analyze(localContext);

        if (finallyBody != null) {
            finallyBody.analyze(context);
        }

        return this;
    }

    @Override
    public void codegen(CLEmitter output) {
        String tryStartLabel = output.createLabel();
        String tryEndLabel = output.createLabel();
        String handlerLabel = output.createLabel();
        String endLabel = output.createLabel();

        output.addLabel(tryStartLabel);
        tryBody.codegen(output);
        output.addLabel(tryEndLabel);

        output.addBranchInstruction(CLConstants.GOTO, endLabel);

        output.addLabel(handlerLabel);
        output.addOneArgInstruction(CLConstants.ASTORE, offset);

        exceptionDeclaration.codegen(output);
        catchBody.codegen(output);

        output.addLabel(endLabel);
        if (finallyBody != null) {
            finallyBody.codegen(output);
        }

        output.addExceptionHandler(tryStartLabel, tryEndLabel, handlerLabel, exceptionDeclaration.type().jvmName());

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
