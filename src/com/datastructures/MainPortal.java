package com.datastructures;

import com.datastructures.Objects.User;

import java.util.Scanner;

public class MainPortal {
    static User user;
    private static final Login login = new Login();
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        user = getUser();
        if(user == null) return;

        print("Currently logged in as " + user.getUsername() + " (" + user.getType().toString() + ")");
    }

    private static User getUser() {
        print("1. Login\n2. Signup\n3. Exit");
        return switch (scanner.next().toLowerCase()) {
            case "1" -> signIn();
            case "2" -> signUp();
            case "3" -> null;
            default -> {
                print("Please enter an option from the choices below");
                yield getUser();
            }
        };
    }

    private static User signUp() {
        String type = requestData("type");
        String username = requestData("username");
        if (login.userExists(username)) {
            print("This username has already been taken. Please try another one.");
            return signUp();
        }
        String password = requestData("password");
        User user = new User(username,password,type);
        login.signUp(user);
        return login.getUser(username);
    }

    //
    private static String requestData(String type){
        return switch (type.toLowerCase()){
            case "password","username" -> {
                print("Please enter your " + type + ":");
                String input = scanner.next();
                if(input.length() < 5){
                    print("The" + type + " you entered is too short.");
                    yield requestData(type);
                }
                yield input;
            }
            case "type"->{
                print("Are you a student, teacher, or parent? (Please enter one of these choices.)");
                String input = scanner.next().toLowerCase();
                yield switch (input){
                    case "student","teacher","parent" -> input;
                    default -> {
                        print("You have to choose from the listed options.");
                        yield requestData(type);
                    }
                };
            }
            default -> "";
        };
    }

    // elena

    private static User signIn() {
        String username = requestData("username");
        if (!login.userExists(username)) {
            print("User does not exist.");
            return signIn();
        }
        String password = requestData("password");
        if(!login.isValid(username,password)){
            print("Incorrect password. Please try again.");
            return signIn();
        }
        return login.getUser(username);
    }

    public static void print(String s) {
        System.out.println(s);
    }
}
