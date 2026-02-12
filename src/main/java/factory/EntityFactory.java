package factory;

import model.Event;
import model.Participant;

public class EntityFactory {

    public enum EntityType {
        EVENT, PARTICIPANT
    }

    public static Object createEntity(EntityType type, String name, String detail, int extraId) {
        switch (type) {
            case EVENT:
                return new Event(name, detail, "Astana");
            case PARTICIPANT:
                return new Participant(name, detail, extraId);
            default:
                throw new IllegalArgumentException("Unknown entity type");
        }
    }
}