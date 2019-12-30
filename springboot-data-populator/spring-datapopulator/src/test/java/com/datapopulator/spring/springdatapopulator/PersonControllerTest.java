package com.datapopulator.spring.springdatapopulator;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.datapopulator.spring.Controller.PersonController;
import com.datapopulator.spring.Dao.Person;
@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonControllerTest {

	@Autowired
	PersonController controller;
	
	
	@Test
	public void getPersons() {
		List<Person> persons = controller.getPersons();
		assertTrue(!persons.isEmpty());
		
	}

	@Test
	public void deletePerson() {

		Person ex = new Person("delete", "delLas", 100, "Arab");
		controller.addPerson(ex);
		controller.deletePerson(ex.getPersonId());
		assertFalse(controller.getPersons().stream().
				anyMatch(o -> (o.getPersonId() == ex.getPersonId())));

	}
	
	
	
}
