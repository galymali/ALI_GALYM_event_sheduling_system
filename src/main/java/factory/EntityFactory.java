package factory;

import model.Event;
import model.Participant;

public class EntityFactory {

    // Перечисление типов сущностей
    public enum EntityType {
        EVENT, PARTICIPANT
    }

    // Статический метод фабрики
    public static Object createEntity(EntityType type, String name, String detail, int extraId) {
        switch (type) {
            case EVENT:
                // Здесь detail — это дата, extraId не нужен (0)
                return new Event(name, detail, "Astana");
            case PARTICIPANT:
                // Здесь detail — это email, extraId — это eventId
                return new Participant(name, detail, extraId);
            default:
                throw new IllegalArgumentException("Unknown entity type");
        }
    }
}