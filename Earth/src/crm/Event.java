package crm;

public class Event extends Card {
    protected final String type = "     <Event>";
    protected String VP_effect;
    protected String event1;
    protected String event2;

    public Event() {
        name = "";
        VP_effect = "";
        event1 = "";
        event2 = "";
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
        return VP_effect;
    }

    public String fourthLine(){
        return event1;
    }

    public String fifthLine(){
        return event2;
    }
}