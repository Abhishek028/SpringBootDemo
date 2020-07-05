package ashwini.abhishek.courses;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Topic {
    @Id
    private int id;
    private String name;
    @ManyToOne
    private Course course;

    public Topic(int id, String name, Course course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    public Topic() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
