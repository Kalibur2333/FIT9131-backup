import java.util.Scanner;

public class Input {
    public Input() {
    }

    public String accepStringInput() {
        Scanner console = new Scanner(System.in);
        String input = console.nextLine();
        return input;
    }

    public int accepIntegerInput() {
        Scanner console = new Scanner(System.in);
        int input = console.nextInt();
        return input;
    }
}
