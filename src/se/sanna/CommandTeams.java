package se.sanna;

public class CommandTeams extends Command{
	
	public void execute (Tournament tournament) {
		tournament.updateMedalCounters();
        tournament.printMedalStandings();

        return;
		
	}

}
