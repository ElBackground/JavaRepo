package jdbcexplore;

import java.sql.*;
import java.util.ArrayList;

public class Controller {

    private ArrayList<Student> students;
    private Connection con;
    
    public Controller(Connection con) {
        this.con = con;
        this. students = new ArrayList<Student>();
    }

    public void addStudent(Student student) throws SQLException {
        Statement statement = con.createStatement();
        statement.executeUpdate(
                "insert into Students (name, age, adress) values('" 
                + student.name + "', "
                + student.age + ", '" 
                + student.adress + "')"
        );
        System.out.println("\t[<-] Добавлено: " + student.name + "(" + student.age + " yo) \tadress: " + student.adress);
    }

    public void updateStudent(int id, Student student) throws SQLException {
        Statement statement = con.createStatement();
        if (statement.executeUpdate(
                "update Students "
                + "SET name = '" + student.name + "', age = " + student.age + ", adress = '" + student.adress + "' "
                + "WHERE student_id = " + id
        ) != 0) { 
            System.out.println("\t[<-] Обновлено: id#" + id + " " + student.name + "(" + student.age + " yo) \tadress: " + student.adress);
        } else {
            System.out.println("\t[<-] Запись id#" + id + " не найдена");
        }
    }

    public void deleteStudent(int id) throws SQLException {
        Statement statement = con.createStatement();
        if (statement.executeUpdate(
                "delete from Students " 
                + "where student_id = " + id
        ) != 0) { 
            System.out.println("\t[<-] Удалено: id#" + id);
        } else {
            System.out.println("\t[<-] Запись id#" + id + " не найдена");
        }
    }

    public Student foundStudentById(int id) throws SQLException {
        Statement statement = con.createStatement();
        ResultSet result = statement.executeQuery(
                "select * from Students "
                + "where student_id = " + id
        );
        if(result.next()) { 
            return new Student(
                result.getInt("student_id"),
                result.getString("name"),
                result.getInt("age"),
                result.getString("adress")
            );
        } else {
            return null;
        }
    }

    public ArrayList<Student> getStudents() throws SQLException {
        Statement statement = con.createStatement();
        ResultSet result = statement.executeQuery(
                "select * from Students"
        );
        
        students.clear();
        while (result.next()) {
            students.add(
                new Student(
                    result.getInt("student_id"),
                    result.getString("name"),
                    result.getInt("age"),
                    result.getString("adress")
                )
            );
        }
        return students;
    }
}
