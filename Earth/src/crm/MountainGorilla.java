package crm;

public class MountainGorilla extends Fauna { 

    public MountainGorilla() {
        name = "    Mountain Gorilla    ";
        objective1 = " 4+ Flora, "; 
        objective2 = " filled with as many trunks & compost ";
        objective3 = " having no sprout or growth space counts as filled";
           
    }

    public int cardEffect(PlayerBoard p) { 
        int count = 0; 
        for (int i=0; i< p.getBoardSize(); i++) {
            for (int j = 0; j < p.getBoardSize(); j++) {
                
                // FIXME: Once we have Flora, change this line to:
                //  p.getPlayGrid()[i][j].getType() == (string for Flora's type, ex: "     <Flora>")
                // Then add another condition for the "filled" part described above.
                if (p.getPlayGrid()[i][j].getName() != "placeholder"){
                    count++;
                }
            }
            if (count == 4) {
                return 1;
            }
        }
        return 0;
    }
}