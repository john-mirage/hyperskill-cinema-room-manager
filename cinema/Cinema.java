package cinema;

public class Cinema {

    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        int rows = ui.askForRows();
        int seats = ui.askForSeats();
        ScreenRoom sr = new ScreenRoom(rows, seats);
        while (true) {
            int choice = ui.askForChoice();
            if (choice == 0) {
                break;
            } else {
                if (choice == 1) {
                    System.out.println(sr);
                }
                if (choice == 2) {
                    while (true) {
                        int row = ui.askForRow(sr.getRows());
                        int seat = ui.askForSeat(sr.getSeats());
                        if (sr.takeSeat(row, seat)) {
                            System.out.println("Ticket price: $" + sr.getTicketPrice(row));
                            break;
                        } else {
                            System.out.println("That ticket has already been purchased!");
                        }
                    }
                }
                if (choice == 3) {
                    System.out.println("Number of purchased tickets: " + sr.getPersons());
                    System.out.println("Percentage: " + String.format("%.2f", sr.getPercentageOfPersons()) + "%");
                    System.out.println("Current income: $" + sr.getCurrentIncome());
                    System.out.println("Total income: $" + sr.getTotalIncome());
                }
            }
        }
    }
}
