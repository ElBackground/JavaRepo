package jdbcexplore;

public class Student {    
    public int id;
    public String name;
    public int age;
    public String adress;

    public Student(int id, String name, int age, String adress) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.adress = adress;
    }

    public Student(String name, int age, String adress) {
        this.name = name;
        this.age = age;
        this.adress = adress;
    }
    
    @Override
    public String toString() {
        return "id#" + this.id +" " + this.name + "(" + this.age + " yo) \tadress: " + this.adress;
    }
}
