package com.datastructures.screens;

import com.datastructures.MainPortal;
import com.datastructures.Managers.GradesManager;
import com.datastructures.Objects.Grade;
import com.datastructures.Objects.User;
import com.datastructures.interfaces.Screen;

import java.util.ArrayList;

public class StudentScreen extends MainPortal implements Screen {

    // Todo: Make sure to add comment feature.
    // Todo: add age maybe

    GradesManager gradesManager = new GradesManager(user.getUsername());

    public void main() {
        print("   Welcome, _. | (_)  Parent:_  To begin, enter a number.   ",user.getUsername(),user.getType(),gradesManager.getParentUsername());
        print("1. View your grades  2. Allow a parent to view your grades  3. Log out");
        switch (requestData("choice",3)){
            case "1" ->{
                int number = 1;
                print("   Name | Grade   ");
                for(Grade grade : gradesManager.getAllGrades()){
                    print("_. _ _",number,grade.getName(),grade.getGrade());
                    number++;
                }
            }
            case "2" ->{
                ArrayList<User> parents = USER_MANAGER.getParents();
                print("Enter the number beside the parent you would like to select.");
                for(int index = 0;index<parents.size();index++){
                    print("_. _",index + 1,parents.get(index).getUsername());
                }
                String choice = requestData("choice",parents.size());
                User parent = parents.get(Integer.parseInt(choice) - 1);
                gradesManager.setParent(parent.getUsername());
                print("_ now has access to your grades.",parent.getUsername());

            }case "3" ->{
                print("Logging out...");
                logOut();
            }
        }// add
        main();
    }//lll
}// add
