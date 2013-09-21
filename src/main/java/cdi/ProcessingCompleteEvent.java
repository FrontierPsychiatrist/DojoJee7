package cdi;

import domain.TransactionResult;

/**
 * @author Gregor Tudan
 */
public class ProcessingCompleteEvent {
	private TransactionResult result;

	public ProcessingCompleteEvent(TransactionResult result) {
		this.result = result;
	}

	public TransactionResult getResult() {
		return result;
	}
}
