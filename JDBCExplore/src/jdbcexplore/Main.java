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
                
        String  url = "jdbc:postgresql://127.0.0.1:5432/StudentsDB", 
                name = "el_background",
                pass = "1111";
        
        ConnectionConfigurer cc = new ConnectionConfigurer(url, name, pass);
        Connection con = cc.openConnection();
        
        StudentController studentController = new StudentController(con);
        SubjectController subjectController = new SubjectController(con);
        
        System.out.println("Students:");
        ArrayList<StudentModel> students = studentController.getStudents();
        
        for (StudentModel student : students) {
            studentController.studentInit(student);
            System.out.println(student);
        }
        
        cc.closeConnection();
    }
}