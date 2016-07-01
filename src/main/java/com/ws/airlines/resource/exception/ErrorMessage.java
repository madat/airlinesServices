package com.ws.airlines.resource.exception;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement

/**
 * jaxb converts a pojo to xml. But it should get a clue to convert a reource to xml.
 * For that we use @XMlRootElement annotation.
 * @author user
 *
 */
public class ErrorMessage {

	private String errorMessage;
	private int errorCode;
	private String errorDocumentation;

	/**
	 * this no arg constructor is necessary to serialize and deserialize this object
	 */
	public ErrorMessage(){

	}

	public ErrorMessage(String errorMessage,int errorCode,String errorDocumentation){
           this.errorMessage=errorMessage;
           this.errorCode=errorCode;
           this.errorDocumentation=errorDocumentation;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorDocumentation() {
		return errorDocumentation;
	}
	public void setErrorDocumentation(String errorDocumentation) {
		this.errorDocumentation = errorDocumentation;
	}
}
