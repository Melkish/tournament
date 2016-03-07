package se.sanna;


public class CommandUnknown extends Command {
    public void execute(Tournament tournament) {
        System.out.println("Unknown command");
    }
}
