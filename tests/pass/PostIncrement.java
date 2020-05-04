package pass;

public class PostIncrement {
//    public double postIncrementDouble(double a){
//        a++;
//        return a;
//    }

    public int postIncInt(int x){
        x++;
        return x;
    }

    public int postIncInExpressionReturnsX(int x){
        return x++;// Should not change x
    }
}