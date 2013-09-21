package batch;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.batch.api.chunk.ItemReader;
import javax.batch.runtime.context.JobContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.Transaction;

@Named("TransactionQueueReader")
public class TransactionQueueReader implements ItemReader {
	private Logger log = LoggerFactory.getLogger(getClass());

	@Inject
	private JobContext jobContext;

	@Inject
	private JMSContext context;

	@Resource(lookup = "java:global/jms/taskQueue")
	private Queue queue;

	private JMSConsumer consumer;

	@Override
	public void open(Serializable serializable) throws Exception {
		log.info("Execution id: {}", jobContext.getExecutionId());
		consumer = context.createConsumer(queue);
	}
	
	@Override
	public void close() throws Exception {
		consumer.close();
	}

	@Override
	public Transaction readItem() throws Exception {
		return consumer.receiveBody(Transaction.class);
	}

	@Override
	public Serializable checkpointInfo() throws Exception {
		return null;
	}
}
