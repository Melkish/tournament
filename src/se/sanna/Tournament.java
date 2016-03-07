package se.sanna;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Tournament {

    private ArrayList<Event> events = new ArrayList<Event>();
    private ArrayList<Team> teams = new ArrayList<Team>();
    private int startnumberCounter = 100;

    public static void main(String[] args) {

        Tournament tournament = new Tournament();
        tournament.theCommandLoop();
    }

    private void theCommandLoop() {

        Command command = Command.getCommand(this);
        while (!(command instanceof CommandExit)) {
			System.out.println("");
            command.execute(this);
            command = Command.getCommand(this);
        }
        System.out.print("Bye");
    }
    
    public int getStartnumber(){
    	return startnumberCounter++;
    }
    
    public Event findEventByName(String name) {
    	for (Event e : events){
    		if (e.getName().equals(name)) {
    			return e;
    		}
    	}
    	return null;
    }
    
    public Participant findParticipantByStartnumber(int startnumber) {
    	for (Team t : teams) {
    		for (Participant p : t.getParticipants()) {
    			if (p.getStartnumber() == startnumber) {
    				return p;	
    			}
    		}
    	}
    	return null;
    		
    }

    public Team findTeamByParticipantStartnumber(int startnumber) {
    	for (Team t : teams) {
    		for (Participant p : t.getParticipants()) {
    			if (p.getStartnumber() == startnumber) {
    				return t;
    			}
    		}
    	}
    	return null;
    }

	public ArrayList<CalculatedResult> findCalculatedResultsForEventName (String eventName) {

		ArrayList<CalculatedResult> calculatedResults =new ArrayList<CalculatedResult>();

		Event event = this.findEventByName(eventName);
		ArrayList<Result> results = event.getResults();
		Collections.sort(results);
		if (event.getHigherIsBetter()) {
			Collections.reverse(results);
		}
		ArrayList<Result> uniqueResults = new ArrayList<Result>();
		for (Result r : results) {
			if (!alreadyAdded(uniqueResults, r.getStartnumber())) {
				uniqueResults.add(r);
			}
		}
		int counter = 0;
		int skips = 1;
		float lastScore = -1;

		for (Result r : uniqueResults) {
			if (r.getScore() != lastScore) {
				counter = counter + skips;
				skips = 1;
			} else {
				skips++;
			}


			Participant participant = this.findParticipantByStartnumber(r.getStartnumber());

			CalculatedResult calculatedResult = new CalculatedResult(r.getScore(), counter, participant,
					this.findEventByName(eventName));
			calculatedResults.add(calculatedResult);
			lastScore = r.getScore();
		}
		return calculatedResults;
	}


	private boolean alreadyAdded(ArrayList<Result> results, int startnumber) {
		for (Result r : results) {
			if (r.getStartnumber() == startnumber) {
				return true;
			}
		}
		return false;
	}
    
    public void reinitialize() {
		this.events = new ArrayList<Event>();
		this.teams = new ArrayList<Team>();
		this.startnumberCounter = 100;
    }
    
    public ArrayList<Result> findResultsByStartnumber(int startnumber) {
    	ArrayList<Result> participantResults = new ArrayList<Result>();
    	for (Event e : events) {
    		for (Result r : e.getResults()) {
    			if (r.getStartnumber() == startnumber) {
    				participantResults.add(r);
    			}
    		}
    	}
    	return participantResults;
    }

	public ArrayList<Team> getTeams() {
		return teams;
	}
    
    public void removeParticipantResults (int startnumber) {
    	for (Event e : events) {
			e.removeResultForParticipantByStartnumber(startnumber);
    	}
    }

    public void addEvent(Event event) {
        if (events.contains(event)) {
        	System.out.println("Error, event already exists");
        } else {
        	events.add(event);
        }
    }

	public void updateMedalCounters() {
		for (Team t : this.teams) {
			t.resetMedals();
			for (Event e : this.events) {
				ArrayList<CalculatedResult> calcResults = findCalculatedResultsForEventName(e.getName());
				for (CalculatedResult c : calcResults) {
					int startnumber = c.getParticipant().getStartnumber();
					if (c.getCalculatedPosition() == 1 && t.equals(findTeamByParticipantStartnumber(startnumber))) {
						t.addGold();
					}
					if (c.getCalculatedPosition() == 2 && t.equals(findTeamByParticipantStartnumber(startnumber))) {
						t.addSilver();
					}
					if (c.getCalculatedPosition() == 3 && t.equals(findTeamByParticipantStartnumber(startnumber))) {
						t.addBrons();
					}
				}
			}
		}
	}

	public void printMedalStandings() {

		System.out.println("1st    2nd    3rd    Team name");
		System.out.println("***************************************");
		Collections.sort(this.teams);
		for(Team t : teams) {
			System.out.println(t.getGoldCounter() + "      " + t.getSilverCounter() +
					"      " + t.getBronsCounter() + "      " + t.getName());
		}

	}
    
    public Team getOrCreateTeam(String teamname) {
    	for(Team team: teams) {
    		if (team.getName().equals(teamname)) {
    			return team;
    		}
    	}
    	Team team = new Team(teamname);
    	teams.add(team);
    	return team;
    }

    @Override
    public String toString() {
        return "Tournament{" +
                "events=" + events +
                "teams=" + teams +
                '}';
    }
}
