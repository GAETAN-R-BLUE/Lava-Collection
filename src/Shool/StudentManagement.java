/* ***********************************************************************
 * In this program, I am learning the java collection and object-oriented
 * programing.
 * Name: Gaetan, 0101111
 *
 * ***********************************************************************/

package Shool;

import java.util.*;

public class StudentManagement {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
   //     ArrayList<Double> studentGPA = new ArrayList<>(); //Stores only gpa for rapid access For rapid access
        LinkedList<Student> studentList = new LinkedList<>();// Linked list object to store all my student
        HashSet <Integer> usedID = new HashSet<>(); // Hashset table to make sure I do not have any duplicate ID
//        TreeSet<LinkedList<Student>> alphaSort = new TreeSet<>(); // Tree set object to sort all my student in alphabetical order

        while (true) {
            try {
              Menu.showMenu(); // Calling the menu function to display the menu to choose from
              int choice = userInput.nextInt();
              switch (choice) {
                  //Case 1 logic track if an ID is already in use, and add a new student to the list
                    case 1: {
                        Student newStudent = new Student().addNewStudent();
                        // The following track if an ID is already in use
                        if(usedID.contains(newStudent.getID())){
                            System.out.println("The ID you enter is already in used");
                        }
                        else {
                            studentList.add(newStudent);
                            usedID.add(newStudent.getID());
                     //       studentGPA.add(newStudent.getGPA());
                            System.out.println("Student Successfully added\n");
                        }
                        break;
                    }
                    //Case 2 display all the student within the list with all their attributes
                    case 2: {
                        System.out.println("**** Student List ****\n");
                        Student.printStudent(studentList);
                        break;
                    }
                    //case 3 remove a student from the list
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
                            usedID.remove(studentToRemove.getID());
                     //      studentGPA.remove(studentToRemove.getGPA());
                            System.out.println("Student removed successfully");
                        } else {
                            System.out.println("Student not found");
                        }
                        break;
                    }
                    //Case 4 update the student GPA
                  case 4: {
                      System.out.println("Enter the student ID");
                      int ID = userInput.nextInt();
                      System.out.println("Enter the new grade");
                      boolean studentFound = false;
                      double GPA = userInput.nextDouble();
                      for (Student student : studentList) {
                          if (student.getID() == ID) {
                              student.setGPA(GPA);
                              System.out.println("Grade updated successfully");;
                              studentFound = true;
                              break;
                          }
                      }
                      if (!studentFound) {
                          System.out.println("Student not found");
                          break;
                      }
                  }
                  // THE FOLLOWING CLEAR ALL THE STUDENTS FROM THE LIST
                  case 5: {
                      studentList.clear();
                      System.out.println("The list has been clear successfully");
                      break;
                  }
                  // Case :The following search a student based on the Last name
                    case 6: {
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
                        if (!studentFound) {
                            System.out.println("Student not found");
                        }
                        break;
                    }
                    //Print the student base on the ID
                  case 7: {
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
                      if (!studentFound){
                          System.out.println("Student not found");
                      }
                      break;
                  }
                    //CAse 8 display all the student based on the grade (Failing students)
                    case 8: {
                        boolean found = false;
                        for (Student student : studentList) {
                            if (student.getGPA() <= 60) {
                                System.out.println(student.getFirstName() + " " + student.getLastName() + " Grade = " + student.getGPA());
                                found = true;
                            }
                        }
                        if (!found){
                            System.out.println("No student");
                        }
                        break;
                    }
                    //CAse 8 display all the student based on the grade (Passing students)
                  case 9: {
                      boolean found = false;
                        for (Student student : studentList) {
                            if (student.getGPA() > 60) {
                                System.out.println(student.getFirstName() + " " + student.getLastName() + " Grade =" + student.getGPA());
                                found = true;
                            }

                        }
                        if (!found){
                            System.out.println("No student");
                        }
                        break;
                    }
                    //Case 10 sort all the student based on the grade
                case 10: {
                        studentList.sort(Comparator.comparingDouble(Student::getGPA));
                        System.out.println("Student list sorted\n");
                        Student.printStudent(studentList);
                    }
                    break;

                case 11:{
                    studentList.sort(Comparator.comparing(Student::getLastName, String.CASE_INSENSITIVE_ORDER));

                    System.out.println("Student list sorted\n");
                        Student.printStudent(studentList);
                        break;
                    }
                case 12:{
                    studentList.sort(Comparator.comparing(Student::getFirstName, String.CASE_INSENSITIVE_ORDER));

                    System.out.println("Student list sorted\n");
                        Student.printStudent(studentList);
                        break;
                    }
                case 13: {
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

                case 14: {
                    double total = 0;
                    for(Student student : studentList) {
                       total += student.getGPA();
                    }
                    double average = Student.average(studentList.size(), total);
                    break;
                }
                  case 15: {
                      return;
                  }
            }
        }
            catch (Exception e){
                System.out.println("Invalid input Try again ");
            }
        }
    }
}
