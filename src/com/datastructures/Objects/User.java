package com.datastructures.Objects;

public class User {

    /**
     * An enum that encompasses all the different types of users.
     */
    public enum Type {
        STUDENT("Student"), TEACHER("Teacher"), PARENT("Parent");

        private final String value;

        Type(String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }
    }

    String username;
    String password;
    Type type;

    // Constructors
    public User(String username, String password, Type type) {
        this.username = username;
        this.password = password;
        this.type = type;
    }

    public User(String username, String password, String type) {
        this( username, password, switch (type.toLowerCase()) {
            case "teacher" -> Type.TEACHER;
            case "parent" -> Type.PARENT;
            default -> Type.STUDENT;
        });
    }

    // Getter methods.
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Type getType() {
        return type;
    }
}
