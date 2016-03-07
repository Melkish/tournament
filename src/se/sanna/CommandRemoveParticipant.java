package se.sanna;

import java.util.ArrayList;

public class CommandRemoveParticipant extends Command {
	
	public void execute(Tournament tournament){
		System.out.print("Startnumber: ");
		int startnumber = scanner.nextInt();
		scanner.nextLine();
		
		Participant participant = tournament.findParticipantByStartnumber(startnumber);
		if (participant == null) {
			System.out.println("There is no participant with that number");
			return;
		}
		
		Team team = tournament.findTeamByParticipantStartnumber(startnumber);
		
		team.removeParticipant(participant);
		
		tournament.removeParticipantResults(startnumber);

		if (team.teamIsEmpty()==true) {
			ArrayList<Team> teams = tournament.getTeams();
			teams.remove(team);
		}

		
		System.out.println(participant.getFullName() + " from " + team.getName() + " with number " + 
		startnumber + " removed.");
		
	}

}
