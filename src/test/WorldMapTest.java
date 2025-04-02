package test;

import org.junit.jupiter.api.Test;
import world.WorldMap;

import static org.junit.jupiter.api.Assertions.*;

class WorldMapTest {
    WorldMap wm = new WorldMap();

    @Test
    void loadMap() {
        assertTrue(wm.loadMap());
    }
}