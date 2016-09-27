package jdbcexplore;

import java.util.ArrayList;
import java.util.HashSet;

public class StudentModel {  
    
    public int id;
    public String name;
    public int age;
    public String adress;
    public ArrayList<SubjectModel> subjects;

    public StudentModel(int id, String name, int age, String adress) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.adress = adress;
        subjects = new ArrayList<>();
    }
    
    @Override
    public String toString() {
        String student = "id#" + this.id + " " + this.name + "(" + this.age + " yo) adress: " + this.adress;
        for (SubjectModel subject : subjects) {
            student += "\n\t + " + subject;
        }
        return student;
    }
}
