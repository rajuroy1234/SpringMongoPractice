package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roy.demo.data.models.Student;

import Repo.StudentRepository;

@RestController
@RequestMapping("/student")
public class MyController {
	@Autowired
	private StudentRepository studentRepository;
	
	@PostMapping("/save")
	public ResponseEntity<?> addStudent (@RequestBody Student student)
	{
		Student save = this.studentRepository.save(student);
		return ResponseEntity.ok(save);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<?> getStudents()
	{
		return ResponseEntity.ok(this.studentRepository.findAll());
	}
}
