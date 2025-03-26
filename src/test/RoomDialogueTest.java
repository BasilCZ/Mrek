package test;

import important.RoomDialogue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomDialogueTest {
    RoomDialogue dialogue = new RoomDialogue();
    @Test
    void loadDialogue() {
        assertTrue(dialogue.loadDialogue());
    }
}