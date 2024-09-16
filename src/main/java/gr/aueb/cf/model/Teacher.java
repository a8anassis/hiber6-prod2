package gr.aueb.cf.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String  firstname;
    private String lastname;

    @ManyToMany(mappedBy = "teachers")
    private Set<Course> courses = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "teacher_more_info_id")
    private TeacherMoreInfo teacherMoreInfo;

    public Teacher() {}

    public Teacher(Long id, String firstname, String lastname, Set<Course> courses,
                   Region region, TeacherMoreInfo teacherMoreInfo) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.courses = courses;
        this.region = region;
        this.teacherMoreInfo = teacherMoreInfo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    protected Set<Course> getCourses() {
        return courses;
    }

    public Set<Course> getAllCourses() {
        return Collections.unmodifiableSet(courses);
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public TeacherMoreInfo getTeacherMoreInfo() {
        return teacherMoreInfo;
    }

    public void setTeacherMoreInfo(TeacherMoreInfo teacherMoreInfo) {
        this.teacherMoreInfo = teacherMoreInfo;
    }

    public void addCourse(Course course) {
        if (courses == null) courses = new HashSet<>();
        courses.add(course);
        course.getTeachers().add(this);
    }

    public void removeCourse(Course course) {
        courses.remove(course);
        course.getTeachers().remove(this);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
