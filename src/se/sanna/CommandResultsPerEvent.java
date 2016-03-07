package se.sanna;

import java.util.ArrayList;
import java.util.Collections;

public class CommandResultsPerEvent extends Command{
	
	private String eventName;
	
	public CommandResultsPerEvent(String eventName) {

		this.eventName = Command.normaliseName(eventName);
	}
	
	public void execute (Tournament tournament) {

        System.out.println("Results for " + this.eventName);
        ArrayList<CalculatedResult> calculatedResults = tournament.findCalculatedResultsForEventName(this.eventName);
        for (CalculatedResult r: calculatedResults) {
            System.out.println(r.getCalculatedPosition() + " " + r.getScore() + " " + r.getParticipant().getFullName());
        }

	}
	
}
