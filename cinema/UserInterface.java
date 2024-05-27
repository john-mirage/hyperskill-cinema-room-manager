package cinema;

import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
    }

    public int askForRows() {
        while (true) {
            System.out.println("Enter the number of rows:");
            String input = this.scanner.nextLine();
            try {
                int rows = Integer.parseInt(input);
                if (rows > 0 && rows < 10) {
                    return rows;
                } else {
                    System.out.println("Wrong input");
                }
            } catch (NumberFormatException e) {
                System.out.println("Wrong input");
            }
        }
    }

    public int askForSeats() {
        while (true) {
            System.out.println("Enter the number of seats in each row:");
            String input = this.scanner.nextLine();
            try {
                int seats = Integer.parseInt(input);
                if (seats > 0 && seats < 10) {
                    return seats;
                } else {
                    System.out.println("Wrong input");
                }
            } catch (NumberFormatException e) {
                System.out.println("Wrong input");
            }
        }
    }

    public int askForRow(int availableRows) {
        while (true) {
            System.out.println("Enter a row number:");
            String input = this.scanner.nextLine();
            try {
                int row = Integer.parseInt(input);
                if (row > 0 && row <= availableRows) {
                    return row;
                } else {
                    System.out.println("Wrong input");
                }
            } catch (NumberFormatException e) {
                System.out.println("Wrong input");
            }
        }
    }

    public int askForSeat(int availableSeats) {
        while (true) {
            System.out.println("Enter a seat number in that row:");
            String input = this.scanner.nextLine();
            try {
                int seat = Integer.parseInt(input);
                if (seat > 0 && seat <= availableSeats) {
                    return seat;
                } else {
                    System.out.println("Wrong input");
                }
            } catch (NumberFormatException e) {
                System.out.println("Wrong input");
            }
        }
    }

    public int askForChoice() {
        while (true) {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            String input = this.scanner.nextLine();
            try {
                int choice = Integer.parseInt(input);
                if (choice >= 0 && choice <= 3) {
                    return choice;
                } else {
                    System.out.println("Wrong input");
                }
            } catch (NumberFormatException e) {
                System.out.println("Wrong input");
            }
        }
    }
}
