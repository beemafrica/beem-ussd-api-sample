package com.dp.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dp.api.constants.SystemConstants;
import com.dp.api.model.MessageDetail;
import com.dp.api.model.MessageDetailResponse;
import com.dp.api.model.ReceivedMessage;
import com.dp.api.model.AirtimeMessage;
import com.dp.api.model.ResponseMessage;
import com.dp.api.service.USSDIntegrationService;


/**
 * USSDController .
 * 
 * @author admin
 *
 */
@RestController
@CrossOrigin(exposedHeaders = "Content-Disposition")
public class USSDController {

    Logger logger = LoggerFactory.getLogger(USSDController.class);

    @Autowired
    private USSDIntegrationService ussdIntegrationService;
    
    
	/**
	 * restApiCall.
	 *
	 * @param requestHeader the requestHeader
	 * @param request       the request
	 * @return ResponseEntity< CreateUserResponse >
	 * @throws Exception
	 */
	@RequestMapping(value = SystemConstants.USSD_CALLBACK, method = RequestMethod.POST)
	public ResponseEntity<MessageDetailResponse> USSDCallback(@RequestBody USSDMessageDetail request) throws Exception {

		USSDMessageDetail response = new USSDMessageDetail();
		response.setmsisdn(request.getmsisdn());
		response.setOperator(request.getOperator());
		response.setSession_id(request.getSession_id());
		response.setCommand(request.getCommand());
		
		Payload payload = new Payload();
		if(request.getCommand()=="initiate")
		{
			payload.request_id = "0";
			payload.response = "enter phone number";			
		}
		else if(request.getCommand()=="Continue")
		{
			payload.request_id = "1";
			payload.response = "enter amount";			
		}
		else if(request.getCommand()=="terminate")
		{
			payload.request_id = "2";
			payload.response = "press 1 to end session";			
		}
		
		response.setPayload(payload);
		
		logger.info("Request Receiver from API : {}" ,request.getmsisdn());

		logger.info("Response sent from API : {}" ,response.getId());

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

}
