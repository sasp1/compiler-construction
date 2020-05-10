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

    public boolean multipleConditions_returnsTrue(){
        boolean b = true && (false || true);
        return b;
    }

    public boolean multipleConditions_returnsTrue2(){
        boolean b = true && false || true;
        return b;
    }
    public boolean multipleConditions_returnsFalse(){
        boolean b = true && false || false;
        return b;
    }

}
