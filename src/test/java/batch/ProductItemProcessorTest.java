package batch;

import model.Price;
import model.ProductItem;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import util.ExchangeRateProvider;

import javax.batch.runtime.context.JobContext;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Properties;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.number.BigDecimalCloseTo.closeTo;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Gregor Tudan
 */
@RunWith(MockitoJUnitRunner.class)
public class ProductItemProcessorTest {

	public static final Currency EUR = Currency.getInstance("EUR");
	public static final Currency USD = Currency.getInstance("USD");

	@Mock
	private ExchangeRateProvider exchangeRateProvider;

	@Mock
	private JobContext jobContext;

	@InjectMocks
	private ProductItemProcessor processor;

	@Before
	public void setUp() throws Exception {
		when(jobContext.getProperties()).thenReturn(new Properties());
		processor.init();
	}

	@Test
	public void testProcessItem() throws Exception {
		ProductItem item = new ProductItem(2L, "Base");
		item.setPrice(new Price(new BigDecimal(20), USD));
		when(exchangeRateProvider.getExchangeRate(USD, EUR)).thenReturn(new BigDecimal("0.75"));

		processor.processItem(item);

		verify(exchangeRateProvider).getExchangeRate(USD, EUR);
		assertThat(item.getPrice().getCurrency(), is(EUR));
		assertThat(item.getPrice().getAmount(), is(closeTo(new BigDecimal("26.666667"), new BigDecimal("0.1"))));

	}

}
