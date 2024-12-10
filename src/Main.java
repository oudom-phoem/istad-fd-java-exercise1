import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[][] seats = null;

        while (true){
            System.out.print("""
                    Cinema Hall Seat Booking Application
                    Menu:
                    1. Set up the seat
                    2. Book a seat
                    3. Cancel a booking
                    4. Display seats
                    5. View booking history
                    6. Exit
                    >\s""");
            byte choice = scanner.nextByte();

            switch (choice) {
                case 1:
                    System.out.print("Please enter number of rows: ");
                    byte rows = scanner.nextByte();

                    System.out.print("Please enter number of columns: ");
                    byte columns = scanner.nextByte();

                    seats = new int[rows][columns];

                    char charRow = 'A';

                    for (int i = 0; i < rows; i++) {
                        System.out.print("[");
                        for (int j = 0; j < columns; j++) {
                            String seatCode = charRow + "-" + (j + 1) + ":";
                            String bookStatus = "";
                            if (seats[i][j] == 0) {
                                bookStatus = j == columns - 1 ? "AV" : "AV, ";
                            } else {
                                bookStatus = j == columns - 1 ? "BO" : "BO, ";
                            }
                            System.out.print(seatCode + bookStatus);
                        }
                        System.out.print("]");
                        charRow++;
                        System.out.println();
                    }
                    System.out.println();
                    break;
                case 2:
                    if (seats == null) {
                        System.out.println("Seats have not been set up. Please set up the seats first.");
                    } else {
                        scanner.nextLine();
                        System.out.print("Please enter the seat code to book (e.g., B3): ");
                        String seatCodeToBook = scanner.nextLine();
                        char seatRowChar = seatCodeToBook.charAt(0);
                        String seatColumnStr = seatCodeToBook.substring(1);

                        int seatRowIndex = seatRowChar - 'A';
                        int seatColumnIndex = Integer.parseInt(seatColumnStr) - 1;

                        if (seatRowIndex >= 0 && seatRowIndex < seats.length && seatColumnIndex >= 0 && seatColumnIndex < seats[0].length) {
                            if (seats[seatRowIndex][seatColumnIndex] == 0) {
                                seats[seatRowIndex][seatColumnIndex] = 1;
                                System.out.println("Seat " + seatCodeToBook + " successfully booked.");
                            } else {
                                System.out.println("Seat " + seatCodeToBook + " is already booked.");
                            }
                        } else {
                            System.out.println("Invalid seat code. Please try again.");
                        }

                        seats[seatRowIndex][seatColumnIndex] = 1;

                    }
                    System.out.println();
                    break;
                case 6:
                    System.out.println("Thank you for using the Cinema Hall Seat Booking system. Goodbye!");
                    return;

            }
        }

    }
}