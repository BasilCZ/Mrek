package command;
import important.Player;

public class Inventory extends Command {

    @Override
    public String execute() {
        Player p = new Player();
        return String.valueOf(p.getInventory());
    }

    @Override
    public boolean exit() {
        return false;
    }
}
