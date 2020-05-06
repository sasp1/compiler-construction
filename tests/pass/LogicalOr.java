package pass;

public class LogicalOr {

    public boolean logicalOr(boolean op1, boolean op2){
        return op1 || op2;
    }

    int i = 2;
    public int testOnlyFirstConditionReturns2(){
        boolean b = true || secondCondition();
        return i;
    }
    private boolean secondCondition(){
        i = -1;
        return true;
    }

}
