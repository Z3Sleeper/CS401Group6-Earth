 
 //NEEDS MORE WORK 
 package crm;
public class Terrain extends Card {
    protected final String type = "     <Terrain>";
    protected String VP_effect;
    protected String terrain1;
    protected String terrain2;

    public Terrain() {
        name = "";
        VP_effect = "";
        terrain1 = "";
        terrain2 = "";
    }

    public String getType(){
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
        return terrain1;
    }

    public String fifthLine(){
        return terrain2;
    }
}
