import java.util.Random;
import java.util.Scanner;

public class PuppySearchGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Enter the number of rooms per floor: ");
        int numRooms = scanner.nextInt();
        System.out.print("Enter the number of floors: ");
        int numFloors = scanner.nextInt();

        char[][] building = new char[numFloors][numRooms];

        int puppyFloor = random.nextInt(numFloors);
        int puppyRoom = random.nextInt(numRooms);
        int player1Floor = random.nextInt(numFloors);
        int player1Room = random.nextInt(numRooms);
        int player2Floor = random.nextInt(numFloors);
        int player2Room = random.nextInt(numRooms);

        building[puppyFloor][puppyRoom] = 'P';
        building[player1Floor][player1Room] = '1';
        building[player2Floor][player2Room] = '2';

        System.out.println("Initial state:");
        printBuilding(building);

        while (true) {
            System.out.print("Player 1, press Enter to search...");
            scanner.nextLine(); // Consume the Enter key press
            building[player1Floor][player1Room] = ' ';
            player1Floor = random.nextInt(numFloors);
            player1Room = random.nextInt(numRooms);
            building[player1Floor][player1Room] = '1';
            printBuilding(building);

            if (player1Floor == puppyFloor && player1Room == puppyRoom) {
                System.out.println("Player 1 found the puppy! Player 1 wins!");
                building[puppyFloor][puppyRoom] = '*';
                break;
            }

            System.out.print("Player 2, press Enter to search...");
            scanner.nextLine(); // Consume the Enter key press
            building[player2Floor][player2Room] = ' ';
            player2Floor = random.nextInt(numFloors);
            player2Room = random.nextInt(numRooms);
            building[player2Floor][player2Room] = '2';
            printBuilding(building);

            if (player2Floor == puppyFloor && player2Room == puppyRoom) {
                System.out.println("Player 2 found the puppy! Player 2 wins!");
                building[puppyFloor][puppyRoom] = '*';
                break;
            }
        }

        System.out.println("Final state:");
        printBuilding(building);
    }

    private static void printBuilding(char[][] building) {
        for (char[] floor : building) {
            for (char room : floor) {
                System.out.print(room + " ");
            }
            System.out.println();
        }
    }
}
