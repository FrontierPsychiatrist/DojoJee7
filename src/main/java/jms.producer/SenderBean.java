package jms.producer;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSDestinationDefinition;
import javax.jms.Queue;

/**
 * @author Gregor Tudan
 */
@LocalBean
@Stateless
@JMSDestinationDefinition(name="java:global/jms/myQueue",interfaceName = "javax.jms.Queue")
public class SenderBean {

	@Inject
	private JMSContext context;

	@Resource(lookup = "java:global/jms/myQueue")
	private Queue queue;

	public void sendMessageJavaEE7(String message) {
		context.createProducer().send(queue, message);
	}
}
