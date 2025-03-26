package test;

import important.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
    Item item = new Item();
    @Test
    void loadItems() {
        assertTrue(item.loadItems());
    }
}