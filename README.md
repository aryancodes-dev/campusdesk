<div align="center">

# 🎓✨ CampusDesk — Student & Marks Manager ✨🎓

### *Pure Java. No external libraries. Ranked lists, search, class stats, and CSV save/load.*

![CampusDesk](https://img.shields.io/badge/🎓_CampusDesk-v1-ED8B00?style=for-the-badge)
![Java](https://img.shields.io/badge/Java-Pure_JDK-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![No Libraries](https://img.shields.io/badge/No_External_Libraries-✅-16A67A?style=for-the-badge)
![OOP](https://img.shields.io/badge/OOP-Done_Properly-0B1220?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-blue?style=for-the-badge)

**A Java console app that manages students and their marks — built with pure JDK, so anyone can compile and run it.**

[![GitHub](https://img.shields.io/badge/GitHub-aryancodes--dev-181717?style=for-the-badge&logo=github)](https://github.com/aryancodes-dev/campusdesk)
[![Portfolio](https://img.shields.io/badge/🌐_Portfolio-aryancodes--dev.github.io-0B1220?style=for-the-badge)](https://aryancodes-dev.github.io/)

</div>

---

## 📑 Table of Contents

- [✨ What is CampusDesk?](#-what-is-campusdesk)
- [🏆 What It Proves (for a Resume)](#-what-it-proves-for-a-resume)
- [🎯 Features](#-features)
- [🚀 How to Use](#-how-to-use)
- [🧪 Try It First](#-try-it-first)
- [🛠️ Tech Stack](#️-tech-stack)
- [📁 Project Structure](#-project-structure)
- [🔒 Privacy & Honest Limits](#-privacy--honest-limits)
- [🤝 Contributing](#-contributing)
- [💜 Credits](#-credits)

---

## ✨ What is CampusDesk?

<div align="center">

| 🎓 | 📊 | 🔍 | 💾 |
|:---:|:---:|:---:|:---:|
| **Students** | **Marks & Grades** | **Search & Rank** | **CSV Save / Load** |

</div>

**CampusDesk manages students and their marks from the terminal — add a student, add marks, see the ranked list, search by name or roll, check class stats, and everything auto-saves to a CSV file.**

```
🎓 CampusDesk
1. Add student (roll, name, course)
2. Add marks per subject
3. View all students — ranked by total marks
4. Search by roll number or name
5. Class stats — total students, class average, topper
6. Load demo data
0. Save & exit
```

> **Pure JDK. No external libraries. No database. No internet.** ☕

---

## 🏆 What It Proves (for a Resume)

<div align="center">

| Skill | How CampusDesk proves it |
|:---|:---|
| 🧩 **OOP done properly** | Separate `Student` (data + grade logic) and `StudentManager` (list, search, sort, persistence) classes — not one giant file |
| 📚 **Collections + Streams** | Search by name, sort by total marks, class average — with Java Collections and Streams |
| 💾 **File persistence** | Students save to `students.csv` and reload on next run |
| ✅ **Validation** | Duplicate roll numbers rejected, marks must be 0–100 |
| 🖥️ **Clean CLI** | Numbered menu, clear output, demo data for instant testing |

</div>

---

## 🎯 Features

<div align="center">

| # | Feature | What it does |
|:---:|---|:---|
| **1** | **Add student** | Roll, name, course — duplicate rolls rejected |
| **2** | **Add marks** | Per subject, with automatic **total, average and grade (A/B/C/D/F)** |
| **3** | **Ranked list** | View all students **ranked by total marks** |
| **4** | **Search** | By roll number **or** name |
| **5** | **Class stats** | Total students, class average, **topper** |
| **6** | **Demo data** | 3 students loaded in one keypress |
| **7** | **Auto-save** | Saves to `students.csv` on exit — re-run the app, your students are still there |

</div>

### 📊 Grades

| Average | Grade |
|:---:|:---:|
| 90–100 | 🅰️ **A** |
| 80–89 | 🅱️ **B** |
| 70–79 | **C** |
| 60–69 | **D** |
| Below 60 | **F** |

---

## 🚀 How to Use

### Run It

```bash
# Compile
javac -encoding UTF-8 -d out src/com/campusdesk/*.java

# Run
java -cp out com.campusdesk.Main
```

**Or, the easy way:**

| System | Command |
|:---|:---|
| 🐧 **Linux / Mac** | `./run.sh` |
| 🪟 **Windows** | `run.bat` |

**Requirements:** Java JDK 8+ • Nothing else — no libraries, no build tool, no internet

---

## 🧪 Try It First

| Step | Press | What happens |
|:---:|---|:---|
| **1** | `6` | Demo data — 3 students loaded in one keypress |
| **2** | `3` | Ranked list — see them sorted by total marks |
| **3** | `5` | Class stats — total students, average, topper |
| **4** | `0` | Save & exit — writes `students.csv` |
| **5** | Run again | Your students are still there, loaded from `students.csv` ✨ |

```
🎓 CampusDesk — Demo
1. Aarav Sharma   | BCA | Total: 452 | Avg: 90.4 | Grade: A
2. Priya Patel    | BCA | Total: 438 | Avg: 87.6 | Grade: B
3. Rohan Kumar    | BCA | Total: 421 | Avg: 84.2 | Grade: B

📊 Class Stats: 3 students | Average: 87.4 | Topper: Aarav Sharma
```

---

## 🛠️ Tech Stack

<div align="center">

| Layer | Technology |
|:---:|:---|
| ☕ **Language** | Java — pure JDK, no external libraries |
| 📚 **Concepts** | OOP, Collections, Streams, File I/O, CSV persistence |
| 🖥️ **Interface** | Clean console CLI — numbered menu |
| 💾 **Storage** | `students.csv` — plain text, human-readable |
| 🐧🪟 **Run** | `run.sh` (Linux/Mac) • `run.bat` (Windows) |

</div>

---

## 📁 Project Structure

```
🎓 campusdesk/
│
├── 📂 src/com/campusdesk/
│   ├── 🏠 Main.java            # Menu + input handling
│   ├── 👤 Student.java         # Student data, total / average / grade, CSV format
│   └── 🗂️ StudentManager.java  # List, search, sort, save / load
├── ▶️ run.sh                   # Run on Linux / Mac
├── ▶️ run.bat                  # Run on Windows
├── 💾 students.csv             # Your data (created on first save)
└── 📖 README.md                # You are here ✨
```

---

## 🔒 Privacy & Honest Limits

- 💾 **Your data stays on your computer** — `students.csv` is a local file, nothing is uploaded
- 🔑 **No account, no server, no internet** — pure offline Java

> **Honest limit:** this is a **console app with CSV storage** — perfect for learning OOP, Collections, and file handling. It is not a web app or a database system. A real college system would need a database, multi-user login, and a web interface — that's a future version, not faked here.

---

## 🤝 Contributing

Found a bug, a better grade rule, or a cleaner menu?

> Open an issue or a pull request — **real improvements only, no fake features.** 🎓

---

## 💜 Credits

<div align="center">

### Built with 💜 by

## **[Aryan Kumar Shah](https://github.com/aryancodes-dev)**
### *Aspiring Software Developer*

[![GitHub](https://img.shields.io/badge/GitHub-aryancodes--dev-181717?style=for-the-badge&logo=github)](https://github.com/aryancodes-dev)
[![YouTube](https://img.shields.io/badge/YouTube-@aryancodes__dev-FF0000?style=for-the-badge&logo=youtube)](https://www.youtube.com/@aryancodes_dev)
[![Portfolio](https://img.shields.io/badge/Portfolio-aryancodes--dev.github.io-0B1220?style=for-the-badge)](https://aryancodes-dev.github.io/)

📧 **Email:** arynkmrshh@gmail.com

---

🎓 *Students, marks, and ranks — managed the clean Java way.* ☕

**⭐ If CampusDesk helped you learn OOP, star this repo! ⭐**

</div>
