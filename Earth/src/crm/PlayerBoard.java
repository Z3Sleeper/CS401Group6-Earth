package crm;

import java.util.List;
import java.util.ArrayList;

public class PlayerBoard {
    private final int boardSize = 4;
    private String name;
    private int sprout;
    private int soil;
    private int trunk;
    private int canopy;
    private int points;
    private Climate climate;
    private Island island;
    private Card[][] playGrid = new Card[boardSize][boardSize];
    private List<Card> hand = new ArrayList<Card>();

    public PlayerBoard() {
        name = "";
        sprout = 0;
        soil = 0;
        trunk = 0;
        canopy = 0;
        points = 0;
        climate = new Climate();
        island = new Island();
        loadEmptyGrid(new Card());
    }

    public int getBoardSize(){
        return boardSize;
    }

    public String getName() {
        return name;
    }

    public int getSprout() {
        return sprout;
    }

    public void addSprout(int x) {
        sprout += x;
    }

    public int getSoil() {
        return soil;
    }

    public void addSoil(int x) {
        soil += x;
    }

    public int getTrunk() {
        return trunk;
    }

    public void addTrunk(int x) {
        trunk += x;
    }

    public int getCanopy() {
        return canopy;
    }

    public void addCanopy(int x) {
        canopy += x;
    }

    public Card[][] getPlayGrid(){
        return playGrid;
    }

    public int getPoints() {
        return points;
    }

    public List<Card> getHand(){
        return hand;
    }

    public void setIsland(Island i){
        island = i;
    }

    public void setClimate(Climate c){
        climate = c;
    }

    public void printIslandClimate(){
        System.out.println("Island: " + island.toString() + "\nClimate: " + climate.toString());
    }
    
    public void loadEmptyGrid(Card x){
        for (int a = 0; a<boardSize; a++){
            for (int b = 0; b<boardSize; b++){
                playGrid[a][b] = x;
            }
        }
    }

    public void addPoints(int p) {
        points += p;
    }

    public void setName(String n) {
        name = n;
    }

    // Returns the number of cards in the hand list.
    // To get an accurate count of the cards in hand,
    //  add 1 to the return.
    public int getHandSize(){
        return hand.size();
    }

    public void printHand() {
        System.out.print("  ");
        for (int b = 0; b<hand.size(); b++){
            System.out.printf("%-20s", "| " + hand.get(b).firstLine());
            System.out.print(" |  ");
        }
        System.out.println();
        System.out.print("  ");
        for (int b = 0; b<hand.size(); b++){
            System.out.printf("%-20s", "| " + hand.get(b).secondLine());
            System.out.print(" |  ");
        }
        System.out.println();
        System.out.print("  ");
        for (int b = 0; b<hand.size(); b++){
            System.out.printf("%-20s", "| " + hand.get(b).thirdLine());
            System.out.print(" |  ");
        }
        System.out.println();
        System.out.print("  ");
        for (int b = 0; b<hand.size(); b++){
            System.out.printf("%-20s", "| " + hand.get(b).fourthLine());
            System.out.print(" |  ");
        }
        System.out.println();
        System.out.print("  ");
        for (int b = 0; b<hand.size(); b++){
            System.out.printf("%-20s", "| " + hand.get(b).fifthLine());
            System.out.print(" |  ");
        }
        System.out.println();
        System.out.println("             1                       2                       3                       4                       5");
    }

    public boolean handIsEmpty() {
        if (hand.isEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }

    public void playCard(int a, int b, int c) {
        if (a > 0 && b > 0 && playGrid[a-1][b-1].getName() == "placeholder") {
            playGrid[a-1][b-1] = this.hand.get(c-1);
            hand.remove(c-1);
        }
    }

    // Draw x amount of cards.
    // Check if the deck is empty before attempting to draw.
    public void drawCard(int x, List<Card> d) {
        for (int a = 0; a < x; a++) {
            if (!d.isEmpty() && hand.size() < 5) {
                this.hand.add(d.get(d.size() - 1));
                d.remove((d.size() - 1));
            }
            else {
                if (hand.size() < 5) {
                    System.out.println("Your hand is full.");
                }
                else {
                    System.out.println("The deck is empty.");
                }
                break;
            }
        }
    }

    public void printGrid() {
        for (int a = 0; a<boardSize; a++){
            System.out.print(a+1 + " ");
            for (int b = 0; b<boardSize; b++){
                System.out.printf("%-20s", "| " + playGrid[a][b].firstLine());
                System.out.print(" |  ");
            }
            System.out.println();
            System.out.print("  ");
            for (int b = 0; b<boardSize; b++){
                System.out.printf("%-20s", "| " + playGrid[a][b].secondLine());
                System.out.print(" |  ");
            }
            System.out.println();
            System.out.print("  ");
            for (int b = 0; b<boardSize; b++){
                System.out.printf("%-20s", "| " + playGrid[a][b].thirdLine());
                System.out.print(" |  ");
            }
            System.out.println();
            System.out.print("  ");
            for (int b = 0; b<boardSize; b++){
                System.out.printf("%-20s", "| " + playGrid[a][b].fourthLine());
                System.out.print(" |  ");
            }
            System.out.println();
            System.out.print("  ");
            for (int b = 0; b<boardSize; b++){
                System.out.printf("%-20s", "| " + playGrid[a][b].fifthLine());
                System.out.print(" |  ");
            }
            System.out.println();
            System.out.println();
        }
        System.out.println("             1                       2                       3                       4");
    }
}