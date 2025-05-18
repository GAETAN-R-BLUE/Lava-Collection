/* ***********************************************************************
 * In this program, I am learning the java collection and object-oriented
 * programing.
 * Name: Gaetan, 0101111
 * ***********************************************************************/
package Shool;

import com.sun.jdi.DoubleValue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class StudentManagement {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        ArrayList<Student> studentList = new ArrayList<>();

        while (true) {
            try {
                System.out.println("** Enter your Choice**\n\n" +
                        "1. Add a student\n" +
                        "2. View all the student\n" +
                        "3. Remove a student\n" +
                        "4. Search Student by ID\n" +
                        "5. Search by Last Name\n" +
                        "6. Update student grade\n" +
                        "7. Display Student Failing\n" +
                        "8. Display Passing\n" +
                        "9. Sort Student by grade\n" +
                        "10. Show Total Students\n" +
                        "11. Clear all student\n" +
                        "12. Exit");
                int choice = userInput.nextInt();
                switch (choice) {
                    case 1: {
                        Student student = new Student();
                        Student newStudent = student.addNewStudent();
                        studentList.add(newStudent);
                        System.out.println("Student Successfully added\n");
                        break;
                    }
                    case 2: {
                        System.out.println("**** Student List ****\n");
                        Student.printStudent(studentList);
                        break;
                    }
                    case 3: {
                        Student studentToRemove = null;
                        System.out.println("Enter the student ID");
                        int ID = userInput.nextInt();
                        for (Student student : studentList) {
                            if (student.getID() == ID) {
                                studentToRemove = student;
                                break;
                            }
                        }
                        if (studentToRemove != null) {
                            studentList.remove(studentToRemove);
                            System.out.println("Student removed successfully");
                        } else {
                            System.out.println("Student not found");
                        }
                        break;
                    }
                    //Print the student base on the ID
                    case 4: {
                        System.out.println("Enter the student ID");
                        int ID = userInput.nextInt();
                        boolean studentFound = false;
                        for (Student student : studentList) {
                            if (student.getID() == ID) {
                                System.out.println(student);
                                studentFound = true;
                                break;
                            }
                        }
                        if (studentFound != true){
                            System.out.println("Student not found");
                        }
                        break;
                    }
                    case 5: {
                        userInput.nextLine();
                        System.out.println("Enter the student Last name");
                        String lastNAme = userInput.nextLine();
                        boolean studentFound = false;
                        for (Student student : studentList) {
                            if (student.getLastName().equals(lastNAme)) {
                                System.out.println(student);
                                studentFound = true;
                            }
                        }
                        if (studentFound != true) {
                            System.out.println("Student not found");
                        }
                        break;
                    }
                    case 6: {
                        System.out.println("Enter the student ID");
                        int ID = userInput.nextInt();
                        System.out.println("Enter the new grade");
                        boolean studentFound = false;
                        double newGrade = userInput.nextDouble();
                        for (Student student : studentList) {
                            if (student.getID() == ID) {
                                student.setGrade(newGrade);
                                System.out.println("Grade updated successfully");;
                               studentFound = true;
                                break;
                            }
                        }
                        if (studentFound != true) {
                            System.out.println("Student not found");
                            break;
                        }
                    }
                    case 7: {
                        for (Student student : studentList) {
                            if (student.getGrade() <= 60) {
                                System.out.println(student.getFirstName() + " " + student.getLastName() + ", Grade =" + student.getGrade());
                            }
                        }
                        break;
                    }
                    case 8: {
                        for (Student student : studentList) {
                            if (student.getGrade() > 60) {
                                System.out.println(student.getFirstName() + " " + student.getLastName() + ", Grade =" + student.getGrade());
                            }
                        }
                        break;
                    }
                    case 9: {
                        Collections.sort(studentList, Comparator.comparingDouble(Student::getGrade));
                        System.out.println("Student list sorted\n");
                        Student.printStudent(studentList);
                    }
                    break;

                case 10: {
                    if (studentList.isEmpty()) {
                        System.out.println("There is no student");
                    }
                    if (studentList.size() > 1) {

                        System.out.println("There is a total of " + studentList.size() + " students. ");
                    } else {

                        System.out.println("There is 1 student");
                    }
                    break;
                }
                case 11: {
                    studentList.clear();
                    System.out.println("The list has been clear successfully");
                    break;
                }
                case 12: {
                    return;
                }
            }
        }
            catch (Exception e){
                System.out.println("Invalid input Try again");
            }
        }
    }
}
