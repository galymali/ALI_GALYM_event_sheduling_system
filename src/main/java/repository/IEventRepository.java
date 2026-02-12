package repository;

import model.Event;
import java.util.List;

public interface IEventRepository {
    List<Event> getAll();
    void add(Event event);
    void delete(int id);
}