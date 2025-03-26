package test;

import org.junit.jupiter.api.Test;
import world.Location;

import static org.junit.jupiter.api.Assertions.*;

class LocationTest {
    Location loc = new Location("Prison",0,new String[]{"2","-1","-1","-1"},false);
    @Test
    void checkNeighbors() {
        assertEquals(2,loc.checkNeighbors(loc,0));
        assertEquals(-1,loc.checkNeighbors(loc,1));
    }
}