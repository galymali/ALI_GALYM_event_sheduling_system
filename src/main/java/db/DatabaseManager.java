package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    // Статическая переменная для хранения единственного экземпляра класса
    private static DatabaseManager instance;
    private Connection connection;

    private final String url = "jdbc:postgresql://localhost:5432/event_sheduling_system";
    private final String user = "postgres";
    private final String password = "090608"; // Твой пароль

    // Приватный конструктор (никто не может создать объект через new db.DatabaseManager)
    private DatabaseManager() throws SQLException {
        try {
            // Подгружаем драйвер (хорошая практика)
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            throw new SQLException("PostgreSQL Driver not found", e);
        }
    }

    // Метод для получения единственного экземпляра (Singleton)
    public static DatabaseManager getInstance() throws SQLException {
        if (instance == null || instance.getConnection().isClosed()) {
            instance = new DatabaseManager();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}