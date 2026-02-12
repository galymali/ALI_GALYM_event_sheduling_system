package model;

public class Organizer extends Person {
    private String phone;

    public Organizer(String name, String phone) {
        super(name);
        this.phone = phone;
    }

    @Override
    public void printInfo() {
        System.out.println("[model.Organizer] " + getName() + " | Phone: " + phone);
    }
}