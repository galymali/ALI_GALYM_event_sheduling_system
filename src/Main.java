import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Data Pool
        List<Event> events = new ArrayList<>();
        events.add(new Event("Tech Conference", "2025-03-15", "Astana"));
        events.add(new Event("Art Exhibition", "2025-05-20", "Almaty"));
        events.add(new Event("Music Festival", "2025-03-15", "Astana"));
        events.add(new Event("AI Workshop", "2025-02-10", "Shymkent"));

        System.out.println("--- All Events ---");
        events.forEach(System.out::println);

        // 1. sorted by name
        System.out.println("\n--- Sorted by Name ---");
        events.sort(Comparator.comparing(Event::getName));
        events.forEach(System.out::println);

        // 2. filter - events in astana
        System.out.println("\n--- Events in Astana ---");
        for (Event e : events) {
            if (e.getLocation().equalsIgnoreCase("Astana")) {
                System.out.println(e);
            }
        }

        // 3. search by name
        String searchTarget = "AI Workshop";
        System.out.println("\n--- Searching for: " + searchTarget + " ---");
        for (Event e : events) {
            if (e.getName().equalsIgnoreCase(searchTarget)) {
                System.out.println("Found: " + e);
            }
        }

        // Demonstration of inheritance and polymorphism
        System.out.println("\n--- People Info ---");
        Person p1 = new Participant("Ali", "ali@mail.com");
        Person o1 = new Organizer("IT Group", "+7 777 777");

        p1.printInfo();
        o1.printInfo();
    }
}