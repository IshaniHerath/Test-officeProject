package com.my.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.my.springboot.dao.IcecreamDao;
import com.my.springboot.model.Icecream;

@Controller
@RequestMapping(value = "/") // Rest API rest end point
public class IcecreamController {
	
	@Autowired // To connect the dao and controller
	public IcecreamDao icecreamDao; // inject the customer dao class to the controller
	
	@GetMapping("/")
	public String icecream() {
		return "/icecream"; // go to icecream.html page
	}

	@RequestMapping(value = "/", produces="application/json", method = RequestMethod.POST) // push mapping
	public ResponseEntity<?> createUser(@RequestBody Icecream icecream, UriComponentsBuilder ucBuilder) { 
		//UriComponentsBuilder: To create a new object when httpRequest
		
		icecreamDao.saveIcecream(icecream);//Call saveIcecream method in Dao class
		
	    HttpHeaders headers = new HttpHeaders();
	    headers.setLocation(ucBuilder.path("/{id}").buildAndExpand(icecream.getid()).toUri());
	    return new ResponseEntity<List>(headers, HttpStatus.CREATED);
	}
}
//@RestController(value = "/icecream") // Rest API rest end point
//public class IcecreamController {
//	@Autowired // To connect the dao and controller
//	public IcecreamDao icecreamDao; // inject the customer dao class to the controller
//	// when someone call to rest API it automatically comes get data from dao

//	@GetMapping // push mapping
//	public List<Icecream> icecreamInformation() {
//		List<Icecream> icecreams = icecreamDao.getData(); // get the data from dao
//		return icecreams; // If Get mapping annotation returns something, it will be a jason object
//	}