public class Event {
    private String name;
    private String date;
    private String location;

    public Event(String name, String date, String location ) {
        this.name = name;
        this.date = date;
        this.location = location;
    }
    public String getName() {
        return name;
    }
    public String getDate() {
        return date;
    }
    public String getLocation() {
        return location;
    }
    public void setName(String name) {
        this.name=name;
    }
    public void setDate(String date) {
        this.date=date;
    }
    public void setLocation(String Location) {
        this.location=location;
    }
    public void printInfo(){
        System.out.println(
                "Event: " + name + ", date: " + date + ", locatoin: " + location
        );
    }
}
