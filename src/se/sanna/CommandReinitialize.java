package se.sanna;

//Sanna Melke (same3047) och Sophie Lindberg (soli5539)

public class CommandReinitialize extends Command{
	
	public void execute(Tournament tournament){
		tournament.reinitialize();
		System.out.println("############################################################");
		System.out.println("#                                                          #");
		System.out.println("# ALL DATA HAS BEEN REMOVED                                #");
		System.out.println("#                                                          #");
		System.out.println("############################################################");
		System.out.println("");
	}

}
