package repository;

import model.Event;

import java.util.List;

public interface IEventRepository {
    List<Event> getAllEvents();

    void addEvent(Event event);

    void deleteAllEvents();

    void updateEvent(int id, String newName, String newDate);
}