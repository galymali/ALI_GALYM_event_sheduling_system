package repository;

import db.DatabaseManager;
import model.Participant;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostgreParticipantRepository implements IParticipantRepository {

    @Override
    public List<Participant> getAll() {
        List<Participant> participants = new ArrayList<>();
        String sql = "SELECT * FROM participants";
        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                participants.add(new Participant(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getInt("event_id")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return participants;
    }

    @Override
    public void add(Participant p) {
        String sql = "INSERT INTO participants (name, email, event_id) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, p.getName());
            pstmt.setString(2, p.getEmail());
            pstmt.setInt(3, p.getEventId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM participants WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}