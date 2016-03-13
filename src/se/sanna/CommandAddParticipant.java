package se.sanna;

//Sanna Melke (same3047) och Sophie Lindberg (soli5539)

public class CommandAddParticipant extends Command{ 


    public void execute(Tournament tournament) {
    	String firstname = this.readString("Firstname: ");
		firstname = Command.normaliseName(firstname);
		
		String lastname = this.readString("Lastname: ");
		lastname = Command.normaliseName(lastname);
		
		String teamname = this.readString("Team: ");
		teamname = Command.normaliseName(teamname);
		
		int startnumber = tournament.getStartnumber();

		Participant participant = new Participant (firstname, lastname, startnumber);
		
		Team team = tournament.getOrCreateTeam(teamname);
		
		team.addParticipant(participant);
    }
    
}
