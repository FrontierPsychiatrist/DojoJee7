package jms.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.MessageDriven;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Gregor Tudan
 */
@LocalBean
@Stateless
public class ReceiverBean {

	@Inject
	private JMSContext context;

	@Resource(lookup = "java:global/jms/myQueue")
	private Queue queue;

	private JMSConsumer consumer;
	private Logger log = LoggerFactory.getLogger(getClass());

	@PostConstruct
	public void initConsumer() {
		consumer = context.createConsumer(queue);
	}

	public String[] getMessages() {
		List<String> messages = new ArrayList<>();
		consumer = context.createConsumer(queue);
		Message message = consumer.receiveNoWait();
		while (message != null) {
			try {
				messages.add(((TextMessage) message).getText());
			} catch (JMSException e) {
				log.error(e.getMessage(),e);
			}
			message = consumer.receiveNoWait();
		}

		return messages.toArray(new String[messages.size()]);
	}
}
