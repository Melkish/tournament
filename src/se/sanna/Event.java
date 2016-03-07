package se.sanna;

import java.util.ArrayList;

public class Event {
	private String name;
	private int tries;
	private boolean higherIsBetter;
	private ArrayList<Result> results = new ArrayList<Result>();
	
	public Event(String name, int tries, boolean higherIsBetter) {
		this.name = name; 
		this.tries = tries;
		this.higherIsBetter = higherIsBetter;
	}
	
	public boolean addResult(Result result) {
		int i = 0;
		for (Result r: this.results){
			if (r.getStartnumber() == result.getStartnumber()){
				i++;
			}
		}
		if (i<tries) {
			results.add(result);
			return true;
		} else {
			return false;
		}
		
	}
	
	public int getTries(){
		return this.tries;
	}
	
	public String getName() {
		return this.name;
	}
	
	public ArrayList<Result> getResults() {
		return this.results;
	}
	
	public boolean getHigherIsBetter() {
		return this.higherIsBetter;
	}
	
	public void removeResultForParticipantByStartnumber (int startnumber) {
		int[] matchingIndexes = new int[tries];
		int counter = 0;
		for (int i = 0 ; i < results.size() ; i++) {
			Result r = results.get(i);
			if (r.getStartnumber() == startnumber){
				matchingIndexes[counter] = i;
				counter++;
			}
		}
		for (int i = counter - 1 ; i > -1 ; i--) {
			results.remove(matchingIndexes[i]);
		}
	}
	
    @Override
    public String toString() {
        return "Event{" +
                "eventname=" + name +
                "tries=" + tries +
                "a higher result is better than a low result=" + higherIsBetter +
                "results=" + results +
                '}';
    }

	@Override
	public boolean equals(Object o) {
		Event event = (Event) o;
		return name.equals(event.name);
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}
}
