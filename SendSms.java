package com.twilio;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
//import static spark.Spark.post;


//https://www.twilio.com/docs/quickstart/java/sms#overview
//http://www.journaldev.com/8118/gradle-eclipse-plugin-tutorial


public class SendSms {
	public static final String Account_sid = System.getenv("AC82813d309984d60c6e299f503627443b	");
	public static final String Auth_token = System.getenv("b66ed61f6eca8e5131392ded9f6bc9b4");
	
	public static void main(String [] args)
	{
		Twilio.init(Account_sid, Auth_token);
		Message message = Message.creator(new PhoneNumber(System.getenv("+12408984566")), 
						new PhoneNumber("+15712143827"),
						"This is where I am").create();
		
	}

}
