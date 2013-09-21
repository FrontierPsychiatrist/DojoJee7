package batch;

import cdi.ProcessingCompleteEvent;
import domain.TransactionReport;
import domain.TransactionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.batch.api.chunk.ItemWriter;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("TransactionQueueWriter")
public class TransactionQueueWriter implements ItemWriter{
	private Logger log = LoggerFactory.getLogger(getClass());

	@Inject
	private TransactionReport transactionReport;
	
	@Inject
	private Event<ProcessingCompleteEvent> event;
	
	@Override
	public void open(Serializable checkpoint) throws Exception {
	}

	@Override
	public void close() throws Exception {
	}

	@Override
	public void writeItems(List<Object> items) throws Exception {
		for(Object transactionResult : items){
			this.transactionReport.getTransactionResults().add((TransactionResult) transactionResult);
		}
        ProcessingCompleteEvent ev = new ProcessingCompleteEvent(transactionReport);
        event.fire(ev);
	}

	@Override
	public Serializable checkpointInfo() throws Exception {
		return null;
	}


	
}
