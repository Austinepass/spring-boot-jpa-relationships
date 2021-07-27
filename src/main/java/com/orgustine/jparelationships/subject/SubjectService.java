package com.orgustine.jparelationships.subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    List<Subject> getAllSubjects(){
        return subjectRepository.findAll();
    }

    Subject createSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    Subject getSubject(Long subjectId) {
        return subjectRepository.findById(subjectId).get();
    }
}
