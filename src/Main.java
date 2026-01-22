import java.util.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        // 1. Создаем список объектов вручную (Data Pool)
        List<Event> events = new ArrayList<>();
        events.add(new Event("Tech Conference", "2025-03-15", "Astana"));
        events.add(new Event("Art Exhibition", "2025-05-20", "Almaty"));
        events.add(new Event("Music Festival", "2025-03-15", "Astana"));
        events.add(new Event("AI Workshop", "2025-02-10", "Shymkent"));

        System.out.println("--- All Local Events ---");
        events.forEach(System.out::println);

        // 2. Пример фильтрации (поиск в Астане)
        System.out.println("\n--- Events in Astana ---");
        for (Event e : events) {
            if (e.getLocation().equalsIgnoreCase("Astana")) {
                System.out.println(e);
            }
        }

        // 3. Демонстрация наследования (Person, Participant, Organizer)
        System.out.println("\n--- People Info ---");
        Person p1 = new Participant("Ali", "ali@mail.com");
        Person o1 = new Organizer("IT Group", "+7 777 777 7777");
        p1.printInfo();
        o1.printInfo();

        // db operations
        System.out.println("\n--- Database Operations ---");

        db_conection.deleteAllEvents();
        db_conection.addEvent("AITU Hackathon", "2025-04-12", "Astana");
        db_conection.loadEventsFromDB();
    }
}