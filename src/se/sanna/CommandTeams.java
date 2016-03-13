package se.sanna;

//Sanna Melke (same3047) och Sophie Lindberg (soli5539)

public class CommandTeams extends Command{
	
	public void execute (Tournament tournament) {
		tournament.updateMedalCounters();
        tournament.printMedalStandings();

        return;
		
	}

}
