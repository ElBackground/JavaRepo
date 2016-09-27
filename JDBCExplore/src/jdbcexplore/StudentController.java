package jdbcexplore;

import java.sql.*;
import java.util.ArrayList;

public class StudentController {

    private Connection con;
    
    public StudentController(Connection con) {
        this.con = con;
    }

    public void addStudent(StudentModel student) {
        try {
            Statement statement = con.createStatement();
            statement.executeUpdate(
                    "insert into Students (name, age, adress) values('"
                            + student.name + "', "
                            + student.age + ", '"
                            + student.adress + "')"
            );
            System.out.println("\t[<-] Добавлено: " + student);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateStudent(StudentModel student, StudentModel newStudent) {
        try {
            Statement statement = con.createStatement();
            if (statement.executeUpdate(
                    "update Students "
                            + "SET name = '" + newStudent.name 
                            + "', age = " + newStudent.age 
                            + ", adress = '" + newStudent.adress 
                            + "' WHERE student_id = " + student.id
            ) != 0) {
                System.out.println("\t[<-] Обновлено " + student + " до " + newStudent);
            } else {
                System.out.println("\t[<-] Запись не найдена");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void removeStudent(StudentModel student) {
        try {
            Statement statement = con.createStatement();
            if (statement.executeUpdate(
                    "delete from Students "
                            + "where student_id = " + student.id
            ) != 0) {
                System.out.println("\t[<-] Удалено: id#" + student.id);
            } else {
                System.out.println("\t[<-] Запись не найдена");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void addSubjectToStudent(StudentModel student, SubjectModel subject) { //setofsubjects
        try {
            Statement statement = con.createStatement();
            statement.executeUpdate(
                    "insert into SetOfSubjects (student_id, subject_id) values("
                            + student.id + ", " + subject.id + ")"
            );
            System.out.println("\t[<-] Добавлено " + subject + " к " + student);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public ArrayList<StudentModel> getStudents() {
        try {
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(
                    "select * from students"
            );
            
            ArrayList<StudentModel> students = new ArrayList<>();
            while (result.next()) {
                StudentModel student = new StudentModel(
                        result.getInt("student_id"),
                        result.getString("name"),
                        result.getInt("age"),
                        result.getString("adress")
                );
                students.add(student);
            }
            
            return students;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public void studentInit(StudentModel student) {
        try {
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(
                    "select "  // stu.student_id as student_id, "
                    + "sub.subject_id as subject_id, "
                    + "sub.name as subject "
                    + "from students as stu"
                    + " join setofsubjects as set "
                        + "on stu.student_id = set.student_id "
                    + "join subjects as sub "
                        + "on sub.subject_id = set.subject_id "
                    + "where stu.student_id = " + student.id
            );
            
            while (result.next()) {
                student.subjects.add(new SubjectModel(
                        result.getInt("subject_id"),
                        result.getString("subject"))
                );
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

/*
select stu.student_id as student_id,
sub.subject_id as subject_id,
stu.name as name,
stu.age as age, 
stu.adress as adress,
sub.name as subject 
from students as stu
    join
        setofsubjects as set 
            on stu.student_id = set.student_id 
    join
        subjects as sub
            on sub.subject_id = set.subject_id

        where stu.student_id = ...

*/