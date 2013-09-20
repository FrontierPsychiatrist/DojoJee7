package batch;

import model.Price;
import model.ProductItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.ExchangeRateProvider;

import javax.annotation.PostConstruct;
import javax.batch.api.chunk.ItemProcessor;
import javax.batch.runtime.context.JobContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;

/**
 * @author Gregor Tudan
 */
@Named("ProductItemProcessor")
public class ProductItemProcessor implements ItemProcessor{

	@Inject
	private JobContext jobCtx;
	private Currency targetCurrency;

	private Logger log = LoggerFactory.getLogger(getClass());

	@Inject
	private ExchangeRateProvider exchangeRateProvider;

    @PostConstruct
	public void init() {
		String currencyProp = jobCtx.getProperties().getProperty("targetCurrency", "EUR");
		targetCurrency = Currency.getInstance(currencyProp);
		log.debug("Initialized new exchange");
	}

	@Override
	public Object processItem(Object o) throws Exception {
		ProductItem item = (ProductItem) o;
		log.debug("Processing item {}", item.getName());
		Price newPrice = convertCurrency(item.getPrice(), targetCurrency);
		item.setPrice(newPrice);
		return item;
	}

	private Price convertCurrency(Price price, Currency targetCurrency) {
		Currency sourceCurrency = price.getCurrency();

		BigDecimal exchangeRate = exchangeRateProvider.getExchangeRate(sourceCurrency, targetCurrency);
		return new Price(price.getAmount().divide(exchangeRate, 6, RoundingMode.HALF_UP), targetCurrency);
	}


}
