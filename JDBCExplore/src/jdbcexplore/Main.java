package jdbcexplore;

import java.sql.*;
import java.util.ArrayList;

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
        
        ConnectionConfigurer cc = new ConnectionConfigurer(url, name, pass);
        Connection con = cc.openConnection();
        
        Controller c = new Controller(con);
        
        ArrayList<Student> students = c.getStudents();
        for (Student student : students) {
            System.out.println(student);
        }

        
        
//        // Добавление
//        c.addStudent(new Student("Heh10", 30, "Heh10"));
//        for (Student student : students = c.getStudents()) {
//            System.out.println(student);
//        }
//
//        // Обновление
//        c.updateStudent(13, new Student("Heh11", 31, "Heh11"));
//        for (Student student : students = c.getStudents()) {
//            System.out.println(student);
//        }
//
//        // Поиск
//        System.out.println("\tПоиск по ID: " + c.foundStudentById(5));
//
//        // Удаление
//        c.deleteStudent(13);
//        for (Student student : students = c.getStudents()) {
//            System.out.println(student);
//        }
    }
}