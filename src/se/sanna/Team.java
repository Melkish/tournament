package se.sanna;
import java.util.ArrayList;
import java.util.Comparator;


public class Team implements Comparable {
	private String name;
	private ArrayList<Participant> participants = new ArrayList<Participant>();
	private int goldCounter;
	private int silverCounter;
	private int bronsCounter;
	
	public ArrayList<Participant> getParticipants() {
		return this.participants;
	}
	
	public Team (String name) {
		this.name = name;
	}
	public void addParticipant(Participant participant){
		this.participants.add(participant);
	}
	public String getName(){
		return this.name;
	}
	
	public void removeParticipant(Participant participant){
		this.participants.remove(participant);
	}

	public boolean teamIsEmpty(){
		if (participants.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public int getGoldCounter() {
		return this.goldCounter;
	}

	public int getSilverCounter() {
		return this.silverCounter;
	}

	public int getBronsCounter() {
		return this.bronsCounter;
	}

	public void addGold() {
		this.goldCounter++;
	}

	public void addSilver() {
		this.silverCounter++;
	}

	public void addBrons() {
		this.bronsCounter++;
	}

	public void resetMedals() {
		this.bronsCounter = 0;
		this.silverCounter = 0;
		this.goldCounter = 0;
	}

	@Override
	public int compareTo(Object o) {
		Team other = (Team) o;
		if (this.goldCounter > other.goldCounter) {
			return -1;
		} else if (this.goldCounter < other.goldCounter) {
			return 1;
		} else {
			if (this.silverCounter > other.silverCounter) {
				return -1;
			} else if (this.silverCounter < other.silverCounter) {
				return 1;
			} else {
				if (this.bronsCounter > other.bronsCounter) {
					return -1;
				} else if (this.bronsCounter < other.bronsCounter) {
					return 1;
				} else {
					return 0;
				}
			}
		}
	}



	@Override
    public String toString() {
        return "Teams{" +
                "teamname=" + name +
                "participants=" + participants +
                '}';
    }
}

