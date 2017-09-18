package practise.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import practise.project.exception.CreateDeviceException;
import practise.project.service.ExceptionHandlingImpl;

@RestController
public class RestApiController {
	
	@Autowired
	private ExceptionHandlingImpl exceptionHandlingImpl;

	@RequestMapping(value = "/ExceptionHandling/{numericId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> searchForDCMProfileByVin(
			@PathVariable Integer numericId){
		ResponseEntity<String> responseEntity = null;
		try {
			responseEntity = new ResponseEntity<>(exceptionHandlingImpl.processRequest(numericId).toString(), HttpStatus.OK);
		} catch (CreateDeviceException e) {
			System.out.println("Localised message: "+e.getLocalizedMessage());
			System.out.println("Message: "+e.getMessage());
			responseEntity = new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
}
