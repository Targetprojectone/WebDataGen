package com.datapopulator.spring.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datapopulator.spring.Dao.Person;
import com.datapopulator.spring.Service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	PersonService personService;
	
	@RequestMapping("/")
	public List<Person> getPersons() {
		Logger logger = LoggerFactory.getLogger(PersonController.class);
		System.out.println("Reached call to get Persons Rest API");
		return personService.getAllPersons();
		
	}
	
	@RequestMapping("/{personId}")
	public Person getPerson(@PathVariable("personId") Integer personId) {
		System.out.println("Reached call to get Person Rest API");
		return personService.getPerson(personId);
		
	}
	
	@PostMapping("/")
	public void addPerson(@RequestBody Person person) {
		System.out.println("Reached call to add Person Rest API");
		 personService.addPerson(person);
	}

	@DeleteMapping("/{personId}")
	public void deletePerson(@PathVariable("personId") Integer personId) {
		System.out.println("Reached call to delete Person Rest API");
		personService.deletePerson(personId);
		
	}

	@DeleteMapping("/clear")
	public void deleteAllPersons() {
		System.out.println("Reached call to delete all Persons Rest API");
		personService.deleteAllPersons();
		
	}
	
	
	@PutMapping("/{personId}")
	public void updatePerson(@PathVariable("personId") Integer personId,@RequestBody Person person) {
		person.setPersonId(personId);
		System.out.println("Reached call to update Person Rest API");
		personService.updatePerson(person );
		
	}
	
}
