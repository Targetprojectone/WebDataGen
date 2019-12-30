package com.datapopulator.spring.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datapopulator.spring.Dao.Person;
import com.datapopulator.spring.Dao.PersonRepository;

@Service
public class PersonService {

	@Autowired
	PersonRepository personRepository;

	public List<Person> getAllPersons() {
		return personRepository.findAll();

	}

	public Person getPerson(int personId) {

		Optional<Person> person = personRepository.findById(personId);

		return person.isPresent() ? person.get() : null;

	}

	public void addPerson(Person person) {

		personRepository.save(person);

	}

	public void updatePerson(Person person) {

		personRepository.save(person);

	}

	public void deletePerson(int personId) {

		personRepository.deleteById(personId);

	}
	public void deleteAllPersons() {
		personRepository.deleteAll();
	}

	@PostConstruct
	private void createPersons() {
		if(!getAllPersons().isEmpty()) {
			return;
		}
		System.out.println("Called pre Persist method");
		Person person1 = new Person("Sri", "Lingamaneni", 28, "USA");
		Person person2 = new Person("Vara", "Lingamaneni", 12, "IND");
		Person person3 = new Person("John", "Beck", 34, "CAN");
		Person person4 = new Person("David", "Dan", 45, "USA");
		Person person5 = new Person("Lisa", "Zail", 39, "UK");
		ArrayList<Person> personList = new ArrayList<Person>(
				Arrays.asList(person1, person2, person3, person4, person5));
		personRepository.saveAll(personList);

	}


}
