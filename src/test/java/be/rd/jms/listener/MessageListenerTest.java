package be.rd.jms.listener;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import be.rd.jms.sender.IMessageSender;

public class MessageListenerTest {

	@Test
	public void testMessageListener(){
		// initialize listener
		GenericXmlApplicationContext ctxListener = new GenericXmlApplicationContext();
		ctxListener.load("classpath:spring/jms-listener-config.xml");
		ctxListener.refresh();
	
		// get sender and send msg
		GenericXmlApplicationContext ctxSender  = new GenericXmlApplicationContext();
		ctxSender.load("classpath:spring/jms-sender-config.xml");
		ctxSender.refresh();
		// Send message
		IMessageSender messageSender = ctxSender.getBean("messageSender",
				IMessageSender.class);
		messageSender.sendMessage("Ruben testing JMS message");

		// just wait endlessly ... 
		// add some stuff in the queue and see if you messagebean is receiving...
		while (true) {
		}
	}
}
