public class Speaker extends Person {
    private int fee;

    public Speaker(String name) {
        this(name, 0);
    }

    public Speaker(String name, int age) {
        this(name, age, 0);
    }

    public Speaker(String name, int age, int fee) {
        this.setName(name);
        this.setAge(age);
        this.fee = fee;
    }

    public int getFee() {
        return fee;
    }

    @Override
    public String toString() {
        return "Speaker " + getName() + " as a fee value of " + fee + ".";
    }
}
