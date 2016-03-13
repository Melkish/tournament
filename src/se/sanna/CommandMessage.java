package se.sanna;

//Sanna Melke (same3047) och Sophie Lindberg (soli5539)

public class CommandMessage extends Command {

    private String message;

    public CommandMessage(String message) {
        this.message = message.toUpperCase();
        this.message = this.message.substring(8);
        if (this.message.length() > 56) {
            this.message = this.message.substring(0, 56);
        }
        while (this.message.length() < 56) {
            this.message = this.message + " ";
        }


    }

	public void execute (Tournament tournament) {
        System.out.println("############################################################");
        System.out.println("#                                                          #");
        System.out.println("# " + this.message + " #");
        System.out.println("#                                                          #");
        System.out.println("############################################################");
        System.out.println("");


		
	}

}
