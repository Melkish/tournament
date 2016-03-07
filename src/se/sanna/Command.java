package se.sanna;

import java.util.Scanner;

public class Command {
    public static Scanner scanner = new Scanner(System.in);

    public static Command getCommand(Tournament tournament) {
        System.out.print("Command> ");
        String commandString = scanner.nextLine();
        commandString = normaliseName(commandString);

        
        if (commandString.equals("Add event")) {
        	return new CommandAddEvent();
        } else if (commandString.equals("Exit")) {
			return new CommandExit();
		} else if (commandString.equals("Add participant")) {
			return new CommandAddParticipant();
		} else if (commandString.equals("Add result")) {
			return new CommandAddResult();
		} else if (commandString.equals("Participant")) {
			return new CommandParticipant();
		} else if (commandString.equals("Remove participant")) {
			return new CommandRemoveParticipant();
		} else if (commandString.equals("Teams")) {
			return new CommandTeams();
		} else if (commandString.equals("Reinitialize")) {
			return new CommandReinitialize();
		} else if (commandString.startsWith("Message")) {
			return new CommandMessage(commandString);
		} else if (commandString.equals(getEventUsingString(commandString, tournament))) {
			return new CommandResultsPerEvent(commandString);
		}

        return new CommandUnknown();
    }
    
    
    public static String getEventUsingString(String commandString, Tournament tournament) {
    	String normalisedName = normaliseName(commandString);
    	Event event = tournament.findEventByName(normalisedName);
    	if (event != null) {
    		String eventName = event.getName();
    		return eventName;
    	}
    	return null;
    }

    public void execute(Tournament tournament) {
        System.out.println("Oops, I forgot to override this in my subclass");
    }


    protected static String normaliseName(String originalName){
    	String trimmedName = originalName.trim();
    	String firstLetter = trimmedName.substring(0, 1);
    	String firstLetterUpperCase = firstLetter.toUpperCase();
    	if (originalName.length()==1) {
    		return firstLetterUpperCase;
    	}	
    	String theRest = trimmedName.substring(1);
    	String theRestLowerCase = theRest.toLowerCase();
    	return firstLetterUpperCase + theRestLowerCase; 
    }
    
    protected String readString(String question){
    String value = null;
	do{
		System.out.print(question);
		value = scanner.nextLine();
	
	 } while (value == null);
     return value;
    }
}
