package controller;

import io.javalin.http.Context;
import model.Participant;
import repository.IParticipantRepository;
import java.util.List;

public class ParticipantController {
    private final IParticipantRepository repository;

    public ParticipantController(IParticipantRepository repository) {
        this.repository = repository;
    }

    public void getAllParticipants(Context ctx) {
        // Теперь метод getAll() точно существует в интерфейсе
        List<Participant> participants = repository.getAll();
        ctx.json(participants);
    }

    public void createParticipant(Context ctx) {
        Participant participant = ctx.bodyAsClass(Participant.class);
        repository.add(participant);
        ctx.status(201);
    }

    public void deleteParticipant(Context ctx) {
        try {
            int id = Integer.parseInt(ctx.pathParam("id"));
            repository.delete(id);
            ctx.status(204);
        } catch (NumberFormatException e) {
            ctx.status(400).result("Invalid ID format");
        }
    }
}