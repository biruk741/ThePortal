package com.datastructures;

import com.datastructures.Dictionaries.SortedArrayDictionary;
import com.datastructures.Objects.Grade;
import com.datastructures.Objects.User;
import com.datastructures.interfaces.DictionaryInterface;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class GradesManager {
    private final DictionaryInterface<String, Grade> grades;
    private static Scanner data;
    private static final String n = "\n";
    public static String fileName;


    @SuppressWarnings("ResultOfMethodCallIgnored")
    public GradesManager(String studentUsername) {
        grades = new SortedArrayDictionary<>();
        fileName = studentUsername + "_grades.txt";
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
            String name = data.next();
            String grade = data.next();
            grades.add(name, new Grade(name, grade));
        }
        data.close();
    }

    /**
     * This method saves the contents of the user record to the record file
     */
    private void saveFile() {
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(dictionaryToString(grades));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean assignmentExists(String name) {
        return grades.contains(name);
    }

    /**
     * This method converts the dictionary object to a string that can be saved to the file.
     *
     * @param dictionaryInterface: the dictionary object
     * @return the converted string.
     */
    private String dictionaryToString(DictionaryInterface<String, Grade> dictionaryInterface) {
        Iterator<String> nameIterator = dictionaryInterface.getKeyIterator();
        Iterator<Grade> gradeIterator = dictionaryInterface.getValueIterator();
        String s = "";
        while (nameIterator.hasNext()) {
            String currentName = nameIterator.next();
            Grade currentGrade = gradeIterator.next();
            s += currentName + " " + currentGrade.getGrade() + n;
        }
        return s;
    }
    public void addGrade(Grade grade){
        grades.add(grade.getName(),grade);
        saveFile();
    }

    public void editGrade(String assignmentName, Grade newGrade){
        grades.add(assignmentName,newGrade);
        saveFile();
    }

    public void removeGrade(String assignmentName){
        grades.remove(assignmentName);
        saveFile();
    }

    public ArrayList<Grade> getAllGrades(){
        ArrayList<Grade> gradeArrayList = new ArrayList<>();
        Iterator<Grade> theGradeIterator = grades.getValueIterator();
        while(theGradeIterator.hasNext()){
            gradeArrayList.add(theGradeIterator.next());
        }
        //....
        return gradeArrayList;
    }



    public Grade getGrade(String name) {
        return grades.getValue(name);
    }

    /**
     * Gets the user records in the form of a string
     *
     * @return the string
     */
    @Override
    public String toString() {
        return grades.toString();
    }
}
