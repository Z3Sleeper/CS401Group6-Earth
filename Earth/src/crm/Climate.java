package crm;

public class Climate extends Card {
    protected final String type = "     <Climate>";
    protected String VP_effect;
    protected String climate1;
    protected String climate2;
    protected String event1;
    protected String event2;

    public Climate() {
        name = "placeholder";
        VP_effect = "";
        climate1 = "";
        climate2 = "";
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
        return climate1;
    }

    public String tenthLine(){
        return climate2;
    }
    public String eleventhLine(){return event2;}
    public String twelfthLine(){return event2;}
}