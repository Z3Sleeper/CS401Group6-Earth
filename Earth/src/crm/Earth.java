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
        boolean firstTurn = true;
        int turns = 1;
        int inputInt1 = 0;
        int inputInt2 = 0;
        int inputInt3 = 0;
        boolean quit = false;

        while (!quit) {

            // Start of game setup.
            
            if (firstTurn) {
                
                // Print the fauna board. Do we need to here? I don't know.
                printFaunaBoard();

                // Give each player an Island and Climate card.
                for (int i = 0; i < players.length; i++) {
                    System.out.println();
                    System.out.println("Dealing out Island and Climate cards to " + players[i].getName());
                    players[i].setIsland(new Island());
                    players[i].setClimate(new Climate());
                }

                // Each player draws a number of Earth cards as indicated on their ISLAND card. After reviewing these cards,
                // players choose which ones they want to keep in their hand, and which they will Compost.
                // They must Compost from their hand the number of cards as indicated on their ISLAND card. To Compost a card, the
                // player simply removes it from their hand and places it facedown on the Compost icon on their player board
                // -- this creates their personal Compost. 
                // Each player takes the number of Soil indicated on their ISLAND card
                // and places them on the central area of their player board -- this creates their personal reserve.
                // TODO: Fill in the code here for adding cards to player's hands based on their Island and Climate cards.
                for (int i = 0; i < players.length; i++) {
                    System.out.println();
                    System.out.println("Initializing " + players[i].getName() + "'s resources.");
                    // FIXME: Insert a REAL print function for these cards below.
                    players[i].printIslandClimate();
                    // FIXME: Implement the cards' actual card draw values here.
                    System.out.println("As per " + players[i].getName() + "'s Island card, they draw " + 1 + " card(s).");
                    players[i].drawCard(1, deck);
                    // FIXME: Implement the cards' actual card compost values here.
                    System.out.println("As per " + players[i].getName() + "'s Island card, they must compost " + 1 + " card(s).");
                    players[i].compostCard(1);
                    // FIXME: Implement the cards' actual soil gain values here.
                    System.out.println("As per " + players[i].getName() + "'s Island card, they gain " + 1 + " soil.");
                    players[i].addSoil(0);
                }
            }

            // Round Start
            // Cycle through players in order
            for (int i = 0; i < players.length; i++) {

                System.out.println();
                System.out.println("Starting turn " + turns + ".");

                // Print the fauna board.
                printFaunaBoard();
                System.out.println();

                // Start i player's turn.
                System.out.println(players[i].getName() + "'s turn.");

                // Card Drawing
                // FIXME: Not sure if this belongs here. Haven't read the rules up to here yet, was just testing functionality.
                System.out.println(players[i].getName() + " draws " + 1 + " card.");
                players[i].drawCard(1, this.deck);

                // Print player i's points.
                System.out.println(players[i].getName() + " has " + players[i].getPoints() + " point(s).");
                players[i].printGrid();

                // Print player i's hand.
                // Allow them to play a card or pass (NOTE: Not sure if passing is allowed, check rules)
                // Print out their grid after playing a card.
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

            turns += 1;
            System.out.println("End turn " + turns + ".");
            System.out.print("Continue? (0 = no | 1 = yes): ");
            inputInt1 = scan.nextInt();
            if (inputInt1 == 0) {
                quit = true;
            }
        }
    }

    private void intro(){
        System.out.println();
        System.out.println("This is a console-based version of the Earth board game.\nYou may want to enlarge this window.");
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