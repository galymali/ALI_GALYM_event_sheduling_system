import java.util.Objects;

public abstract class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    // abstract method (polymorphism)
    public abstract void printInfo();

    @Override
    public String toString() {
        return "Name: " + name;
    }
}