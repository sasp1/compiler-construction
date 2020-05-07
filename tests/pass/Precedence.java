package pass;

public class Precedence {

    public boolean withLANDAndLORPrecedence() {
        return (true && true || true && false);
    }
}
