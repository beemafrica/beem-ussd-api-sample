package com.dp.api.model;

/**
 * 
 * @author admin
 *
 */
public class USSDDetailResponse {

	private Integer id;
	private String msisdn;
	private String Operator;
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

}
