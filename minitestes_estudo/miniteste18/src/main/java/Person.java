public abstract class Person implements Comparable, User {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (obj.getClass() != Speaker.class && obj.getClass() != Attendee.class)
            return false;

        Person p = (Person) obj;
        return p.getName().equals(this.getName());
    }

    @Override
    public int compareTo(Object o) {
        return this.getName().compareTo(((Person) o). getName());
    }

    public String getUsername() {
        return getName() + getAge();
    }
}
