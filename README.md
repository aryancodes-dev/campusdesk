# CampusDesk — Student & Marks Manager

A Java console app that manages students and their marks — built with
**pure JDK, no external libraries**, so anyone can compile and run it.

## What it proves (for a resume)
- **OOP done properly:** separate `Student` (data + grade logic) and
  `StudentManager` (list, search, sort, persistence) classes, not one giant file
- **Collections + Streams:** search by name, sort by total marks, class average
- **File persistence:** students save to `students.csv` and reload on next run
- **Validation:** duplicate roll numbers rejected, marks must be 0–100
- **Clean CLI:** numbered menu, clear output, demo data for instant testing

## Features
1. Add student (roll, name, course)
2. Add marks per subject, with automatic total, average and grade (A/B/C/D/F)
3. View all students **ranked by total marks**
4. Search by roll number or name
5. Class stats: total students, class average, topper
6. Demo data: 3 students loaded in one keypress
7. Auto-save to `students.csv` on exit

## Run it
```bash
javac -encoding UTF-8 -d out src/com/campusdesk/*.java
java -cp out com.campusdesk.Main
```
Or: `./run.sh` on Linux/Mac, `run.bat` on Windows.

Try this first: press **6** (demo data), then **3** (ranked list),
then **5** (class stats), then **0** (save & exit). Re-run the app —
your students are still there, loaded from `students.csv`.

## Project structure
```
src/com/campusdesk/
  Main.java            Menu + input handling
  Student.java         Student data, total/average/grade, CSV format
  StudentManager.java  List, search, sort, save/load
students.csv           Your data (created on first save)
```

## Tech
Java 17 · No dependencies · MIT License

Made by Aryan Kumar Shah · BCA, MAKAUT
