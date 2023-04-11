package crm;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Earth {
    private Scanner scan = new Scanner(System.in); // Create a Scanner object
    private final int maxPlayers = 5;
    private final int minPlayers = 1;
    private PlayerBoard[] players;
    private List<Card> deck = new ArrayList<Card>();
    private Card[] faunaBoard = new Card[4];

    public Earth() {
        intro();
        initPlayers();
        loadCardsIntoDeck();
        loadFaunaBoard();
    }


    // Everything else (not listed in 'Earth()') in the game happens here.
    // TODO: Everything else required here.
    public void GameStartBeginner() {
        int inputInt1 = 0;
        int inputInt2 = 0;
        int inputInt3 = 0;
        boolean quit = false;

        while (!quit) {
            // Round Start
            // Cycle through players in order
            for (int i = 0; i < players.length; i++) {

                // Print the fauna board.
                printFaunaBoard();

                // Start i player's turn.
                System.out.println(players[i].getName() + "'s turn.");

                // Card Drawing
                // NOTE: Not sure if this belongs here. Haven't read the rules up to here yet, was just testing functionality.
                System.out.println(players[i].getName() + " draws " + 1 + " card.");
                players[i].drawCard(1, this.deck);

                // Print player i's points.
                System.out.println(players[i].getName() + " has " + players[i].getPoints() + " point(s).");
                players[i].printGrid();

                // Print player i's hand.
                // Allow them to play a card or pass (NOTE: Not sure if passing is allowed, check rules)
                // Print out their grid after playing a card.
                // NOTE: Check if you're allowed to replace a card on the grid. If not, FIXME by fixing the 'playCard' function.
                if (!players[i].handIsEmpty()) {
                    System.out.println(players[i].getName() + "'s hand.");
                    players[i].printHand();
                    System.out.println("Pick a card to play (0 to pass).");
                    inputInt3 = scan.nextInt();
                    if (inputInt3 > 0 && inputInt3 < players[i].getHandSize() + 1) {
                        System.out.println("Place the card on your field (input row, then column, 1-4).");
                        inputInt1 = scan.nextInt();
                        inputInt2 = scan.nextInt();
                        players[i].playCard(inputInt1,inputInt2,inputInt3);

                        // Check Fauna board and assign points
                        for (int j = 0; j < 4; j++) {
                            players[i].addPoints(faunaBoard[j].cardEffect(players[i]));
                        }
                        
                        System.out.println(players[i].getName() + " has " + players[i].getPoints() + " point(s).");
                        players[i].printGrid();
                    }
                } else {
                    System.out.println(players[i].getName() + "'s hand is empty.");
                }
                System.out.println();
                System.out.println();
            }
            System.out.print("Continue? (0 = no | 1 = yes): ");
            inputInt1 = scan.nextInt();
            if (inputInt1 == 0) {
                quit = true;
            }
        }
    }

    private void intro(){
        System.out.println("This is a console-based version of Earth");
        System.out.println();
    }

    private void initPlayers() {
        String inputString = "";
        int inputInt = 0;

        while (inputInt < minPlayers || inputInt > maxPlayers) {
            System.out.print("Set playercount (1-5): ");
            inputInt = Integer.parseInt(scan.nextLine());
            players = new PlayerBoard[inputInt];
        }

        for (int i = 0; i < inputInt; i++) {
            PlayerBoard p = new PlayerBoard();
            p.loadEmptyGrid(new Card());
            System.out.print("Enter player " + (i+1) + "'s name: ");
            inputString = scan.nextLine();
            p.setName(inputString);
            players[i] = p;
        }
    }

    // Set up the Game Board.
        // This is essentially just showing four Fauna cards
        //  as objectives for players to complete. So instead
        //  of making a whole main board, we're just gonna throw
        //  up 4 random Fauna cards on a new grid created here.
    // TODO: Add more Fauna cards.
    // Ideally this takes a pool of Fauna cards and randomizes its selection of 4 of them.
    // For now we're going to just need 4 random Fauna cards first. We can worry about more
    //  and the randomizer thing later.
    private void loadFaunaBoard() {
        faunaBoard[0] = new NorthernGiraffe();
        faunaBoard[1] = new Ladybug();
        faunaBoard[2] = new BarnOwl();
        faunaBoard[3] = new EuropeanMole();
    }

    // This just prints out the cards on the Fauna Board
    private void printFaunaBoard(){
        System.out.println("Fauna Board:");
        for (int i = 0; i < 4; i++) {
            System.out.printf("%-20s", "| " + faunaBoard[i].firstLine());
            System.out.print(" |  ");
        }
        System.out.println();
        for (int i = 0; i < 4; i++) {
            System.out.printf("%-20s", "| " + faunaBoard[i].secondLine());
            System.out.print(" |  ");
        }
        System.out.println();
        for (int i = 0; i < 4; i++) {
            System.out.printf("%-20s", "| " + faunaBoard[i].thirdLine());
            System.out.print(" |  ");
        }
        System.out.println();
        for (int i = 0; i < 4; i++) {
            System.out.printf("%-20s", "| " + faunaBoard[i].fourthLine());
            System.out.print(" |  ");
        }
        System.out.println();
        for (int i = 0; i < 4; i++) {
            System.out.printf("%-20s", "| " + faunaBoard[i].fifthLine());
            System.out.print(" |  ");
        }
        System.out.println();
    }

    // Loads the cards into the deck list
    // For now we just have a Northern Giraffe card here to mess around with.
    // NOTE: Fauna cards aren't meant to be played on the playerboards at all, they are objectives on the game board.
    private void loadCardsIntoDeck() {
        deck.add(new NorthernGiraffe());
        deck.add(new Ladybug());
        deck.add(new NorthernGiraffe());
        deck.add(new Ladybug());
        deck.add(new NorthernGiraffe());
        deck.add(new Ladybug());
        deck.add(new NorthernGiraffe());
        deck.add(new Ladybug());
        deck.add(new NorthernGiraffe());
        deck.add(new Ladybug());
        deck.add(new NorthernGiraffe());
        deck.add(new Ladybug());
        deck.add(new NorthernGiraffe());
        deck.add(new Ladybug());
        deck.add(new NorthernGiraffe());
        deck.add(new Ladybug());
        deck.add(new NorthernGiraffe());
        deck.add(new Ladybug());
        deck.add(new NorthernGiraffe());
        deck.add(new Ladybug());
        deck.add(new NorthernGiraffe());
        deck.add(new Ladybug());
    }
}