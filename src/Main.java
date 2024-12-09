import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

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

        System.out.print("Please enter number of rows: ");
        byte rows = scanner.nextByte();

        System.out.print("Please enter number of columns: ");
        byte columns = scanner.nextByte();

        int[][] seats = new int[rows][columns];

        seats[0][0] = 1;

        switch (choice) {
            case 1:
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
                break;
            case 2:
                System.out.print("Please enter the seat code to book (e.g., B3): ");
                String seatCodeToBook = scanner.nextLine();
                String seatCodeLetter = seatCodeToBook.substring(0, 1);
                String seatCodeNumber = seatCodeToBook.substring(1);
                System.out.println(seatCodeLetter);
                System.out.println(seatCodeNumber);

        }

    }
}