package main;

import io.javalin.Javalin;
import controller.EventController;
import controller.ParticipantController;
import repository.PostgreEventRepository;
import repository.PostgreParticipantRepository;

public class Main {
    public static void main(String[] args) {
        PostgreEventRepository eventRepo = new PostgreEventRepository();
        PostgreParticipantRepository partRepo = new PostgreParticipantRepository();

        EventController eventController = new EventController(eventRepo);
        ParticipantController partController = new ParticipantController(partRepo);

        Javalin app = Javalin.create(config -> {
            config.bundledPlugins.enableCors(cors -> {
                cors.addRule(rule -> rule.anyHost());
            });
        }).start(8080);

        app.get("/events", ctx -> eventController.getAllEvents(ctx));
        app.post("/events", ctx -> eventController.createEvent(ctx));
        app.delete("/events/{id}", ctx -> eventController.deleteEvent(ctx)); // Удаление ивента

        app.get("/participants", ctx -> partController.getAllParticipants(ctx));
        app.post("/participants", ctx -> partController.createParticipant(ctx));
        app.delete("/participants/{id}", ctx -> partController.deleteParticipant(ctx)); // Удаление участника

        System.out.println("Server started on http://localhost:8080");
    }
}