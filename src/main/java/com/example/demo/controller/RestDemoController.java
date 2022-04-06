package com.example.demo.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.objects.Person;
import com.example.demo.service.FirebaseService;

@RestController
public class RestDemoController {

	@Autowired
	FirebaseService firebaseService;

	@GetMapping("/getUserDetails")
	public Person getUserDetails(@RequestHeader() String name) throws InterruptedException, ExecutionException {
		return new Person(name, "30", "Dallas");
	}

	@GetMapping("/createUser")
	public String createUser(@RequestBody Person person) throws InterruptedException, ExecutionException {
		return firebaseService.saveUserDetails(person);
	}

	@PutMapping("/updateUser")
	public String updateUser(@RequestBody Person person) throws InterruptedException, ExecutionException {
		return "Updated User" + person.getName();
	}

	@DeleteMapping("/deleteUser")
	public String deleteUser(@RequestHeader String name) {
		return "Deleted User " + name;
	}

}
