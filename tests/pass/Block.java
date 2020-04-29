package pass;

public class Block {

    public static int i = 3;
    public static int j = 100;

    static {
        i = i + 5;
    }

    {
        i = i + 5;
    }

    static {
        j = 0;
    }

    public void incrementJ() {
        j = j + 1;
    }

    public int returnJ() {
        return j;
    }

    public int blockInMethod() {
        {
            j = 100;
        }
        return j;
    }

    public int initializeJBlockInMethod() {
        {
            int j;
            j = 100;
        }
        return j;
    }

    public int returnNumber() {
        return i;
    }
}
