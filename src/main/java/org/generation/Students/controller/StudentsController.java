package org.generation.Students.controller;

import org.generation.Students.data.entity.Student;
import org.generation.Students.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.cj.util.StringUtils;

@RestController
public class StudentsController {
	private StudentService studentService;

	public StudentsController(@Autowired StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping("/students")
	public Iterable<Student> all(@RequestParam(value="name", required = false) String name) {
		if(!StringUtils.isNullOrEmpty(name)) {
			return studentService.findByNamePrefix(name);
			
		} else {
			return studentService.all();
		}
	}

	@GetMapping("/students/{id}")
	public Student findById(@PathVariable Integer id) {
		return studentService.get(id);
	}

	@PostMapping("/students")
	public void save(@RequestBody Student student) {
		studentService.save(student);
	}

	@PutMapping("/students")
	public void update(@RequestBody Student student) {
		studentService.save(student);
	}

	@DeleteMapping("/students/{id}")
	public void delete(@PathVariable Integer id) {
		studentService.delete(id);
	}

}
