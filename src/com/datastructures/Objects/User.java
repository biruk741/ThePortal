package com.datastructures.Objects;

public class User {

    public enum Type{
        STUDENT("Student"),TEACHER("Teacher"),PARENT("Parent");

        private final String value;

        private Type(String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }
    }
    String username;
    String password;
    Type type;

    public User(String username, String password, Type type) {
        this.username = username;
        this.password = password;
        this.type = type;
    }
    public User(String username, String password, String type) {
        this.username = username;
        this.password = password;
        this.type = switch (type.toLowerCase()){
            case "teacher" -> Type.TEACHER;
            case "parent" -> Type.PARENT;
            default -> Type.STUDENT;
        };
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
