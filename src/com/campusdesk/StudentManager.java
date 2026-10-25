package com.campusdesk;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/** In-memory list + CSV persistence. No database, no libraries — pure JDK. */
public class StudentManager {
    private final List<Student> students = new ArrayList<>();

    public boolean add(Student s) {
        if (findByRoll(s.getRoll()) != null) return false; // duplicate roll
        students.add(s);
        return true;
    }

    public Student findByRoll(String roll) {
        return students.stream()
                .filter(s -> s.getRoll().equalsIgnoreCase(roll.trim()))
                .findFirst().orElse(null);
    }

    public List<Student> searchByName(String query) {
        String q = query.trim().toLowerCase();
        return students.stream()
                .filter(s -> s.getName().toLowerCase().contains(q))
                .collect(Collectors.toList());
    }

    public List<Student> allSortedByTotal() {
        return students.stream()
                .sorted(Comparator.comparingInt(Student::total).reversed())
                .collect(Collectors.toList());
    }

    public double classAverage() {
        return students.stream().mapToDouble(Student::average).average().orElse(0);
    }

    public int count() { return students.size(); }
    public List<Student> all() { return new ArrayList<>(students); }

    public void save(Path file) throws IOException {
        List<String> lines = students.stream().map(Student::toCsv).collect(Collectors.toList());
        Files.write(file, lines);
    }

    public int load(Path file) throws IOException {
        if (!Files.exists(file)) return 0;
        int loaded = 0;
        for (String line : Files.readAllLines(file)) {
            if (line.isBlank()) continue;
            Student s = Student.fromCsv(line);
            if (s != null && add(s)) loaded++;
        }
        return loaded;
    }

    public void loadDemoData() {
        Student a = new Student("BCA001", "Aryan Kumar Shah", "BCA");
        a.addMark("C Programming", 92); a.addMark("Maths", 85); a.addMark("English", 78);
        Student b = new Student("BCA002", "Priya Sharma", "BCA");
        b.addMark("C Programming", 88); b.addMark("Maths", 91); b.addMark("English", 84);
        Student c = new Student("BCA003", "Rahul Verma", "BCA");
        c.addMark("C Programming", 65); c.addMark("Maths", 70); c.addMark("English", 58);
        add(a); add(b); add(c);
    }
}
