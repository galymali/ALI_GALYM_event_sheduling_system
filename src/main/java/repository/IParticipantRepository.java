package repository;

import model.Participant;
import java.util.List;

public interface IParticipantRepository {
    List<Participant> getAll();
    void add(Participant participant);
    void delete(int id);
}