package se.sanna;

import java.util.ArrayList;

public class CommandParticipant extends Command{

	public void execute(Tournament tournament) {
		System.out.print("Startnumber: ");
		int startnumber = scanner.nextInt();
		scanner.nextLine();
		
		Participant participant = tournament.findParticipantByStartnumber(startnumber);
		if (participant == null) {
			System.out.print("No participant with number " + startnumber + ".");
			return;
		}
		
		ArrayList<Result> participantResults = tournament.findResultsByStartnumber(startnumber);
		if (participantResults.isEmpty()) {
			System.out.println("Error, no results for the participant " + participant.getFullName() + " found.");
			return;
		}
		String lastReadEventName = participantResults.get(0).getEventName();
		String allResultsPerEvent = " ";
		for (Result r : participantResults) {
			if (lastReadEventName.equals(r.getEventName())) {
				allResultsPerEvent = allResultsPerEvent + r.getScore()  + ", ";
			} else {
				System.out.println("Result for participant " + participant.getFullName() + " in " 
						+ lastReadEventName + ":" + allResultsPerEvent);
				lastReadEventName = r.getEventName();
				allResultsPerEvent = " " + r.getScore() + ", ";
			}
		}
		System.out.println("Result for participant " + participant.getFullName() + " in " 
		+ lastReadEventName + ":" + allResultsPerEvent);
	}
}
