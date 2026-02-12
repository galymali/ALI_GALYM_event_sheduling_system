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

    // Обработка GET запроса для списка участников
    public void getAllParticipants(Context ctx) {
        try {
            List<Participant> participants = repository.getAllParticipants();
            ctx.json(participants);
        } catch (Exception e) {
            ctx.status(500).result("Ошибка при получении участников: " + e.getMessage());
        }
    }

    // Обработка POST запроса с сайта (кнопка "Зарегистрировать")
    public void createParticipant(Context ctx) {
        try {
            Participant newParticipant = ctx.bodyAsClass(Participant.class);
            repository.addParticipant(newParticipant);
            ctx.status(201).json(newParticipant);
        } catch (Exception e) {
            ctx.status(400).result("Ошибка при создании участника: " + e.getMessage());
        }
    }
}