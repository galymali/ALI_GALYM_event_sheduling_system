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

    // GET: Получить все события
    public void getAllEvents(Context ctx) {
        List<Event> events = repository.getAllEvents();
        ctx.json(events);
    }

    // POST: Создать новое событие
    // В EventController.java замени старый метод createEvent на этот:
    public void createEvent(Context ctx) {
        try {
            Event newEvent = ctx.bodyAsClass(Event.class);

            // Просто вызываем метод без проверки boolean
            repository.addEvent(newEvent);

            ctx.status(201).json(newEvent);
        } catch (Exception e) {
            ctx.status(400).result("Ошибка данных: " + e.getMessage());
        }
    }
}