package repository;

import model.Participant;
import java.util.List;

public interface IParticipantRepository {
    // Сохранить нового участника
    void addParticipant(Participant p);

    // Получить вообще всех участников (для новой таблицы на сайте)
    List<Participant> getAllParticipants();

    // Получить участников только одного события
    List<Participant> getParticipantsByEventId(int eventId);
}