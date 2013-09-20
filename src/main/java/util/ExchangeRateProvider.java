package util;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Currency;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Gregor Tudan
 */
public class ExchangeRateProvider {

	private Map<Currency, Map<Currency, BigDecimal>> exchangeRates = new HashMap<>();
	private static final Currency DOLLAR = Currency.getInstance("USD");
	private static final Currency EURO = Currency.getInstance("EUR");

	public ExchangeRateProvider() {
		Map<Currency, BigDecimal> dollarRates = Collections.singletonMap(EURO, new BigDecimal("0.739207569"));
		this.exchangeRates.put(DOLLAR, dollarRates);
	}

	public BigDecimal getExchangeRate(Currency source, Currency target) {
		if (!exchangeRates.containsKey(source) || exchangeRates.get(source).containsKey(target)) {
			throw new RuntimeException("Unknown exchange rate");
		}
		return exchangeRates.get(source).get(target);
	}
}
