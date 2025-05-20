package Shool;

// This class contains only the menu for the management system for easy maintenance

public class Menu {
    public static void showMenu (){
        System.out.println("== STUDENT MANAGEMENT SYSTEM ==\n" +
                "\n" +
                "1.  Add a student\n" +
                "2.  View all students\n" +
                "3.  Remove a student\n" +
                "4.  Update student grade\n" +
                "5.  Clear all students\n" +
                "\n" +
                "-- SEARCH STUDENTS --\n" +
                "6.  Search by Name\n" +
                "7.  Search by Last ID\n" +
                "\n" +
                "-- PERFORMANCE FILTERS --\n" +
                "8.  Display students with failing grades (≤ 60)\n" +
                "9.  Display students with passing grades (> 60)\n" +
                "\n" +
                "-- SORT STUDENTS --\n" +
                "10. Sort by GPA\n" +
                "11. Sort by last name\n" +
                "12. Sort by first name\n" +

                "-- OTHER OPTIONS --\n" +
                "13. Show total number of students\n" +
                "14. Calculate the average GPA: \n"+
                "15. Exit");
    }
}
