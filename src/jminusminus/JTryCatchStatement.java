package jminusminus;

public class JTryCatchStatement extends JStatement{


    /** Body of try block*/
    private JBlock tryBody;

    /** Declaration of exception "catch (Exception e) { }"*/
    private JFormalParameter exceptionParam;

    /** Body of catch block*/
    private JBlock catchBody;
    private final JBlock finallyBody;

    /**
     * Construct an AST node for a statement given its line number.
     *  @param line line in which the statement occurs in the source file.
     *
     * @param tryBody body of try
     *@param exceptionParam declaration of exception
     *@param catchBody body of catch block
     * @param finallyBody body of optional finally body
     */
    protected JTryCatchStatement(int line, JBlock tryBody, JFormalParameter exceptionParam, JBlock catchBody, JBlock finallyBody) {
        super(line);
        this.tryBody = tryBody;
        this.exceptionParam = exceptionParam;
        this.catchBody = catchBody;
        this.finallyBody = finallyBody;
    }

    @Override
    public JAST analyze(Context context) {
        tryBody.analyze(context);

//      Local context for catch exception declaration
        LocalContext localContext = (LocalContext)context;

        int nextOffset = localContext.nextOffset();
        System.out.println(nextOffset);
        System.out.println(nextOffset);
        System.out.println(nextOffset);

        exceptionParam.setType(exceptionParam.type().resolve(localContext));
        LocalVariableDefn defn = new LocalVariableDefn(exceptionParam.type(),
                nextOffset);
        defn.initialize();
        localContext.addEntry(exceptionParam.line(), exceptionParam.name(), defn);

        Type.ITERABLE.isJavaAssignableFrom(exceptionParam.type());

        exceptionParam.analyze(localContext);

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
        exceptionParam.codegen(output);

//        output.addNoArgInstruction(CLConstants.POP);

        catchBody.codegen(output);

        output.addLabel(endLabel);
//        output.addBranchInstruction(CLConstants.GOTO, handlerLabel);
        if (finallyBody != null) {
            finallyBody.codegen(output);
        }

        output.addExceptionHandler(tryStartLabel, tryEndLabel, handlerLabel, exceptionParam.type().jvmName());
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
//        if (exceptionDeclaration.type().classRep() != null) {
            p.printf("<ExceptionDeclaration>\n");
            p.indentRight();
            exceptionParam.writeToStdOut(p);
            p.indentLeft();
            p.printf("</ExceptionDeclaration>\n");
//        }

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
