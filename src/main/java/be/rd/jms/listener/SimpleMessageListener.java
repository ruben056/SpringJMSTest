package be.rd.jms.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleMessageListener implements MessageListener {

	private static final Logger logger = LoggerFactory.getLogger(SimpleMessageListener.class);

	public void onMessage(Message arg0) {
		TextMessage msg = (TextMessage)arg0;
		try {
			logger.info("Message received : " + msg.getText());
		} catch (JMSException e) {
			logger.error("Error durin processing jms message", e.getCause());
			e.printStackTrace();
		}
	}
}
