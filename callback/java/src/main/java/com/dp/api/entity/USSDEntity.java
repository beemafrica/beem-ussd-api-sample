package com.dp.api.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.dp.api.constants.SystemConstants;
/**
 * USSDEntity .
 * 
 * @author admin
 *
 */
@Entity
@Table(name = "USSDCALLBACK")
public class USSDEntity {


	/**
     * id .
     */
    @Id
    @SequenceGenerator(name = "pkgen", allocationSize = 1, initialValue = 1,sequenceName = SystemConstants.SMS_SEQUENCE)
    @GeneratedValue(generator = "pkgen", strategy = GenerationType.SEQUENCE)
    private Integer id;

    /**
     * msisdn .
     */
    @Column(name = "msisdn")
    private String msisdn;

    /**
     * Operator .
     */
    @Column(name = "Operator")
    private String Operator;

    /**
     * session_id .
     */
    @Column(name = "session_id")
    private String session_id;


    /**
     * command .
     */
    @Column(name = "command")
    private String command;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getMsisdn() {
		return msisdn;
	}


	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}


	public String getOperator() {
		return Operator;
	}


	public void setOperator(String Operator) {
		this.Operator = Operator;
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

    
}
