package crm;

public class YellowBelliedMarmot extends Fauna {

    public YellowBelliedMarmot() {
        name = " Yellow Bellied Marmot"; 
        objective1 = " 6+ Flora"; 
        objective2 = " Each with 4+ sprouts"; 
        objective3 = "";
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
