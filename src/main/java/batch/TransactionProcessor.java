package batch;

import domain.Transaction;
import domain.TransactionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.batch.api.chunk.ItemProcessor;
import javax.el.ELProcessor;
import javax.inject.Named;
import java.math.BigDecimal;

/**
 * @author Gregor Tudan
 */
@Named("TransactionProcessor")
public class TransactionProcessor implements ItemProcessor {

	private Logger log = LoggerFactory.getLogger(getClass());

	@Override
	public Object processItem(Object o) throws Exception {
		Transaction transaction = (Transaction) o;
		log.debug("Processing transaction {}", transaction.getExpression());

		Object result = new ELProcessor().eval(transaction.getExpression());
		return new TransactionResult(new BigDecimal(result.toString()));
	}
}
