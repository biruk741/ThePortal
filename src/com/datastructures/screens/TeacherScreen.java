package com.datastructures.screens;

import com.datastructures.Managers.GradesManager;
import com.datastructures.MainPortal;
import com.datastructures.Objects.Grade;
import com.datastructures.Objects.User;
import com.datastructures.interfaces.Screen;

import java.util.ArrayList;

public class TeacherScreen extends MainPortal implements Screen {

    GradesManager gradesManager;


    public void main() {

        print("   Welcome, _. | (_)  To begin, please select a number.   ", user.getUsername(), user.getType());
        print("1. View student grades  2. Add grades  3. Change grades  4. Remove grades  5. Log out");

        switch (requestData("choice", 5)) {

            case "1" -> {
                User student = getStudent();
                gradesManager = new GradesManager(student.getUsername());
                for (Grade grade : gradesManager.getAllGrades()) {
                    print("_ - _ ", grade.getName(), grade.getGrade());
                } //end for
            } //end case

            case "2" -> {
                User student = getStudent();
                gradesManager = new GradesManager(student.getUsername());
                print("Please enter the name of the assignment you want to add:");
                String name = requestData("other");

                print("Please enter the grade for the assignment:");
                String grade = requestData("other");
                gradesManager.addGrade(new Grade(name, grade));

                print("The assignment _ with grade _ was added to student _.", name, grade, student.getUsername());
            } //end case 2

            case "3" -> {
                User student = getStudent();
                gradesManager = new GradesManager(student.getUsername());

                print("Please enter the name of the assignment you want to change grade:");
                String name = requestData("other");

                print("Please enter the grade for the assignment:");
                String grade = requestData("other");
                gradesManager.editGrade(name, new Grade(name, grade));

                print("The assignment _ of the student _ grade has been changed to _.", name, student.getUsername(), grade);
            } //end case

            case "4" -> {

            } //end case

            case "5" -> {
                print("Logging out...");
                logOut();
            } //end case
        }
        main();
    }

    private static User getStudent() {
        int number = 1;
        ArrayList<User> students = USER_MANAGER.getStudents();
        for (User student : students) {
            print("_. _", number, student.getUsername());
            number++;
        } //end for

        print("  Please select student by entering a number.");
        int choice = Integer.parseInt(requestData("choice", students.size()));
        return students.get(choice - 1);
    }
}
