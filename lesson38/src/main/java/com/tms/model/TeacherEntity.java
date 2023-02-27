package com.tms.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@ToString
@Setter
@Getter
@Entity
@Table(name = "teacher")
public class TeacherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Boolean remote;
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Embedded
    private Address address;
    @OneToOne
    @JoinColumn(name = "course_id")
    @ToString.Exclude
    private CourseEntity courseEntity;

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TeacherEntity other = (TeacherEntity) obj;
        return Objects.equals(id, other.getId());
    }
}
