package edu.iuhs.crm.service.imp;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.iuhs.crm.entity.StudentEntity;
import edu.iuhs.crm.exception.CustomNotDeleteStudentIdExeption;
import edu.iuhs.crm.exception.CustomNotFoundException;
import edu.iuhs.crm.exception.CustomNotFoundStudentsExceptionHandler;
import edu.iuhs.crm.modle.Student;
import edu.iuhs.crm.repository.StudentRepository;
import edu.iuhs.crm.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    private final ObjectMapper mapper;

    @Override
    public Student persist(Student student) {
        if (student.customNullValue(student)){
            throw new CustomNotFoundException("Please fill the all data");
        }
        StudentEntity studentEntity = studentRepository.save(
                mapper.convertValue(student, StudentEntity.class)
        );

        return mapper.convertValue(
                studentEntity, Student.class
        );
    }

    @Override
    public List<Student> retrive() {
        List<Student> studentList = new ArrayList<>();
        Iterable<StudentEntity> allStudent = studentRepository.findAll();
        if (allStudent==null)
            throw new CustomNotFoundStudentsExceptionHandler("You can't view all Students");
        allStudent.forEach(studentEntity->{
            studentList.add(
                    mapper.convertValue(studentEntity, Student.class)
            );
        });
        return studentList;
    }

    @Override
    public void delete(Integer id) {
        Optional<StudentEntity> byId = studentRepository.findById(id);
        if ( byId.isEmpty())
            throw new CustomNotDeleteStudentIdExeption("You can't delete student");
        studentRepository.deleteById(id);
    }

    @Override
    public Student update(Student student, Integer id) {

        if (!student.customNullValue(student)) {
            throw new CustomNotFoundException("Student Not Found");
        }

        Optional<StudentEntity> byId = studentRepository.findById(id);
        if ( byId.isEmpty())
            throw new CustomNotDeleteStudentIdExeption("You can't update the student student");

        StudentEntity studentEntity = byId.get();

        studentEntity.setName(student.getName());
        studentEntity.setAge(student.getAge());
        studentEntity.setContact(student.getContact());
        studentEntity.setPname(student.getPname());
        studentEntity.setPaddress(student.getPaddress());
        studentEntity.setPcontact(student.getPcontact());

        return mapper.convertValue(
                studentRepository.save(studentEntity), Student.class
        );
    }
}
