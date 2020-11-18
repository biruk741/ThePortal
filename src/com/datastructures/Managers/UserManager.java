package com.datastructures.Managers;

import com.datastructures.Dictionaries.SortedArrayDictionary;
import com.datastructures.Objects.User;
import com.datastructures.interfaces.DictionaryInterface;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class UserManager {
    private final DictionaryInterface<String, User> userRecords;
    private static final String fileName = "user_records.txt";
    private static Scanner data;
    private static final String n = "\n";


    @SuppressWarnings("ResultOfMethodCallIgnored")
    public UserManager() {
        userRecords = new SortedArrayDictionary<>();
        File file = new File(fileName);
        try {
            file.createNewFile();
            data = new Scanner(file);
        } catch (Exception ignored) {
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
            userRecords.add(username, new User(username, password, type));
        }
        data.close();
    }

    /**
     * This method saves the contents of the user record to the record file
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

    public boolean signUp(User user) {
        if (userExists(user.getUsername())) {        // looks to see if the user name already exsits
            return false;
        } else userRecords.add(user.getUsername(), user);
        saveFile();
        return true;
    }

    public boolean userExists(String username) {
        return userRecords.contains(username);
    }

    /**
     * This method converts the dictionary object to a string that can be saved to the file.
     *
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

    public boolean isValid(String username, String password) {
        User user = userRecords.getValue(username);
        return password.equals(user.getPassword());
    }

    public User getUser(String username) {
        return userRecords.getValue(username);
    }

    public ArrayList<User> getChildren(String parentUsername){
        ArrayList<User> children = new ArrayList<>();
        Iterator<User> childrenIterator = userRecords.getValueIterator();
        while (childrenIterator.hasNext()){
            User currentChild = childrenIterator.next();
            if(currentChild.getType() == User.Type.STUDENT) {
                GradesManager manager = new GradesManager(currentChild.getUsername());
                if (manager.getParentUsername().equals(parentUsername))
                    children.add(currentChild);
            }
        }
        return children;
    }
    public ArrayList<User> getParents(){
        ArrayList<User> parents = new ArrayList<>();
        Iterator<User> parentsIterator = userRecords.getValueIterator();
        while (parentsIterator.hasNext()){
            User currentChild = parentsIterator.next();
            if(currentChild.getType().equals(User.Type.PARENT))
                parents.add(currentChild);
            //
        }
        return parents;
    }
    public ArrayList<User> getStudents(){
        ArrayList<User> students = new ArrayList<>();
        Iterator<User> studentsIterator = userRecords.getValueIterator();
        while (studentsIterator.hasNext()){
            User currentStudent = studentsIterator.next();
            if(currentStudent.getType().equals(User.Type.STUDENT))
                students.add(currentStudent);
        }
        return students;
    }
    /**
     * Gets the user records in the form of a string
     *
     * @return the string
     */
    @Override
    public String toString() {
        return userRecords.toString();
    }
}