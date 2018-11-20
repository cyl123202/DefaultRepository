public class User {
    String name;
    int age;
    String description;

    public User(String name, int age, String description) {
        this.name = name;
        this.age = age;
        this.description = description;
    }

    private User newInstance(String name, int age, String description) {
        return new User(name, age, description);
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public User setAge(int age) {
        this.age = age;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public User setDescription(String description) {
        this.description = description;
        return this;
    }
}
