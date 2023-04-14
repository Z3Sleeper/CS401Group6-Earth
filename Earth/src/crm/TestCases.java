package crm;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class TestCases {

    // Testing to see if Giraffe's card effect works (properly assigns points)
    @Test
    public void testGiraffe() {

        PlayerBoard player = new PlayerBoard();
        player.loadEmptyGrid(new Card());
        List<Card> deck = new ArrayList<Card>();
        NorthernGiraffe giraffe = new NorthernGiraffe();
        for (int i = 0; i < 8; i++) {
            deck.add(new Card("test"));
        }
        player.drawCard(4, deck);
        for (int i = 0; i < 4; i++) {
            player.playCard((i + 1), 1, 1);
        }
        player.addPoints(giraffe.cardEffect(player));

        // Test to see if we didn't gain points (we shouldn't be gaining any yet)
        assertFalse(player.getPoints() > 0);

        player.drawCard(4, deck);
        for (int i = 0; i < 4; i++) {
            player.playCard((i + 1), 3, 1);
        }
        player.addPoints(giraffe.cardEffect(player));

        // Test if we properly gained points
        assertTrue(player.getPoints() > 0);
    }

    // Testing the functionality of all the playerboard token elements (sprout, soil, trunk, canopy)
    @Test
    public void testTokens() {

        PlayerBoard player = new PlayerBoard();

        // Test if we properly gain tokens
        player.addSprout(1);
        player.addSoil(2);
        player.addCanopy(26);
        player.addTrunk(72);
        assertTrue(player.getSprout() == 1);
        assertTrue(player.getSoil() == 2);
        assertTrue(player.getCanopy() == 26);
        assertTrue(player.getTrunk() == 72);
    }

    // Testing the functionality of the playerboard compost and discard functions
    @Test
    public void testCompostAndDiscard() {

        PlayerBoard player = new PlayerBoard();
        List<Card> deck = new ArrayList<Card>();

        for (int i = 0; i < 8; i++) {
            deck.add(new Card("test"));
        }
        player.drawCard(4, deck);

        for (int i = 0; i < 4; i++) {
            player.compostCard(1);;
        }

        // Test to see if we successfully composted our whole hand.
        assertTrue(player.handIsEmpty());

        player.drawCard(4, deck);
        for (int i = 0; i < 4; i++) {
            player.discardCard(1, deck);
        }

        // Test to see if we successfully discarded our whole hand.
        // Test to see if the cards we discarded were returned to the deck.
        assertTrue(player.handIsEmpty());
        assertTrue(deck.size() == 4);
    }
}
