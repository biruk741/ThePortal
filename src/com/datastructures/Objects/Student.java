package com.datastructures.Objects;

import java.util.Random;

public class Student {
    int id;
    String name;
    int age;
    Grade[] grades;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Student(String name, int age) {
        this.id = (int) (Math.random() * 10000 + 1000);
        this.name = name;
        this.age = age;
    }

    public Student(int id, String name, int age, Grade[] grades) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grades = grades;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Grade[] getGrades() {
        return grades;
    }

    public void setGrades(Grade[] grades) {
        this.grades = grades;
    }
}
