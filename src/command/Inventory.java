package command;
import important.Player;

public class Inventory extends Command {
    private Player p = new Player();

    @Override
    public String execute() {
        return String.valueOf(p.getInventory());
    }

    @Override
    public boolean exit() {
        return false;
    }
}
