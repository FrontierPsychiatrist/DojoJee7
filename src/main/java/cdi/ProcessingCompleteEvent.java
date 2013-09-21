package cdi;

import domain.TransactionReport;

/**
 * @author Gregor Tudan
 */
public class ProcessingCompleteEvent {
	private TransactionReport result;

	public ProcessingCompleteEvent(TransactionReport result) {
		this.result = result;
	}

	public TransactionReport getResult() {
		return result;
	}
}
