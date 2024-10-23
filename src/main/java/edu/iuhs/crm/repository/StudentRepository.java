package edu.iuhs.crm.repository;


import edu.iuhs.crm.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<StudentEntity, Integer> {

}
