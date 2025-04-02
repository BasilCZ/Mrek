package command;

import saving_and_loading.SaveGame;

public class Save extends Command {
    //Saves the game
    @Override
    public String execute() {
        SaveGame save = new SaveGame();
        if (save.save()) {
            return "You have successfully saved the game";
        } else {
            return "The game couldn't be saved";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
