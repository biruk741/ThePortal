package com.datastructures;

import com.datastructures.Objects.Student;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class StudentRecords {
//    public final DictionaryInterface<String, Student> phoneBook;
//    public static final String fileName = "student_records.txt";
//    private static Scanner data;
//    public static final String n = "\n";
//
//
//    public StudentRecords() {
//        phoneBook = new SortedArrayDictionary<>();
//        File file = new File(fileName);
//        try {
//            if (file.createNewFile()) System.out.println("Created a new file for the student directory.");
//            data = new Scanner(file);
//        } catch (Exception e) {
//            System.out.println("File could not be created.");
//        }
//        readFile();
//    }
//
//    /**
//     * This method reads the file and updates the phonebook
//     */
//    public void readFile() {
//        while (data.hasNext()) {
//            String firstName = data.next();
//            String lastName = data.next();
//            String phoneNumber = data.next();
//            Name fullName = new Name(firstName, lastName);
//            phoneBook.add(fullName, phoneNumber);
//        }
//        data.close();
//    }
//
//    /**
//     * This method saves the contents of the phonebook to the file
//     * @param dictionary: the phonebook that we are saving.
//     */
//    private void saveFile(DictionaryInterface<Name, String> dictionary) {
//        try {
//            FileWriter writer = new FileWriter(fileName);
//            writer.write(dictionaryToString(dictionary));
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /*
//    This method adds a given phone number to a given contact, then saves it.
//     */
//    public boolean addPhoneNumber(Name name, String phoneNumber) {
//        if (phoneBook.contains(name)) {
//            return false;
//        } else phoneBook.add(name, phoneNumber);
//        saveFile(phoneBook);
//        return true;
//    }
//
//    /**
//     * This method edits a saved phone number.
//     * @param first: first name
//     * @param last: last name
//     * @param newPhoneNumber: new phone number
//     */
//    public void editPhoneNumber(String first, String last, String newPhoneNumber) {
//        Name name = new Name(first, last);
//        if (phoneBook.contains(name)) phoneBook.add(name, newPhoneNumber);
//        saveFile(phoneBook);
//    }
//
//    /**
//     * This method removes a given phone number from the phonebook
//     * @param first: first name
//     * @param last: last name
//     * @return whether or not it exists
//     */
//    public boolean removePhoneNumber(String first, String last) {
//        Name name = new Name(first, last);
//        if (phoneBook.contains(name)) {
//            phoneBook.remove(name);
//            saveFile(phoneBook);
//            return true;
//        } else System.out.println("This person does not yet exist in the phone directory.");
//        return false;
//    }
//
//    /**
//     * This method converts the dictionary object to a string that can be saved to the file.
//     * @param dictionaryInterface: the dictionary object
//     * @return the converted string.
//     */
//    private String dictionaryToString(DictionaryInterface<Name, String> dictionaryInterface) {
//        Iterator<Name> nameIterator = dictionaryInterface.getKeyIterator();
//        Iterator<String> phoneIterator = dictionaryInterface.getValueIterator();
//        String s = "";
//        while (nameIterator.hasNext()) {
//            Name currentName = nameIterator.next();
//            String phoneNumber = phoneIterator.next();
//            s += currentName.getFirst() + " " + currentName.getLast() + " " + phoneNumber + n;
//        }
//        return s;
//    }
//
//    /**
//     * Gets the phone number of a contact.
//     * @param personName: the name of the contact
//     * @return the phone number
//     */
//    public String getPhoneNumber(Name personName) {
//        return phoneBook.getValue(personName);
//    }
//
//    /**
//     * Similar to the above method.
//     */
//    public String getPhoneNumber(String firstName, String lastName) {
//        Name fullName = new Name(firstName, lastName);
//        return phoneBook.getValue(fullName);
//    }
//
//    /**
//     * Gets the given phonebook in the form of a string that we can then print out.
//     * @return the string
//     */
//    @Override
//    public String toString() {
//        return phoneBook.toString();
//    }
}
