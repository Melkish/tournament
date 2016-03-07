package se.sanna;

public class CommandAddEvent extends Command {


    public void execute(Tournament tournament) {
    	String name = this.readString("Name: ");
    	name = Command.normaliseName(name);
    	
    	int tries = -1;
    	while (tries < 0) {
    		System.out.print("Tries: ");
    		tries = scanner.nextInt();
    		scanner.nextLine();
		
			if (tries < 0) {
				System.out.println("Error, tries have to be 0 or bigger. Please try again.");
			}
    	}
		
		boolean questionIsAnswered = false;
		boolean higherIsBetter = false;
		while (!questionIsAnswered){
			System.out.print("Is a high result better than a low result? ");
		String result = scanner.nextLine();
		if (result.equalsIgnoreCase("yes")) {
			 higherIsBetter = true;
			 questionIsAnswered = true;
			} else if (result.equalsIgnoreCase("y")) {
			 higherIsBetter = true;
			 questionIsAnswered = true;
			} else if (result.equalsIgnoreCase("no")) {
			 higherIsBetter = false;
			 questionIsAnswered = true;
			} else if (result.equalsIgnoreCase("n")) {
			 higherIsBetter = false;
			 questionIsAnswered = true;
			} else {
				System.out.println("Error, please try again");
			}
		}

        Event event = new Event(name, tries, higherIsBetter);
        tournament.addEvent(event);

    }
}
