public class Attendee extends Person {
    private boolean paid;

    public Attendee(String name) {
        this(name, 0);
    }

    public Attendee(String name, int age) {
        this(name, age, false);
    }

    public Attendee(String name, int age, boolean paid) {
        this.setName(name);
        this.setAge(age);
        this.paid = paid;
    }

    public boolean hasPaid() {
        return paid;
    }

    @Override
    public String toString() {
        return "Attendee "+ getName()+(hasPaid() ? " has":" hasn't")+" paid its registration.";
    }
}
