public class Artist extends Person {
    public Artist(String name) {
        this(name, 0);
    }

    public Artist(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

}
