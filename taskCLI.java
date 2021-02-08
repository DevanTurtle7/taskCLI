import java.util.Scanner;

public class taskCLI {
    private static boolean exit = false;

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);

        while (!exit) {
            System.out.print(": ");
            String line = input.nextLine();
            System.out.println("The user entered: " + line);
        }

        input.close();
    }
}