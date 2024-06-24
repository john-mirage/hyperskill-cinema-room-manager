package cinema;

public class Cinema {

    public static void main(String[] args) {
        int rows = UserInterface.askForNumber("Enter the number of rows:", 0, 10);
        int seats = UserInterface.askForNumber("Enter the number of seats in each row:", 0, 10);
        ScreenRoom screenRoom = new ScreenRoom(rows, seats);
        mainLoop:
        while (true) {
            int choice = UserInterface.askForNumber("1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit", 0, 3);
            switch (choice) {
                case 0: {
                    break mainLoop;
                }
                case 1: {
                    System.out.println(screenRoom);
                    break;
                }
                case 2: {
                    while (true) {
                        int row = UserInterface.askForNumber("Enter a row number:", 0, screenRoom.getRows());
                        int seat = UserInterface.askForNumber("Enter a seat number in that row:", 0, screenRoom.getSeats());
                        if (screenRoom.takeSeat(row, seat)) {
                            System.out.println("Ticket price: $" + screenRoom.getTicketPrice(row));
                            break;
                        } else {
                            System.out.println("That ticket has already been purchased!");
                        }
                    }
                    break;
                }
                case 3: {
                    System.out.println("Number of purchased tickets: " + screenRoom.getPersons());
                    System.out.println("Percentage: " + String.format("%.2f", screenRoom.getPercentageOfPersons()) + "%");
                    System.out.println("Current income: $" + screenRoom.getCurrentIncome());
                    System.out.println("Total income: $" + screenRoom.getTotalIncome());
                    break;
                }
                default: {
                    System.out.println("Invalid choice");
                }
            }
        }
    }
}
