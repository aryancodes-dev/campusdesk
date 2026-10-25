package com.campusdesk;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

/**
 * CampusDesk — Student & Marks Manager (Java, pure JDK, no libraries).
 *
 * Compile:  javac -d out src/com/campusdesk/*.java
 * Run:      java -cp out com.campusdesk.Main
 * Or simply: ./run.sh   (Linux/Mac)   or   run.bat  (Windows)
 *
 * Data is saved to students.csv in the folder you run it from,
 * so your students survive closing the program.
 */
public class Main {
    private static final Path DATA_FILE = Path.of("students.csv");
    private static final Scanner IN = new Scanner(System.in);
    private static final StudentManager MANAGER = new StudentManager();

    public static void main(String[] args) {
        try {
            int loaded = MANAGER.load(DATA_FILE);
            if (loaded > 0) System.out.println("Loaded " + loaded + " student(s) from students.csv");
        } catch (IOException e) {
            System.out.println("Could not load students.csv: " + e.getMessage());
        }

        while (true) {
            System.out.println("\n===== CampusDesk =====");
            System.out.println("1. Add student");
            System.out.println("2. Add marks to a student");
            System.out.println("3. View all students (ranked by total)");
            System.out.println("4. Search student");
            System.out.println("5. Class stats");
            System.out.println("6. Load demo data (3 students, for quick testing)");
            System.out.println("7. Save now");
            System.out.println("0. Save & Exit");
            System.out.print("Choose: ");
            String choice = IN.nextLine().trim();

            switch (choice) {
                case "1" -> addStudent();
                case "2" -> addMarks();
                case "3" -> viewAll();
                case "4" -> search();
                case "5" -> stats();
                case "6" -> { MANAGER.loadDemoData(); System.out.println("Demo data loaded."); viewAll(); }
                case "7" -> save();
                case "0" -> { save(); System.out.println("Saved. Goodbye!"); return; }
                default -> System.out.println("Invalid choice. Type a number from the menu.");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Roll no: "); String roll = IN.nextLine();
        System.out.print("Name: "); String name = IN.nextLine();
        System.out.print("Course (e.g. BCA): "); String course = IN.nextLine();
        if (roll.isBlank() || name.isBlank()) { System.out.println("Roll and name are required."); return; }
        if (MANAGER.add(new Student(roll, name, course))) System.out.println("Student added.");
        else System.out.println("A student with roll " + roll + " already exists.");
    }

    private static void addMarks() {
        System.out.print("Roll no: "); Student s = MANAGER.findByRoll(IN.nextLine());
        if (s == null) { System.out.println("Student not found."); return; }
        System.out.print("Subject: "); String subject = IN.nextLine();
        System.out.print("Marks (0-100): ");
        try {
            s.addMark(subject, Integer.parseInt(IN.nextLine().trim()));
            System.out.println("Marks added. New total: " + s.total() + ", Grade: " + s.grade());
        } catch (NumberFormatException e) {
            System.out.println("Please type a number for marks.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void viewAll() {
        List<Student> list = MANAGER.allSortedByTotal();
        if (list.isEmpty()) { System.out.println("No students yet. Add one, or press 6 for demo data."); return; }
        System.out.println("\n--- Ranked by total marks ---");
        int rank = 1;
        for (Student s : list) System.out.println(rank++ + ". " + s);
    }

    private static void search() {
        System.out.print("Search by roll or name: "); String q = IN.nextLine();
        Student byRoll = MANAGER.findByRoll(q);
        if (byRoll != null) { System.out.println(byRoll); return; }
        List<Student> found = MANAGER.searchByName(q);
        if (found.isEmpty()) System.out.println("No match found.");
        else found.forEach(System.out::println);
    }

    private static void stats() {
        System.out.println("Total students: " + MANAGER.count());
        System.out.printf("Class average: %.1f%n", MANAGER.classAverage());
        List<Student> ranked = MANAGER.allSortedByTotal();
        if (!ranked.isEmpty()) System.out.println("Topper: " + ranked.get(0).getName()
                + " (" + ranked.get(0).total() + " marks)");
    }

    private static void save() {
        try { MANAGER.save(DATA_FILE); System.out.println("Saved to students.csv"); }
        catch (IOException e) { System.out.println("Save failed: " + e.getMessage()); }
    }
}
