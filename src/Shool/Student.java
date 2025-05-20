package Shool;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

public class Student {
    private int  ID;
    private String lastName;
    private String firstName;
    private double GPA;
    Scanner userInput = new Scanner(System.in);

    //The following is a default constructor for the student object
    public Student (){
        GPA = 0;
        ID = 0;
        firstName = "name";
        lastName = "name";
    }

    public Student(int ID, String lastName, String firstName, double grade, Scanner userInput) {
        this.ID = ID;
        this.lastName = lastName;
        this.firstName = firstName;
        this.GPA = grade;
        this.userInput = userInput;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // constructor for my student object
    public Student (int ID, String lastName,String firstName, double GPA) {
        this.ID =  ID;
        this.lastName = lastName;
        this.GPA = GPA;
        this.firstName = firstName;

    }
    // setter method for name
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    //getter method for ID
    public int getID() {
        return ID;
    }
    // setter method for ID
    public void setID(int ID) {
        this.ID = ID;
    }

    //getter method for name
    public String getLastName() {
        return lastName;
    }

    //getter method for grade
    public double getGPA() {
        return GPA;
    }

    // setter method for grade
    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    // The following method get the student credential
    public Student addNewStudent () {
        try {
            System.out.println("Enter the last name");
            lastName = userInput.nextLine();
            System.out.println("Enter the First name");
            firstName = userInput.nextLine();
            System.out.println("Enter the ID");
            ID = userInput.nextInt();
            System.out.println("Enter the grade");
            GPA = userInput.nextDouble();
            Student newStudent = new Student(ID, lastName, firstName, GPA);
            return newStudent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //The following method get the student ID
    public static Student  getStudentID(int ID, ArrayList <Student> list){
        for (Student student : list){
            if (student.getID() == ID){
                return student;
            }
        }
        System.out.println("Student not found.");
        return null;
    }


    //the following method print the student credential when called
    public static void printStudent(LinkedList<Student> list){
        for (Student student : list ){
            System.out.println(student);
        }
    }
    // The following method calculate the average
    public static double average (double totalCount, double gpaTotal){
        return (gpaTotal/totalCount);
    }
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Student student)) return false;
        return ID == student.ID && Double.compare(GPA, student.GPA) == 0 && Objects.equals(lastName, student.lastName);
    }

    @Override
    public String toString() {
        return
                "Name: " + firstName + " " + lastName + "\n" +
                "ID: " + ID + "\n" +
                "Grade: " + GPA + "\n";
    }
}
/* ********************************
 * One thing I need to remember is
 * that whenever I need to access
 * or change the attributes of an
 * object, all I need to do is to
 * create another method.
 * ********************************/