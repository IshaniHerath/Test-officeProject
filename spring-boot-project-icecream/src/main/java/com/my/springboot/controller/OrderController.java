package com.my.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.my.springboot.dao.IcecreamDao;
import com.my.springboot.model.Icecream;

@Controller
@RequestMapping(value = "orders") // Rest API rest end point
public class OrderController {
	
	@Autowired // To connect the dao and controller
	public IcecreamDao icecreamDao; // inject the customer dao class to the controller
	// when someone call to rest API it automatically comes get data from dao

	@RequestMapping(value = "/orders", produces="application/json", method = RequestMethod.GET) // push mapping
	public ResponseEntity<List<Icecream>> icecreamInformation() {
		List<Icecream> icecreams = icecreamDao.getData(); // get the data from dao
		if (icecreams.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
		return new ResponseEntity<List<Icecream>>(icecreams, HttpStatus.OK) ; // If Get mapping annotation returns something, it will be a jason object
	}
		
	@GetMapping("/view") // push mapping
	public String icecreamInformationView() {
		return "orders"	;
	}
}

