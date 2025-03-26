package test;

import important.Item;
import important.Player;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
class PlayerTest {

    Player player = new Player();
    @Test
    void getInventory() {
    }

    @Test
    void addToInventory() {
        player.addToInventory(new Item("Test","Just a test",1,5,6,1,"Test"));
        assertNotEquals(null, player.getInventory());
        player.removeFromInventory(1);
    }

    @Test
    void removeFromInventory() {
        player.addToInventory(new Item("Test","Just a test",3,5,7,7,"Test"));
        player.removeFromInventory(2);
        assertNotEquals(null,player.getInventory());
        player.removeFromInventory(3);
        assertEquals(new ArrayList<>(),player.getInventory());
    }
}