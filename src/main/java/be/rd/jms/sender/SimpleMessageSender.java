package be.rd.jms.sender;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component("messageSender")
public class SimpleMessageSender implements IMessageSender {

	private JmsTemplate jmsTemplate;
	
	@Autowired
	@Required
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void sendMessage(final String message) {
		jmsTemplate.send(new MessageCreator() {
			
			public Message createMessage(Session arg0) throws JMSException {
				return arg0.createTextMessage(message);
			}
		});
	}

}
