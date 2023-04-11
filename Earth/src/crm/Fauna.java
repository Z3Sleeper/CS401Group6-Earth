package crm;

public class Fauna extends Card {
    protected final String type = "     <Fauna>";
    // These are just the card text for the objectives split into three strings for printing purposes
    protected String objective1;
    protected String objective2;
    protected String objective3;

    public Fauna() {
        name = "";
        objective1 = "";
        objective2 = "";
        objective3 = "";
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return name;
    }

    public String secondLine(){
        return type;
    }

    public String thirdLine(){
        return objective1;
    }

    public String fourthLine(){
        return objective2;
    }

    public String fifthLine(){
        return objective3;
    }
}