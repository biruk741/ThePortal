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
    String year;

    // Constructors
    public User(String username, String password, Type type, String year) {
        this.username = username;
        this.password = password;
        this.type = type;
        this.year = year;
    }

    public User(String username, String password, Type type) {
        this(username,password,type,"N/A");
    }

    public User(String username, String password, String type,String year) {
        this( username, password, switch (type.toLowerCase()) {
            case "teacher" -> Type.TEACHER;
            case "parent" -> Type.PARENT;
            default -> Type.STUDENT;
        },year);
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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
