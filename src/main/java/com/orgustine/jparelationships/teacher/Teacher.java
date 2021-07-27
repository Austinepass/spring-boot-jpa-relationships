package com.orgustine.jparelationships.teacher;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.orgustine.jparelationships.subject.Subject;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Teacher {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "teacher")
    private Set<Subject> subjects= new HashSet<>();
}
