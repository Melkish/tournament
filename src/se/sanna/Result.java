package se.sanna;

public class Result implements Comparable{
	private int startnumber;
	private String eventName;
	private float score;
	
	public Result (int startnumber, String eventName, float score) {
		this.startnumber = startnumber;
		this.eventName = eventName;
		this.score = score;
		
	}
	public int getStartnumber(){
		return this.startnumber;
	}
	
	public String getEventName() {
		return this.eventName;
	}
	
	public float getScore() {
		return this.score;
	}
	
	@Override
	public int compareTo(Object o) {
		Result other = (Result) o;
		if (this.score > other.score) {
			return 1;
		} else if (this.score < other.score) {
			return -1;
		} else {
			return 0;
		}
	}
	
	   @Override
	    public String toString() {
	        return "Result{ " +
	                "startnumber=" + startnumber +
	                "eventName=" + eventName +
	                "score=" + score +
	                '}';
	    }
}
