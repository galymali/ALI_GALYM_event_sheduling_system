package repository;

import db.DatabaseManager;
import model.Event;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostgreEventRepository implements IEventRepository {

    @Override
    public List<Event> getAllEvents() {
        List<Event> events = new ArrayList<>();
        String sql = "SELECT * FROM events";

        // Используем db.DatabaseManager.getInstance().getConnection()
        try (Connection conn = DatabaseManager.getInstance().getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                // Теперь мы передаем и ID в конструктор model.Event
                Event event = new Event(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("date"),
                        rs.getString("location")
                );
                events.add(event);
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при получении списка: " + e.getMessage());
        }
        return events;
    }

    @Override
    public void addEvent(Event event) {
        // ВАЖНО: колонки должны называться как в твоей БД (name, date, location)
        String sql = "INSERT INTO events (name, date, location) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseManager.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, event.getName());
            pstmt.setString(2, event.getDate());
            pstmt.setString(3, event.getLocation());

            pstmt.executeUpdate();
            System.out.println("Событие успешно добавлено в базу!");
        } catch (SQLException e) {
            System.err.println("Ошибка SQL: " + e.getMessage());
        }
    }

    @Override
    public void deleteAllEvents() {
        String sql = "DELETE FROM events";
        try (Connection conn = DatabaseManager.getInstance().getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("База данных очищена");
        } catch (SQLException e) {
            System.out.println("Ошибка удаления: " + e.getMessage());
        }
    }

    @Override
    public void updateEvent(int id, String newName, String newDate) {
        String sql = "UPDATE events SET name = ?, date = ? WHERE id = ?";
        try (Connection conn = DatabaseManager.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, newName);
            pstmt.setString(2, newDate);
            pstmt.setInt(3, id);

            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Событие с ID " + id + " обновлено");
            } else {
                System.out.println("Событие с ID " + id + " не найдено");
            }
        } catch (SQLException e) {
            System.out.println("Ошибка обновления: " + e.getMessage());
        }
    }
}