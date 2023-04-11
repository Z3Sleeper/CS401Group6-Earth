package crm;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class TestCases {
    // Any lead can be assigned to any online user
    @Test
    public void testGiraffe() {
        Rule rule = new Rule("See if Giraffe works",
        player -> player.getPoints() > 0);
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
        assertFalse(rule.pointsGained(player));

        player.drawCard(4, deck);
        for (int i = 0; i < 4; i++) {
            player.playCard((i + 1), 3, 1);
        }
        player.addPoints(giraffe.cardEffect(player));

        // Test if we properly gained points
        assertTrue(rule.pointsGained(player));
  }
}
