package batch;

import model.Price;
import model.ProductItem;
import util.ExchangeRateProvider;

import javax.batch.api.chunk.ItemProcessor;
import javax.batch.runtime.context.JobContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;
import java.math.MathContext;
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

	@Inject
	private ExchangeRateProvider exchangeRateProvider;

	public void init() {
		String currencyProp = jobCtx.getProperties().getProperty("targetCurrency", "EUR");
		targetCurrency = Currency.getInstance(currencyProp);
	}

	@Override
	public Object processItem(Object o) throws Exception {
		ProductItem item = (ProductItem) o;
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
