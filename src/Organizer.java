public class Organizer {

    private String name;
    private String phone;

    public Organizer( String name , String phone) {
        this.name = name;
        this.phone = phone;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    void getOrganizer() {
        System.out.println("Organizer: " + name + ", phone: " + phone);
    }

    public void PrintInfo() {
        System.out.println("name: " + name + ", phone: " + phone);
    }
}
