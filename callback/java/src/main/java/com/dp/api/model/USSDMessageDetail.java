package com.dp.api.model;

/**
 * ReceivedUSSDMessage .
 * 
 * @author admin
 *
 */
//@Getter
//@Setter
public class USSDMessageDetail {

    /**
     * msisdn .
     * 
     */
    private String msisdn;
    
    /**
     * Operator .
     * 
     */
    private String Operator;
    
    /**
     * session_id .
     * 
     */
    private String session_id;
    
    /**
     * command .
     * 
     */
    private String command;
	
	/**
     * payload .
     * 
     */
    private Payload payload;

	public String getmsisdn() {
		return msisdn;
	}

	public void setmsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getOperator() {
		return Operator;
	}

	public void setOperator(String operator) {
		this.recipient_id = Operator;
	}

	public String getSession_id() {
		return session_id;
	}

	public void setSession_id(String session_id) {
		this.session_id = session_id;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}
	
	public String getPayload() {
		return payload;
	}

	public void setPayload(Payload payload) {
		this.payload = payload;
	}
	
}

public class Payload
{
	/**
     * request_id .
     * 
     */
    public String request_id;
	
	/**
     * request .
     * 
     */
    public String request;
}
