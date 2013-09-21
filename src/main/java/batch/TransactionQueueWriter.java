package batch;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.batch.api.chunk.ItemWriter;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jms.JMSContext;
import javax.jms.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cdi.ProcessingCompleteEvent;
import domain.TransactionReport;
import domain.TransactionResult;

@Named("TransactionQueueWriter")
public class TransactionQueueWriter implements ItemWriter{
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Inject
	private JMSContext context;
	
	@Resource(lookup = "java:global/jms/taskQueue")
	private Queue queue;

	private TransactionReport transactionReport;
	
	@Inject
	private Event<ProcessingCompleteEvent> event;
	
	@Override
	public void open(Serializable checkpoint) throws Exception {
		transactionReport = new TransactionReport();
	}

	@Override
	public void close() throws Exception {
		event.fire(new ProcessingCompleteEvent(transactionReport));
	}

	@Override
	public void writeItems(List<Object> items) throws Exception {
		for (Object result : items) {
			transactionReport.getTransactionResults().add((TransactionResult) result);
		}
	}

	@Override
	public Serializable checkpointInfo() throws Exception {
		return null;
	}


	
}
