package com.datastructures;

import com.datastructures.Objects.User;

import java.util.Scanner;

public class MainPortal {
    static User user;
    private static final Login login = new Login();
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        user = signIn();

    }


    private static User getUser(){
        print("1. Login\n2. Signup\n3Exit");
        return switch (scanner.next()){
            case "1" -> "Mya hartman was here,"
            case "2" -> {}
            default -> null;
        };
    }

    private static User signIn() {
        print("Please enter your username: ");
        String entered = scanner.next();
        if(login.userExists(entered))
    }

    public static void print(String s){
        System.out.println(s);
    }
}
