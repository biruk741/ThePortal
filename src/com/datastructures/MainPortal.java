package com.datastructures;

import com.datastructures.Objects.User;
import com.datastructures.screens.ParentScreen;
import com.datastructures.interfaces.Screen;
import com.datastructures.screens.StudentScreen;
import com.datastructures.screens.TeacherScreen;

import java.util.Arrays;
import java.util.Scanner;

public class MainPortal {
    public static User user;
    private static final LoginManager LOGIN_MANAGER = new LoginManager();
    public static final Scanner scanner = new Scanner(System.in);



    public static void main(String[] args) {
        print("   Welcome to the student portal.   ");
        user = getUser();
        if (user == null) return;

        print("Currently logged in as _ (_)", user.getUsername(), user.getType());

        Screen currentScreen = switch (user.getType()) {
            case TEACHER -> new TeacherScreen();
            case STUDENT -> new StudentScreen();
            case PARENT -> new ParentScreen();
        };

        currentScreen.main();
    }

    private static User getUser() {
        print("1. Login  2. Signup  3. Exit");
        return switch (scanner.next().toLowerCase()) {
            case "1" -> signIn();
            case "2" -> signUp();
            case "3" -> {
                System.exit(0);
                yield null;
            }
            default -> {
                print("Please enter an option from the choices below");
                yield getUser();
            }
        };
    }

    private static User signUp() {
        String type = requestData("type");
        String username = requestData("username");
        if (LOGIN_MANAGER.userExists(username)) {
            print("This username has already been taken. Please try another one.");
            return signUp();
        }
        String password = requestData("password");
        User user = new User(username, password, type);
        LOGIN_MANAGER.signUp(user);
        return LOGIN_MANAGER.getUser(username);
    }

    public static String requestData(String type, int... numOfChoices) {
        return switch (type.toLowerCase()) {
            case "password", "username" -> {
                print("Please enter your _:", type);
                String input = scanner.next();
                if (input.length() < 5) {
                    print("The _ you entered is too short.", type);
                    yield requestData(type);
                }
                yield input;
            }
            case "type" -> {
                print("Are you a student, teacher, or parent? (Please enter one of these choices.)");
                String input = scanner.next().toLowerCase();
                yield switch (input) {
                    case "student", "teacher", "parent" -> input;
                    default -> {
                        print("You have to choose from the listed options.");
                        yield requestData(type);
                    }
                };
            }
            case "choice"->{
                int input = Integer.parseInt(scanner.next());
                if(input <= numOfChoices[0] && input > 0) yield input + "";
                else{
                    print("Please enter a number between 1 and _",numOfChoices[0]);
                    yield requestData(type,numOfChoices);}
            }
            default -> "";
        };
    }

    // elena

    private static User signIn() {
        String username = requestData("username");
        if (!LOGIN_MANAGER.userExists(username)) {
            print("User does not exist.");
            return signIn();
        }
        String password = requestData("password");
        if (!LOGIN_MANAGER.isValid(username, password)) {
            print("Username and password do not match.");
            return signIn();
        }
        return LOGIN_MANAGER.getUser(username);
    }

    public static void print(Object... s) {
        System.out.printf(((String) s[0])
                        .replaceAll("   ", "\n------------------------------------\n")
                        .replaceAll("  ", "\n")
                        .replaceAll("_", "%s") + "\n",
                Arrays.copyOfRange(s, 1, s.length)
        );
    }
}
