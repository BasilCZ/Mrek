package important;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class RoomDialogue {
    private static HashMap<Integer,String> dialogue = new HashMap<>();

    public boolean loadDialogue(){
        try (BufferedReader br = new BufferedReader(new FileReader("look_around_dialogue.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] lines = line.split(";");
                dialogue.put(Integer.parseInt(lines[0]),lines[1]);
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static HashMap<Integer, String> getDialogue() {
        return dialogue;
    }
}
