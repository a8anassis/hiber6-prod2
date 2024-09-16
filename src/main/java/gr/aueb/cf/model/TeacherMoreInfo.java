package gr.aueb.cf.model;

import gr.aueb.cf.core.GenderType;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "teacher_more_info")
public class TeacherMoreInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_of_birth")
    private LocalDateTime dateOfBirth;

    @Enumerated(EnumType.STRING)
    private GenderType gender;

    @OneToOne(mappedBy = "teacherMoreInfo")
    private Teacher teacher;

    public TeacherMoreInfo() {}

    public TeacherMoreInfo(Long id, LocalDateTime dateOfBirth, GenderType gender, Teacher teacher) {
        this.id = id;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.teacher = teacher;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
