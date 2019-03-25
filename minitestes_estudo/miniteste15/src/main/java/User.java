public class User {
    private String name;

    public User(String name) throws Exception {
        if (name.isEmpty()) {
            throw new Exception();
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean equals(User user) {
        return (this.getName().equals(user.getName()));
    }

}
