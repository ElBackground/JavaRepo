package jdbcexplore;

public class SubjectModel {
    
    public int id;
    public String name;

    public SubjectModel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "id#" + this.id + " " + this.name;
    }
}