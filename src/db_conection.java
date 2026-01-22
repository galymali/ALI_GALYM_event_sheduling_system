import java.sql.*;

public class db_conection {
    private static final String URL = "jdbc:postgresql://localhost:5432/event_sheduling_system";
    private static final String USER = "postgres";
    private static final String PASSWORD = "090608"; // Проверь пароль!

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void loadEventsFromDB() {
        String query = "SELECT * FROM events";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("--- Данные из БД ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        " | Name: " + rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }
    }

    public static void addEvent(String name, String date, String location) {
        String sql = "INSERT INTO events (name, date, location) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setString(2, date);
            pstmt.setString(3, location);
            pstmt.executeUpdate();
            System.out.println("✅ Запись добавлена!");
        } catch (SQLException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }
    }
    public static void deleteAllEvents() {
        String sql = "DELETE FROM events";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("🗑️ База данных очищена!");
        } catch (SQLException e) {
            System.out.println("Ошибка при удалении: " + e.getMessage());
        }
    }
}