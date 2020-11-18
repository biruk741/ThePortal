package com.datastructures.screens;

import com.datastructures.GradesManager;
import com.datastructures.MainPortal;
import com.datastructures.Objects.User;
import com.datastructures.interfaces.Screen;

import java.util.ArrayList;

public class ParentScreen extends MainPortal implements Screen {
    ArrayList<User> children = LOGIN_MANAGER.getChildren(user.getUsername());
    GradesManager gradesManager;
    public void main() {
        print("   Welcome, _. | (_)  To begin, enter a number.   ",user.getUsername(),user.getType());
        print("1. View your children  2. Allow a parent to view your grades  3. Log out");
    }
}
