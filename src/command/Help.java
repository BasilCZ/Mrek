package command;

public class Help extends Command{
    @Override
    public String execute() {
        return "help, history, move";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
