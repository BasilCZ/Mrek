package command;

public class Help extends Command{
    @Override
    public String execute() {
        return "combine, give, help, history, inventory, look around, move, pickup, talk, use";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
