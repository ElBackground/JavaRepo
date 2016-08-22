package jdbcexplore;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {

        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Драйвер подключен");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
                
        String  url = "jdbc:postgresql://127.0.0.1:5432/Students", 
                name = "el_background",
                pass = "1111";
        
        Connection con = null;
        
        try {
            
            // *********************************************************
            
            con = DriverManager.getConnection(url, name, pass);
            Controller c = new Controller(con);
            
            ArrayList<Student> students = c.getStudents();
            for (Student student : students) {
                System.out.println(student);
            }
            
            // Добавление
            c.addStudent(new Student("Heh10", 30, "Heh10"));
            for (Student student : students = c.getStudents()) {
                System.out.println(student);
            }
            
            // Обновление
            c.updateStudent(13, new Student("Heh11", 31, "Heh11"));
            for (Student student : students = c.getStudents()) {
                System.out.println(student);
            }
            
            // Поиск
            System.out.println("\tПоиск по ID: " + c.foundStudentById(5));
            
            // Удаление
            c.deleteStudent(13);
            for (Student student : students = c.getStudents()) {
                System.out.println(student);
            }
            
            // *********************************************************
            
        } catch (SQLException e) {
            System.err.println("[!] CONNECTION PROBLEM");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("[!] NO CONNECTION PROBLEM");
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println("[!] CANT CLOSE");
                e.printStackTrace();
            }
        }
    }
}