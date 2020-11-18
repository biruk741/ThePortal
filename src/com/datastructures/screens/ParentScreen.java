package com.datastructures.screens;

import com.datastructures.Managers.GradesManager;
import com.datastructures.MainPortal;
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
//
            }
        }
    }
}
