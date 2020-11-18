package com.datastructures.screens;

import com.datastructures.Managers.GradesManager;
import com.datastructures.MainPortal;
import com.datastructures.Objects.Grade;
import com.datastructures.Objects.User;
import com.datastructures.interfaces.Screen;

import java.util.ArrayList;

public class ParentScreen extends MainPortal implements Screen {
    ArrayList<User> children = USER_MANAGER.getChildren(user.getUsername());
    GradesManager gradesManager;

    public void main() {
        print("   Welcome, _. | (_)  To begin, please select a child from the list below:   ", user.getUsername(), user.getType());
        print("1. View your children's grades  2. Log out");
        switch (requestData("choice", 3)) {
            case "1" -> {
                int number = 1;
                ArrayList<User> students = USER_MANAGER.getStudents();
                for (User student : students) {
                    print("_. _", number, student.getUsername());
                    number++;
                } //end for

                print("  Please select student by entering a number.");
                int choice = Integer.parseInt(requestData("choice", students.size()));
                students.get(choice - 1);

                User student = getStudent();
                gradesManager = new GradesManager(student.getUsername());
                for (Grade grade : gradesManager.getAllGrades()) {
                    print("_ - _ ", grade.getName(), grade.getGrade());
                } //end for
            } //end case 1

            case "2" -> {
                print("Logging out...");
                logOut();
            } //end case 2
        }
    }
}
