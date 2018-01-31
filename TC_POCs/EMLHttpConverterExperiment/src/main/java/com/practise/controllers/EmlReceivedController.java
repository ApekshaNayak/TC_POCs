package com.practise.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practise.service.IProvisioningResponse;
import com.tc.tsp.dcm.models.v1.EML;

@RestController
public class EmlReceivedController {
	
	@RequestMapping(value = "/provisioning", method = RequestMethod.POST)
    public ResponseEntity<IProvisioningResponse> receiveProvisioningAck(@RequestBody EML payload) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
