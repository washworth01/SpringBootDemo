package com.ashworth.william.springboot.database.sakila.demoSpringBootDatabaseApp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashworth.william.springboot.database.sakila.demoSpringBootDatabaseApp.exception.ResourceNotFoundException;
import com.ashworth.william.springboot.database.sakila.demoSpringBootDatabaseApp.model.DemoSpringBootDataModel;

import com.ashworth.william.springboot.database.sakila.demoSpringBootDatabaseApp.repository.DemoSpringBootRepository;

@RestController
@RequestMapping("/api")
public class DemoSpringBootDataAppController
{
	@Autowired
	DemoSpringBootRepository demoRepository;
	
	//Method to create a person
	@PostMapping("/DemoSpringDataModel")
	public DemoSpringBootDataModel createPerson(@Valid @RequestBody DemoSpringBootDataModel dSDM)
	{
		return demoRepository.save(dSDM);
	}
	//Method to get a person
	@GetMapping("person/(id)")
	public DemoSpringBootDataModel getPersonID(@PathVariable(value = "id")Long personID)
	{
		return demoRepository.findById(personID).orElseThrow(()-> new ResourceNotFoundException("DemoSpringBootDataModel", "id", personID));
	}
	
	//Method to get all people
	@GetMapping("/person")
	public List<DemoSpringBootDataModel> getAllPeople()
	{
		return demoRepository.findAll();
	}
	
	//Method to update a person
	@PutMapping("/person/{id}")
	public DemoSpringBootDataModel upadatePerson(@PathVariable(value = "id")Long personID, @Valid @RequestBody DemoSpringBootDataModel personDetails)
	{
		DemoSpringBootDataModel dSDM = demoRepository.findById(personID).orElseThrow(()-> new ResourceNotFoundException("Person", "id", personID));
		
		dSDM.setName(personDetails.getName());
		dSDM.setAddress(personDetails.getAddress());
		dSDM.setAge(personDetails.getAge());
		
		DemoSpringBootDataModel updateData = demoRepository.save(dSDM);
		return updateData;
	}
	
	//Method to remove a person
	@DeleteMapping("/person/(id)")
	public ResponseEntity<?> deletePerson(@PathVariable(value = "id")Long personID)
	{
		DemoSpringBootDataModel dSDM = demoRepository.findById(personID).orElseThrow(()-> new ResourceNotFoundException("Person", "id", personID));
		
		demoRepository.delete(dSDM);
		return ResponseEntity.ok().build();
	}
}
