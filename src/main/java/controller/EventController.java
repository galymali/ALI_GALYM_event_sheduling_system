package controller;

import io.javalin.http.Context;
import model.Event;
import repository.IEventRepository;
import java.util.List;

public class EventController {
    private final IEventRepository repository;

    public EventController(IEventRepository repository) {
        this.repository = repository;
    }

    public void getAllEvents(Context ctx) {
        List<Event> events = repository.getAll();
        ctx.json(events);
    }

    public void createEvent(Context ctx) {
        Event event = ctx.bodyAsClass(Event.class);
        repository.add(event);
        ctx.status(201);
    }

    public void deleteEvent(Context ctx) {
        try {
            int id = Integer.parseInt(ctx.pathParam("id"));
            repository.delete(id);
            ctx.status(204);
        } catch (NumberFormatException e) {
            ctx.status(400).result("Invalid ID format");
        }
    }
}