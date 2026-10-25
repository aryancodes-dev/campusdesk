package com.campusdesk;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * One student. Marks live in insertion order so a report reads
 * in the order subjects were added.
 */
public class Student {
    private final String roll;
    private final String name;
    private final String course;
    private final Map<String, Integer> marks = new LinkedHashMap<>();

    public Student(String roll, String name, String course) {
        this.roll = roll.trim();
        this.name = name.trim();
        this.course = course.trim();
    }

    public String getRoll() { return roll; }
    public String getName() { return name; }
    public String getCourse() { return course; }
    public Map<String, Integer> getMarks() { return marks; }

    public void addMark(String subject, int mark) {
        if (mark < 0 || mark > 100) {
            throw new IllegalArgumentException("Mark must be 0-100, got " + mark);
        }
        marks.put(subject.trim(), mark);
    }

    public int total() {
        return marks.values().stream().mapToInt(Integer::intValue).sum();
    }

    public double average() {
        return marks.isEmpty() ? 0 : (double) total() / marks.size();
    }

    public String grade() {
        double avg = average();
        if (marks.isEmpty()) return "N/A";
        if (avg >= 90) return "A";
        if (avg >= 75) return "B";
        if (avg >= 60) return "C";
        if (avg >= 40) return "D";
        return "F";
    }

    /** CSV: roll,name,course,Subject:mark;Subject:mark */
    public String toCsv() {
        StringBuilder sb = new StringBuilder();
        sb.append(roll).append(",").append(name).append(",").append(course).append(",");
        boolean first = true;
        for (Map.Entry<String, Integer> e : marks.entrySet()) {
            if (!first) sb.append(";");
            sb.append(e.getKey()).append(":").append(e.getValue());
            first = false;
        }
        return sb.toString();
    }

    public static Student fromCsv(String line) {
        String[] parts = line.split(",", -1);
        if (parts.length < 3) return null;
        Student s = new Student(parts[0], parts[1], parts[2]);
        if (parts.length >= 4 && !parts[3].isBlank()) {
            for (String pair : parts[3].split(";")) {
                String[] kv = pair.split(":");
                if (kv.length == 2) {
                    try { s.addMark(kv[0], Integer.parseInt(kv[1])); }
                    catch (NumberFormatException ignored) { /* skip bad mark */ }
                }
            }
        }
        return s;
    }

    @Override
    public String toString() {
        return String.format("%-8s %-20s %-8s Total: %-4d Avg: %-6.1f Grade: %s  Marks: %s",
                roll, name, course, total(), average(), grade(), marks);
    }
}
