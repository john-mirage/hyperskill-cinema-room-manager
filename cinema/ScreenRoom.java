package cinema;

public class ScreenRoom {
    private final int rows;
    private final int seats;
    private final int totalSeats;
    private final int totalIncome;
    private final char[][] matrix;
    private int availableSeats;
    private int currentIncome;

    public ScreenRoom(int rows, int seats) {
        this.rows = rows;
        this.seats = seats;
        this.totalSeats = this.rows * this.seats;
        this.totalIncome = this.calculateTotalIncome();
        this.matrix = this.createMatrix();
        this.availableSeats = this.totalSeats;
        this.currentIncome = 0;
    }

    public int getRows() {
        return this.rows;
    }

    public int getSeats() {
        return this.seats;
    }

    public int getTotalSeats() {
        return this.totalSeats;
    }

    public int getAvailableSeats() {
        return this.availableSeats;
    }

    public int getTotalIncome() {
        return this.totalIncome;
    }

    public int getCurrentIncome() {
        return this.currentIncome;
    }

    private char[][] createMatrix() {
        char[][] matrix = new char[this.rows][this.seats];
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.seats; j++) {
                matrix[i][j] = 'S';
            }
        }
        return matrix;
    }

    public boolean seatIsTaken(int row, int seat) {
        return this.matrix[row - 1][seat - 1] == 'B';
    }

    public boolean takeSeat(int row, int seat) {
        if (this.availableSeats > 0 && !this.seatIsTaken(row, seat)) {
            this.matrix[row - 1][seat - 1] = 'B';
            this.availableSeats--;
            this.currentIncome += getTicketPrice(row);
            return true;
        }
        return false;
    }

    private int calculateTotalIncome() {
        if (this.totalSeats > 60) {
            int frontHalf = this.rows / 2;
            int backHalf = this.rows - frontHalf;
            return (frontHalf * this.seats * 10) + (backHalf * this.seats * 8);
        } else {
            return this.rows * this.seats * 10;
        }
    }

    public int getTicketPrice(int row) {
        if (this.totalSeats > 60) {
            int frontHalf = this.rows / 2;
            return row <= frontHalf ? 10 : 8;
        } else {
            return 10;
        }
    }

    public int getPersons() {
        return this.totalSeats - this.availableSeats;
    }

    public double getPercentageOfPersons() {
        double percentage = 100.0 * this.getPersons() / this.totalSeats;
        return (double) Math.round(percentage * 100.0) / 100.0;
    }

    public String toString() {
        StringBuilder room = new StringBuilder();
        System.out.println("Cinema:");
        for (int i = 0; i <= this.rows; i++) {
            for (int j = 0; j <= this.seats; j++) {
                if (i == 0 && j == 0) {
                    room.append("\s\s");
                } else if (i == 0) {
                    room.append(j).append(" ");
                } else if (j == 0) {
                    room.append(i).append(" ");
                } else {
                    room.append(this.matrix[i - 1][j - 1]).append(" ");
                }
            }
            room.append("\n");
        }
        return room.toString();
    }
}
