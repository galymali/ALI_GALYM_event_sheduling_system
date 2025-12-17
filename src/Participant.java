public class Participant {
    private String name;
    private String email;

    public Participant(String name, String email) {
        this.name=name;
        this.email=email;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public void printInfo() {
        System.out.println("Participant: " + name + ", Email:" + email);
    }
    @Override
    public String toString() {
        return "Participant{name'"+ name + ", email'" + email + "'}";
    }
}
