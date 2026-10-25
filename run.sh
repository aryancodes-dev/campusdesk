#!/bin/sh
set -e
cd "$(dirname "$0")"
javac -encoding UTF-8 -d out src/com/campusdesk/*.java
java -cp out com.campusdesk.Main
