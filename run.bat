@echo off
javac -encoding UTF-8 -d out src\com\campusdesk\*.java
java -cp out com.campusdesk.Main
