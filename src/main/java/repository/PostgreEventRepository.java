package repository;

import db.DatabaseManager;
import model.Event;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostgreEventRepository implements IEventRepository {

    @Override
    public List<Event> getAll() {
        List<Event> events = new ArrayList<>();
        String sql = "SELECT * FROM events";
        // Используем статический вызов без getInstance()
        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                events.add(new Event(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("date"),
                        rs.getString("location")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return events;
    }

    @Override
    public void add(Event e) {
        String sql = "INSERT INTO events (name, date, location) VALUES (?, CAST(? AS DATE), ?)";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, e.getName());
            pstmt.setString(2, e.getDate());
            pstmt.setString(3, e.getLocation());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM events WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}