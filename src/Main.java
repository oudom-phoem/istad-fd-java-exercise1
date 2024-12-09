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

        String[][] seats = new String[rows][columns];

        switch (choice) {
            case 1:
                char charRow = 'A';
                for (int i = 0; i < rows; i++) {
                    System.out.print("[");
                    for (int j = 0; j < columns; j++) {
                        String seatCode = charRow + "-" + (j + 1) + ":";
                        String bookStatus = j == columns - 1 ? "AV" : "AV, ";
                        System.out.print(seatCode + bookStatus);
                    }
                    System.out.print("]");
                    charRow++;
                    System.out.println();
                }

                break;
        }

    }
}