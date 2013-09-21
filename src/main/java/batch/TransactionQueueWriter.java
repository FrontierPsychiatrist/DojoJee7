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

@Named("TransactionQueueWriter")
public class TransactionQueueWriter implements ItemWriter{

	@Inject
	private JMSContext context;
	
	@Resource(lookup = "java:global/jms/taskQueue")
	private Queue queue;
	
	@Inject
	private Event<ProcessingCompleteEvent> event;
	
	@Override
	public void open(Serializable checkpoint) throws Exception {
		event.
	}

	@Override
	public void close() throws Exception {
	
		
	}

	@Override
	public void writeItems(List<Object> items) throws Exception {
		
	}

	@Override
	public Serializable checkpointInfo() throws Exception {
		return null;
	}


	
}
