package jms.producer;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSDestinationDefinition;
import javax.jms.Queue;

import domain.Transaction;

/**
 * @author Gregor Tudan + Thomas Krämer
 */
@LocalBean
@Stateless
@JMSDestinationDefinition(name="java:global/jms/taskqueue",interfaceName = "javax.jms.Queue")
public class SenderBean {

	@Inject
	private JMSContext context;

	@Resource(lookup = "java:global/jms/taskqueue")
	private Queue queue;

	public void sendMessageJavaEE7(Transaction transaction) {
		context.createProducer().send(queue, transaction);
	}
}
