package crm;

public class Ladybug extends Fauna {
    
    public Ladybug(){
        name = "     Ladybug     ";
        objective1 = " 11+ cards, each";
        objective2 = "  with a base VP";
        objective3 = "  of 3-";
    }

    //FIXME:
    /*public int cardEffect(PlayerBoard p) { 
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
    } */
}
