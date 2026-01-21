public class Participant extends Person {
    private String email;

    public Participant(String name, String email) {
        super(name);
        this.email = email;
    }

    @Override
    public void printInfo() {
        System.out.println("[Participant] " + getName() + " | Email: " + email);
    }
}