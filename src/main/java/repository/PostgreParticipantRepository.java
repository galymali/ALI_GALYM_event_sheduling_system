package repository;

import db.DatabaseManager;
import model.Participant;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostgreParticipantRepository implements IParticipantRepository {

    @Override
    public void addParticipant(Participant p) {
        String sql = "INSERT INTO participants (name, email, event_id) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseManager.getInstance().getConnection();
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
    public List<Participant> getAllParticipants() {
        List<Participant> participants = new ArrayList<>();
        String sql = "SELECT * FROM participants";
        try (Connection conn = DatabaseManager.getInstance().getConnection();
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
    public List<Participant> getParticipantsByEventId(int eventId) {
        List<Participant> participants = new ArrayList<>();
        String sql = "SELECT * FROM participants WHERE event_id = ?";
        try (Connection conn = DatabaseManager.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, eventId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    participants.add(new Participant(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getInt("event_id")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return participants;
    }
}