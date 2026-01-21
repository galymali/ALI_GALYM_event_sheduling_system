import java.util.Objects;

public class Event {
    private String name;
    private String date;
    private String location;

    public Event(String name, String date, String location) {
        this.name = name;
        this.date = date;
        this.location = location;
    }

    // getter and setter
    public String getName() { return name; }
    public String getDate() { return date; }
    public String getLocation() { return location; }

    @Override
    public String toString() {
        return String.format("Event: %-20s | Date: %-12s | Location: %s", name, date, location);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(name, event.name) &&
                Objects.equals(date, event.date) &&
                Objects.equals(location, event.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, date, location);
    }
}