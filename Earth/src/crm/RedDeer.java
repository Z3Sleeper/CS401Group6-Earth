package crm;

public class RedDeer extends Fauna {

    public RedDeer() { 
        name = " Red Deer"; 
        objective1 = " 6+ Flora"; 
        objective2 = " each with 3- soil tokens"; 
        objective3 = ""; 
        
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
