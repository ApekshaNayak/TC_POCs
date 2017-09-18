package practise.project.service;

import org.springframework.stereotype.Service;

import practise.project.exception.CreateDeviceException;
import practise.project.exception.DeviceEventListenerException;

@Service
public class ExceptionHandlingImpl {

	public Integer processRequest(Integer alphaNumericId) throws CreateDeviceException{
		try{
		if(String.valueOf(alphaNumericId).contains("A"))
			throw new CreateDeviceException();	
		
		}catch(DeviceEventListenerException e){
			System.out.println("Error Message: "+e.getMessage());
			throw new DeviceEventListenerException(e.getMessage());
		}
		return alphaNumericId;		
	}
}
