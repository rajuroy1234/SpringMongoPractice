package Repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.roy.demo.data.models.Student;

public interface StudentRepository extends MongoRepository<Student, Integer> {

}
