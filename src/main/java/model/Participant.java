package model;

public class Participant {
    private int id;
    private String name;
    private String email;
    private int eventId;

    // 1. Пустой конструктор (для Jackson/Сайта)
    public Participant() {}

    // 2. Полный конструктор (для загрузки из БД с ID)
    public Participant(int id, String name, String email, int eventId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.eventId = eventId;
    }

    // 3. НОВЫЙ КОНСТРУКТОР (для EntityFactory - без ID)
    // Именно его ищет ошибка "no suitable constructor found"
    public Participant(String name, String email, int eventId) {
        this.name = name;
        this.email = email;
        this.eventId = eventId;
    }

    // Геттеры и сеттеры должны остаться ниже...
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public int getEventId() { return eventId; }
    public void setEventId(int eventId) { this.eventId = eventId; }
}