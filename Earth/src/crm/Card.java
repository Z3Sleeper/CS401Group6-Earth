package crm;

// NOTE: ALL cards are subclasses of this card type.
// Override the parent functions listed here in the subclasses you create as necessary.
// Particularly: "secondLine" -> "fifthLine" as well as "cardEffect"

public class Card {
    public int baseVP = 0;
    protected String name;

    public Card() {
        name = "placeholder";
    }

    public Card(String n){
        name = n;
    }

    public String getName(){
        return name;
    }

    public String getType(){
        return secondLine();
    }

    @Override
    public String toString() {
        return name;
    }

    // Unused
    public void printFullCard(){
        System.out.printf("%-20s", "| " + firstLine());
        System.out.print(" |  ");
        System.out.println();
        System.out.printf("%-20s", "| " + secondLine());
        System.out.print(" |  ");
        System.out.println();
        System.out.printf("%-20s", "| " + thirdLine());
        System.out.print(" |  ");
        System.out.println();
        System.out.printf("%-20s", "| " + fourthLine());
        System.out.print(" |  ");
        System.out.println();
        System.out.printf("%-20s", "| " + fifthLine());
        System.out.print(" |  ");
        System.out.println();
    }

    // Name
    public String firstLine() {
        return name;
    }

    // Card Type
    public String secondLine(){
        return "";
    }

    public String thirdLine(){
        return "";
    }

    public String fourthLine(){
        return "";
    }

    public String fifthLine(){
        return "";
    }

    public int sixthLine(){return 0;}
    public int seventhLine(){return 0;}
    public int eighthLine(){return 0;}
    public int ninthLine(){return 0;}
    public String tenthLine(){return "";}
    public String eleventhLine(){return "";}
    public String twelfthLine(){return "";}



    public int cardEffect(PlayerBoard p){
        return 0;
        // This function is for the individual cards' effects.
        // For each card subclass, create this function and fill out the effect as necessary.
    }
}