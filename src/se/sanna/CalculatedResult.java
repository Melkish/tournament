package se.sanna;


public class CalculatedResult {

    private int calculatedPosition;
    private float score;
    private Participant participant;
    private Event event;

    public CalculatedResult (float score, int calculatedPosition, Participant participant, Event event) {
        this.calculatedPosition = calculatedPosition;
        this.score = score;
        this.event = event;
        this.participant = participant;
    }

    public int getCalculatedPosition() {
        return this.calculatedPosition;
    }

    public float getScore() {
        return this.score;
    }

    public Participant getParticipant() {
        return this.participant;
    }

    public Event getEvent() {
        return this.event;
    }
}
