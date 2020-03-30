package com.testgaap.partnerportalnew.app.email;

public interface MailService {
	
	
	public void send(String toAddress, String fromAddress, String subject, String content) throws Exception;

}
