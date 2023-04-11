package crm;

public class NorthernGiraffe extends Fauna {
    
    public NorthernGiraffe(){
        name = " Northern Giraffe";
        objective1 = " Fill 2+ columns";
        objective2 = "  in your island";
        objective3 = " ";
    }

    public int cardEffect(PlayerBoard p) {
        int count = 0;
        int columnComplete = 0;
        for (int i = 0; i < p.getBoardSize(); i++){
            columnComplete = 0;
            for (int j = 0; j < p.getBoardSize(); j++) {
                if (p.getPlayGrid()[j][i].getName() != "placeholder"){
                    columnComplete++;
                }
                if (columnComplete == 4) {
                    count++;
                }
            }
            if (count == 2) {
                return 1;
            }
        }
        return 0;
    }
}
