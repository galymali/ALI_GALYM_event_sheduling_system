package main;

import io.javalin.Javalin;
import controller.EventController;
import controller.ParticipantController;
import repository.PostgreEventRepository;
import repository.PostgreParticipantRepository;

public class Main {
    public static void main(String[] args) {
        // 1. Инициализация репозиториев
        PostgreEventRepository eventRepo = new PostgreEventRepository();
        PostgreParticipantRepository partRepo = new PostgreParticipantRepository();

        // 2. Инициализация контроллеров
        EventController eventController = new EventController(eventRepo);
        ParticipantController partController = new ParticipantController(partRepo);

        // 3. Настройка Javalin (Исправленный CORS для версии 6.x)
        Javalin app = Javalin.create(config -> {
            config.bundledPlugins.enableCors(cors -> {
                cors.addRule(rule -> rule.anyHost()); // Исправленная строка
            });
        }).start(8080);

        // --- МАРШРУТЫ ДЛЯ СОБЫТИЙ (EVENTS) ---
        app.get("/events", ctx -> eventController.getAllEvents(ctx));
        app.post("/events", ctx -> eventController.createEvent(ctx));
        app.delete("/events/{id}", ctx -> eventController.deleteEvent(ctx)); // Удаление ивента

        // --- МАРШРУТЫ ДЛЯ УЧАСТНИКОВ (PARTICIPANTS) ---
        app.get("/participants", ctx -> partController.getAllParticipants(ctx));
        app.post("/participants", ctx -> partController.createParticipant(ctx));
        app.delete("/participants/{id}", ctx -> partController.deleteParticipant(ctx)); // Удаление участника

        System.out.println("Server started on http://localhost:8080");
    }
}