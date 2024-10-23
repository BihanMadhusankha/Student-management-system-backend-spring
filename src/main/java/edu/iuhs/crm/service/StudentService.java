package edu.iuhs.crm.service;

import edu.iuhs.crm.modle.Student;

import java.util.List;

public interface StudentService {

    Student persist(Student student);

    List<Student> retrive();

    void delete(Integer id);

    Student update(Student student,Integer id);
}
