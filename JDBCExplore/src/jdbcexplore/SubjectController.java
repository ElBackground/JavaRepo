package jdbcexplore;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SubjectController {
    
    private Connection con;

    public SubjectController(Connection con) {
        this.con = con;
    }
    
    
    void addSubject(SubjectModel subject) {
        try {
            Statement statement = con.createStatement();
            statement.executeUpdate(
                    "insert into Subjects (name) values('" + subject.name + "')"
            );
            System.out.println("\t[<-] Добавлено: " + subject);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    void updateSubject(SubjectModel subject, SubjectModel newSubject) {
        try {
            Statement statement = con.createStatement();
            if (statement.executeUpdate(
                    "update Subjects SET name = '" + newSubject.name + "',"
                            + " WHERE student_id = " + subject.id
            ) != 0) {
                System.out.println("\t[<-] Обновлено " + subject + " до " + newSubject);
            } else {
                System.out.println("\t[<-] Запись не найдена");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    void removeSubject(SubjectModel subject) {
        try {
            Statement statement = con.createStatement();
            if (statement.executeUpdate(
                    "delete from Subjects "
                            + "where student_id = " + subject.id
            ) != 0) {
                System.out.println("\t[<-] Удалено: " + subject);
            } else {
                System.out.println("\t[<-] Запись не найдена");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public ArrayList<SubjectModel> getSubjects() {
        try {
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(
                    "select * from Subjects"
            );
            
            ArrayList<SubjectModel> subjects = new ArrayList<>();
            while (result.next()) {
                subjects.add(
                        new SubjectModel(
                                result.getInt("subject_id"),
                                result.getString("name")
                        )
                );
            }
            return subjects;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}