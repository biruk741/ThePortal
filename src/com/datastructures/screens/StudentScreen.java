package com.datastructures.screens;

import com.datastructures.GradesManager;
import com.datastructures.LoginManager;
import com.datastructures.MainPortal;
import com.datastructures.interfaces.Screen;

public class StudentScreen extends MainPortal implements Screen {

    // Todo: Make sure to add comment feature.

    GradesManager gradesManager = new GradesManager(user.getUsername());

    public void main() {
        print("   Welcome, _. | (_)  To begin, enter a number.   ",user.getUsername(),user.getType());
        print("1. View your grades  2. Allow a parent to view your grades  3. Log out");
        switch (requestData("choice",3)){
            case "1" ->{
                gradesManager.getGrade()

            }
            case "2" ->{

            }case "3" ->{

            }
        }//add
    }////add
}
