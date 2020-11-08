package com.datastructures;

import com.datastructures.Objects.User;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class Login {
    public final DictionaryInterface<String, User> userRecords;
    public static final String fileName = "user_records.txt";
    private static Scanner data;
    public static final String n = "\n";


    public Login() {
        userRecords = new SortedArrayDictionary<>();
        File file = new File(fileName);
        try {
            file.createNewFile();
            data = new Scanner(file);
        } catch (Exception e) {
            System.out.println("File could not be created.");
        }
        readFile();
    }

    /**
     * This method reads the file and updates the phonebook
     */
    public void readFile() {
        while (data.hasNext()) {
            String username = data.next();
            String password = data.next();
            String type = data.next();
            userRecords.add(username,new User(username,password,type));
        }
        data.close();
    }

    /**
     * This method saves the contents of the phonebook to the file
     * @param dictionary: the phonebook that we are saving.
     */
    private void saveFile() {
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(dictionaryToString(userRecords));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    This method adds a given phone number to a given contact, then saves it.
     */
    public boolean signUp(User user) {
        if (userRecords.contains(user.getUsername())) {
            return false;
        } else userRecords.add(user.getUsername(),user);
        saveFile();
        return true;
    }

    public boolean userExists(String username){
        return userRecords.contains(username);
    }

    /**
     * This method converts the dictionary object to a string that can be saved to the file.
     * @param dictionaryInterface: the dictionary object
     * @return the converted string.
     */
    private String dictionaryToString(DictionaryInterface<String, User> dictionaryInterface) {
        Iterator<String> usernameIterator = dictionaryInterface.getKeyIterator();
        Iterator<User> userIterator = dictionaryInterface.getValueIterator();
        String s = "";
        while (usernameIterator.hasNext()) {
            String currentUsername = usernameIterator.next();
            User currentUser = userIterator.next();
            s += currentUsername + " " + currentUser.getPassword() + " " + currentUser.getType().toString() + n;
        }
        return s;
    }

    public boolean login(String username, String password) {
        User user = userRecords.getValue(username);
        return password.equals(user.getPassword());
    }

    /**
     * Gets the given phonebook in the form of a string that we can then print out.
     * @return the string
     */
    @Override
    public String toString() {
        return userRecords.toString();
    }
}
