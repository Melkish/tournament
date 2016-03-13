package se.sanna;

//Sanna Melke (same3047) och Sophie Lindberg (soli5539)

public class Participant {
	private String firstname;
	private String lastname;
	private int startnumber; 
	
	public Participant(String firstname, String lastname, int startnumber){
		this.firstname = firstname;
		this.lastname = lastname;
		this.startnumber = startnumber;
	}
	
	public String getFullName(){
		return this.firstname+" "+this.lastname;
	}
	
	public int getStartnumber(){
		return this.startnumber;
	}

	
    @Override
    public String toString() {
        return "Participant{" +
                "name=" + getFullName() +
                "startnumber=" + startnumber +
                '}';
    }
}
