package Programs;

public class Overload_Main {
    public static void main(String[] args) {
        System.out.println("Main with String[] args");
        main("Overloaded Main");
    }

    public static void main(String arg) {
        System.out.println("Overloaded main: " + arg);
    }
}
