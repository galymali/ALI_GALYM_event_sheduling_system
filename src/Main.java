// Удалили или закомментировали package main; если путь не совпадает
import controller.EventController;
import controller.ParticipantController;
import io.javalin.Javalin;
import repository.IEventRepository;
import repository.IParticipantRepository;
import repository.PostgreEventRepository;
import repository.PostgreParticipantRepository;

public class Main {
    public static void main(String[] args) {
        IEventRepository eventRepo = new PostgreEventRepository();
        IParticipantRepository partRepo = new PostgreParticipantRepository();

        EventController eventController = new EventController(eventRepo);
        ParticipantController partController = new ParticipantController(partRepo);

        Javalin app = Javalin.create(config -> {
            config.bundledPlugins.enableCors(cors -> {
                cors.addRule(it -> it.anyHost());
            });
        }).start(8080);

        // События
        app.get("/events", eventController::getAllEvents);
        app.post("/events", eventController::createEvent);

        // Участники - критически важно для кнопки!
        app.get("/participants", partController::getAllParticipants);
        app.post("/participants", partController::createParticipant);

        System.out.println("🚀 Сервер готов!");
    }
}