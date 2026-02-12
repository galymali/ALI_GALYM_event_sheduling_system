package model;

public class Participant {
    private int id;
    private String name;
    private String email;
    private int eventId;

    public Participant() {}

    public Participant(int id, String name, String email, int eventId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.eventId = eventId;
    }

    public Participant(String name, String email, int eventId) {
        this.name = name;
        this.email = email;
        this.eventId = eventId;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public int getEventId() { return eventId; }
    public void setEventId(int eventId) { this.eventId = eventId; }
}