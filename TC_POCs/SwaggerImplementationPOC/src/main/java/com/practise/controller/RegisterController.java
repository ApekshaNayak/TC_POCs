package com.practise.controller;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practise.models.CustomerRegister;

@RestController
public class RegisterController {
	
	private ObjectMapper mapper = new ObjectMapper();
	
	@RequestMapping(value = "/customerRegister", method = RequestMethod.POST)
	public ResponseEntity<String> customerRegister(@RequestBody CustomerRegister customerRegister) throws IOException{
		return new ResponseEntity<>(mapper.writeValueAsString(customerRegister), HttpStatus.OK);
	}
}
