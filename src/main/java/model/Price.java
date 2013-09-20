package model;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * @author Gregor Tudan
 */
public class Price {
	BigDecimal amount = BigDecimal.ZERO;
	Currency currency = Currency.getInstance("EUR");

	public Price(BigDecimal amount, Currency currency) {
		this.amount = amount;
		this.currency = currency;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
}
