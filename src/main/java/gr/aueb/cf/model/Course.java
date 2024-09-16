package gr.aueb.cf.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @ManyToMany
    @JoinTable(name = "courses_teachers",
            joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id", referencedColumnName = "id"))
    private Set<Teacher> teachers = new HashSet<>();

    public Course() {}

    public Course(Long id, String title, Set<Teacher> teachers) {
        this.id = id;
        this.title = title;
        this.teachers = teachers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    protected Set<Teacher> getTeachers() {
        return teachers;
    }

    public Set<Teacher> getAllTeachers() {
        return Collections.unmodifiableSet(teachers);
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }

    public void addTeacher(Teacher teacher) {
        if (teachers == null) teachers = new HashSet<>();
        teachers.add(teacher);
        teacher.getCourses().add(this);
    }

    public void removeTeacher(Teacher teacher) {
        teachers.remove(teacher);
        teacher.getCourses().remove(this);
    }

}
