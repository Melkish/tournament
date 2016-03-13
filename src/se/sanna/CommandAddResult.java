package se.sanna;

//Sanna Melke (same3047) och Sophie Lindberg (soli5539)

public class CommandAddResult extends Command{
	
	public void execute(Tournament tournament){
		System.out.print("Startnumber: ");
		int startnumber = scanner.nextInt();
		scanner.nextLine();
		
		Participant participant = tournament.findParticipantByStartnumber(startnumber);
		if (participant == null) {
			System.out.println("There is no participant with that number");
			return;
		}
		
		String eventName = this.readString("Event: ");
		eventName = this.normaliseName(eventName);
		
		Team team = tournament.findTeamByParticipantStartnumber(startnumber);
		
		Event event = tournament.findEventByName(eventName);
		if (event == null) {
			System.out.println("There is no such event");
			return;
		}
		float score = -1;
		while (score < 0) {
			System.out.print("Results for " + participant.getFullName() + " from "
					+ team.getName() + " in " + eventName + ": ");
			score = scanner.nextFloat();
			scanner.nextLine();
		
			if (score < 0) {
				System.out.println("Error, result must be 0 or bigger. Please try again.");
			}
		}
		
		Result result = new Result(startnumber, eventName, score);
		
		if (!event.addResult(result)) {
			System.out.println("Too many attempts!");
			return;
		}
	}
}
