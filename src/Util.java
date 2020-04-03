public class Util {
    public static boolean coinFlip() {
        double value = Math.round(Math.random());
        return value % 2 == 0;
    }
}
