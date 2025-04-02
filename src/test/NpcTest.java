package test;

import important.Npc;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NpcTest {
    Npc npc = new Npc();

    @Test
    void loadNpc() {
        assertTrue(npc.loadNpc());
    }
}