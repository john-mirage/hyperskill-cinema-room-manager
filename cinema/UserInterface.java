package cinema;

import java.util.Scanner;

public class UserInterface {
    private static final Scanner scanner = new Scanner(System.in);

    public static int askForNumber(String prompt, int min, int max) throws IllegalArgumentException {
        if (prompt == null || prompt.isEmpty()) {
            throw new IllegalArgumentException("The prompt must not be null or empty");
        }
        while (true) {
            System.out.println(prompt);
            String input = scanner.nextLine();
            try {
                int number = Integer.parseInt(input);
                if (number >= min && number <= max) {
                    return number;
                } else {
                    System.out.println("Wrong input");
                }
            } catch (NumberFormatException e) {
                System.out.println("Wrong input");
            }
        }
    }
}
