package com.datapopulator.spring.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datapopulator.spring.Dao.Person;

@RestController
public class DataPopulatorController {

	//@Autowired
	//private TestRepository testDAO;
	
	
	@RequestMapping("/")
	public String myTest() {

		Person test = new Person();
		
		//testDAO.save(test);	
		
		return "Hi, This is the test Out Put";
		
	}
	

	@GetMapping("getMapping")
	public String getMapping() {

		return "Hi, This is the Get Mapping";
		
	}
	

}
