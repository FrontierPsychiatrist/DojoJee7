package batch;

import domain.Transaction;
import domain.TransactionResult;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Gregor Tudan
 */
public class TransactionProcessorTest {

	TransactionProcessor processor;

	@Before
	public void setUp() throws Exception {
		processor = new TransactionProcessor();

	}

	@Test
	public void testProcessItem() throws Exception {
		Transaction transaction = new Transaction("5 + 1");
		TransactionResult result = (TransactionResult) processor.processItem(transaction);
		assertThat(result.getResult(), is(new BigDecimal(6)));

	}
}
