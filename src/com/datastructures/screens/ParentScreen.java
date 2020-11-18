package com.datastructures.screens;

import com.datastructures.MainPortal;
import com.datastructures.interfaces.Screen;

public class ParentScreen extends MainPortal implements Screen {
    public void main() {
        String type = requestData("type");
    }
}
