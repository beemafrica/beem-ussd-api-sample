package com.dp.api.service;

import javax.management.ServiceNotFoundException;

import com.dp.api.model.MessageDetail;
import com.dp.api.model.MessageDetailResponse;
import com.dp.api.model.ReceivedMessage;
import com.dp.api.model.ResponseMessage;

import com.dp.api.model.AirtimeMessage;
import com.dp.api.model.AirtimeResponseMessage;

/**
 * USSDIntegrationService .
 * 
 * @author admin
 *
 */
public interface USSDIntegrationService {

	/**
	 * saveUSSDMessage .
	 * 
	 * @param request
	 * @return
	 */
	public USSDDetailResponse saveUSSDMessage(USSDMessageDetail request);
}
