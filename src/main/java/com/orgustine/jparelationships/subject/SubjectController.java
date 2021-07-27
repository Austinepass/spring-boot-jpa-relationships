package com.orgustine.jparelationships.subject;

import com.orgustine.jparelationships.student.Student;
import com.orgustine.jparelationships.student.StudentService;
import com.orgustine.jparelationships.teacher.Teacher;
import com.orgustine.jparelationships.teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {
    private final SubjectService subjectService;
    private final StudentService studentService;
    private final TeacherService teacherService;

    @Autowired
    public SubjectController(SubjectService subjectService, StudentService studentService, TeacherService teacherService) {
        this.subjectService = subjectService;
        this.studentService = studentService;
        this.teacherService = teacherService;
    }

    @GetMapping
    List<Subject> getAllSubjects(){
        return subjectService.getAllSubjects();
    }

    @PostMapping
    Subject createSubject(@RequestBody Subject subject) {
        return subjectService.createSubject(subject);
    }

    @PutMapping("/{subjectId}/students/{studentId}")
    Subject enrollStudentToSubject(
            @PathVariable Long subjectId,
            @PathVariable Long studentId
    )
    {
        Subject subject = subjectService.getSubject(subjectId);
        Student student = studentService.getStudent(studentId);
        subject.enrollStudent(student);
        return subjectService.createSubject(subject);
    }

    @PutMapping("/{subjectId}/teacher/{teacherId}")
    Subject assignTeacher(
            @PathVariable Long subjectId,
            @PathVariable Long teacherId
    )
    {
        Subject subject = subjectService.getSubject(subjectId);
        Teacher teacher = teacherService.getTeacher(teacherId);
        subject.assignTeacher(teacher);
        return subjectService.createSubject(subject);
    }
}
