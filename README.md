# Online Event Catering and Booking System

**Student:** Francis Xavier Baculi  
**Course:** PF201: OOP

Layered Java console app connected to SQLite (Maven).

## Structure
```
pom.xml
src/main/java/
  Main.java                  - entry point
  dao/DatabaseConnection.java - SQLite connection + users table setup
  dao/UserDao.java           - register / login queries (PreparedStatement)
  model/User.java            - Java record
  ui/MainMenu.java           - Register / Login / Exit
  ui/UserMenu.java           - post-login menu (Logout)
```

## users table
`id, username, password, roles (TEACHER | STUDENT), status (default PENDING)`

Passwords are stored as SHA-256 hashes.

## Run
```
mvn compile exec:java
```
(or open the folder in IntelliJ / NetBeans / Eclipse as a Maven project and run `Main`)

The database file `cateringbooking.db` is created automatically on first run.
