package domain;

import java.util.ArrayList;
import java.util.List;

public class TransactionReport {
	private List<TransactionResult> transactionResults;

	public List<TransactionResult> getTransactionResults() {
		if(transactionResults == null){
			transactionResults = new ArrayList<>();
		}
		return transactionResults;
	}

	public void setTransactionResults(List<TransactionResult> transactionResults) {
		this.transactionResults = transactionResults;
	}
	
	
	
}
