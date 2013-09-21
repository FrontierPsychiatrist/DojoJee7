package batch;

import domain.Transaction;
import domain.TransactionResult;

import javax.batch.api.chunk.ItemProcessor;
import javax.inject.Named;
import java.math.BigDecimal;

/**
 * @author Gregor Tudan
 */
@Named("TransactionProcessor")
public class TransactionProcessor implements ItemProcessor {

	@Override
	public Object processItem(Object o) throws Exception {
		Transaction transaction = (Transaction) o;

		transaction.getExpression();
		return new TransactionResult(BigDecimal.ONE);
	}
}
