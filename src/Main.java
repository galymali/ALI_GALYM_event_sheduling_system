//my subject area is #15 event scheduling system
public class Main {
    public static void main(String[]args) {
    Event event1 = new Event("tech conference", "15.03.2025", "Astana");
    event1.printInfo();

    Event event2 = new Event("tech meetup", "20.042025", "Astana");
    event2.printInfo();

    Participant participant1 = new Participant("Ali", "Galymali08@mail.com");
    participant1.printInfo();

    Participant participant2 = new Participant("sabr", "KanatovSabr@mail.com");
    participant2.printInfo();

    Organizer Organizer1 = new Organizer("IT Group", "+7 777 777 7777");
    Organizer1.PrintInfo();

    System.out.println("are event in same city? " +
            event1.getLocation().equals(event2.getLocation()));

    System.out.println("is it on same date? " +
            event1.getDate().equals(event2.getDate()));
    }
}