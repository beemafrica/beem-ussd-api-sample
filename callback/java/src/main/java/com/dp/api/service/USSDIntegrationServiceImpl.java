package com.dp.api.service;

import java.nio.charset.Charset;

import javax.management.ServiceNotFoundException;
import javax.transaction.Transactional;

import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dp.api.constants.SystemConstants;
import com.dp.api.entity.USSDEntity;
import com.dp.api.model.MessageDetail;
import com.dp.api.model.MessageDetailResponse;
import com.dp.api.model.ReceivedMessage;
import com.dp.api.model.ResponseMessage;
import com.dp.api.repository.USSDRepository;

import com.dp.api.model.AirtimeMessage;
import com.dp.api.model.AirtimeResponseMessage;

/**
 * USSDIntegrationServiceImpl .
 * 
 * @author admin
 *
 */
@Service
@Transactional
public class USSDIntegrationServiceImpl implements USSDIntegrationService {

	Logger logger = LoggerFactory.getLogger(USSDIntegrationServiceImpl.class);

	@Autowired
	private USSDRepository ussdRepo;
	/**
	 * restTemplate
	 */
	@Autowired
	RestTemplate restTemplate;

	/**
	 * Create Headers.
	 *
	 * @param username Username
	 * @param password password
	 * @return HttpHeaders
	 */
	private HttpHeaders createHeaders(String username, String password) {
		HttpHeaders httpHeader = new HttpHeaders();
		String auth = username + ":" + password;
		byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
		String authHeader = "Basic " + new String(encodedAuth);
		logger.info("Authorization header sent to fetch message Data: {}", authHeader);
		httpHeader.add("Authorization", authHeader);
		return httpHeader;
	}

	@Override
	public USSDDetailResponse saveUSSDMessage(USSDMessageDetail request) {
		// TODO Auto-generated method stub
		USSDDetailResponse response = new USSDDetailResponse();
		USSDEntity ussdEntity = new USSDEntity();
		ussdEntity.setMsisdn(request.getMsisdn());
		ussdEntity.setOperator(request.getOperator());
		ussdEntity.setSession_id(request.getSession_id());
		ussdEntity.setCommand(request.getCommand());
		ussdEntity.setPayload(request.getPayload());

		USSDEntity ussdBo = ussdRepo.save(USSDEntity);
		response.setId(ussdResponse.getId());
		response.setMsisdn(ussdResponse.getMsisdn());
		response.setMessage("Record saved in db");

		return response;
	}
}
