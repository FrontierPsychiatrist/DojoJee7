package domain;

import java.math.BigDecimal;

/**
 * @author Gregor Tudan
 */
public class TransactionResult {

	private BigDecimal result = BigDecimal.ZERO;

	public TransactionResult(BigDecimal result) {
		this.result = result;
	}

	public BigDecimal getResult() {
		return result;
	}

	public void setResult(BigDecimal result) {
		this.result = result;
	}
}
