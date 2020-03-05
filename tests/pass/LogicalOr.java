package pass;

public class LogicalOr {

    public boolean logicalOr(boolean op1, boolean op2){
        return operation1(op1) || operation2(op2);
    }

    private boolean operation1(boolean input){
        System.out.println("operation1");
        return input;
    }

    private boolean operation2(boolean input){
        System.out.println("operation2");
        return input;
    }
}
