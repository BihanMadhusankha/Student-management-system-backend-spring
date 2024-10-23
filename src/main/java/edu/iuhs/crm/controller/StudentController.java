package edu.iuhs.crm.controller;

import edu.iuhs.crm.modle.Student;
import edu.iuhs.crm.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/student")
@Slf4j
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    Student persist(@RequestBody Student student){
        return studentService.persist(student);
    }

    @GetMapping
    List<Student> retrive(){
        return studentService.retrive();
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id){
        studentService.delete(id);
    }
    @PutMapping("/{id}")
    Student update(@RequestBody Student student, @PathVariable Integer id){
        return studentService.update(student,id);
    }

}
