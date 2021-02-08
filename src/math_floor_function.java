public class math_floor_function {
    public static int dice;
    public static void main(String [] args) {
        for (int i = 0; i < 100; i++) {
            dice = (int) (Math.floor(Math.random() * 6 + 1));
            System.out.print("\nNumber: " + dice);
        }
    }
}
