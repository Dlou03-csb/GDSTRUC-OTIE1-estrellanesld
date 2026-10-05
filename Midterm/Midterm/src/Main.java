import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        CardStack playerDeck = new CardStack(30);
        CardStack playerHand = new CardStack(30);
        CardStack discardPile = new CardStack(30);

        for (int i = 1; i <= 30; i++)
        {
            playerDeck.push(new Card("Card " + i));
        }

        System.out.println("The deck has 30 cards. The program will end when the deck is emptied.");

        while (!playerDeck.empty())
        {
            int action = rand.nextInt(3);

            int x = rand.nextInt(5) + 1;

            System.out.println("\n================================================");

            if (action == 0)
            {
                System.out.println("Action: Draw " + x + " cards.");

                for (int i = 0; i < x; i++)
                {
                    if (!playerDeck.empty())
                    {
                        playerHand.push(playerDeck.pop());
                    }

                }

            }

            else if (action == 1)
            {
                System.out.println("Action: Discard " + x + " cards.");

                for (int i = 0; i < x; i++)
                {
                    if (!playerHand.empty())
                    {
                        discardPile.push(playerHand.pop());
                    }
                }

            }

            else if (action == 2)
            {
                System.out.println("Action: Get " + x + " cards.");

                for (int i = 0; i < x; i++)
                {
                    if (!discardPile.empty())
                    {
                        playerHand.push(discardPile.pop());
                    }

                }
            }

            System.out.println("\n==== INVENTORY =====");
            System.out.println("Currently Holding: ");

            if (playerHand.empty())
            {
                System.out.println("Empty");
            }
            else
            {
                playerHand.printStack();
            }

            System.out.println("Remaining Cards in Deck: " + playerDeck.size());
            System.out.println("Cards in Discard Pile: " + discardPile.size());
            System.out.println("================================================");

            if (!playerDeck.empty())
            {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }

        }

        System.out.println("\n===============================================");
        System.out.println(" PLayer deck is empty. Game Over.");
        System.out.println("===============================================");
        scanner.close();

    }

}
