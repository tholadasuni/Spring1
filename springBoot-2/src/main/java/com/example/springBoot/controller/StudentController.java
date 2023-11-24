package com.example.springBoot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.springBoot.bean.Student;
import java.util.*;
@RestController
public class StudentController {
	
	@GetMapping("student")
	public Student getStudent() {
		Student student=new Student(1,"sasu","rahi");
				        return student;	
				        }
	//http://localhost:8080/students/1/sana/salu
	@GetMapping("students")
	public List<Student> getStudents(){
		List<Student> students=new ArrayList<>();
		students.add(new Student(1,"gvg","gfyf"));
		students.add(new Student(4,"gvew","gfyft"));
		students.add(new Student(2,"gvgd","gfyfg"));
		students.add(new Student(3,"gvgs","gfyfh"));
		students.add(new Student(6,"gvga","gfyfm"));
		return students;
	}
	//http://localhost:8080/students/query?id=1&firstname=gve&lastname=gfyft
	@GetMapping("students/{id}/{first-name}/{last-name}")
	public Student studentPathVariable(@PathVariable ("id")int studentId,
			@PathVariable ("first-name")String firstname,
			@PathVariable ("last-name")String lastname){
		return new Student(studentId,firstname,lastname);}
	@GetMapping("students/query")
	public Student studentRequestVariable(@RequestParam int id ,
			@RequestParam String firstname,
			@RequestParam String lastname){
		return new Student(id,firstname,lastname);}
	//spring boot rest API that handles HTTP post request
	//post mapping and request body
	@PostMapping("students/create")
	@ResponseStatus(HttpStatus.CREATED)
   
	public Student createStudent (@RequestBody  Student student) {
    System.out.println(student.getId());
    System.out.println(student.getFirstName());
    System.out.println(student.getLastName());
    return student;
	}
	//spring boot rest API that handles http put request updating existing resource

	@PutMapping("students/{id}/update")
	public Student updateStudent(@RequestBody Student student, @PathVariable("id")int studentId) {
		System.out.println( student.getFirstName()); 
		System.out.println( student.getLastName());
		return student;
		}
	//spring boot rest API that handles http delete request deleting the existing resource
	@DeleteMapping ("students/{id}/delete")
	public String deleteStudent (@PathVariable ("id") int studentId) { 
		System.out.println (studentId );
		return "student deleted successfully";
	}}
	
	
	
		
	
	




