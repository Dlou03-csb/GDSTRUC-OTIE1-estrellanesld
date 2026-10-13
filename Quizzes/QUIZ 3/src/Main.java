import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        ArrayQueue queue = new ArrayQueue(10);
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int gamesMade = 0;
        int turnCounter = 1;
        int playerIdCounter = 1;

        while (gamesMade < 10)
        {

            System.out.println("\n==== Turn " + turnCounter + " ====");

            int x = random.nextInt(7) + 1;
            System.out.println("Enqueuing " + x + " players...");

            for (int i = 0; i < x; i++)
            {

                int randomLevel = random.nextInt(100) + 1;
                queue.enqueue(new Player(playerIdCounter, "Player " + playerIdCounter, randomLevel));
                playerIdCounter++;

            }

            System.out.println("Current players in queue: " + queue.size());

            while (queue.size() >= 5 && gamesMade < 10)
            {
                System.out.println("\n--- Starting Game " + (gamesMade + 1) + " ---");
                System.out.println("Matched Players:");

                for (int i = 0; i < 5; i++) {
                    Player current = queue.dequeue();
                    System.out.println(current.getName() + " (Level " + current.getLevel() + ")");
                }

                gamesMade++;
                System.out.println("Total games made: " + gamesMade + "/10\n");
            }

            if (gamesMade >= 10)
            {
                System.out.println("Matchmaking complete");
                break;
            }

            System.out.print("Enter to end turn...");
            scanner.nextLine();
            turnCounter++;
        }

        scanner.close();
    }
}