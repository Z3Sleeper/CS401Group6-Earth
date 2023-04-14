package crm;

public class Island extends Card {
    protected final String type = "     <Island>";

    protected String Habitat1;
    protected String Habitat2;
    protected int Soil;
    protected int Compost;
    protected int CardsDrawn;


    public Island() {
        name = "placeholder";
        baseVP = 0;
        Habitat1 = "";
        Habitat2 = "";
        Soil = 0;
        Compost = 0;
        CardsDrawn = 0;
    }

    public Island(String n, int base_VP, String _Habitat1, String _Habitat2, int _Soil, int _Compost, int Cards_Drawn) {
        name = n;
        baseVP = base_VP;
        Habitat1 = _Habitat1;
        Habitat2 = _Habitat2;
        Soil = _Soil;
        Compost = _Compost;
        CardsDrawn = Cards_Drawn;
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
    public int sixthLine(){return baseVP;}
    public String thirdLine(){
        return Habitat1;
    }
    public String fourthLine(){
        return Habitat2;
    }
    public int seventhLine(){return Soil;}
    public int eighthLine(){return Compost;}
    public int ninthhLine(){return CardsDrawn;}


}



