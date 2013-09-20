package model;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * @author Gregor Tudan
 */
public class ProductItem {
	private Long productNumber;
	private String name;
	private String description;
	private Price price;


	public ProductItem(Long productNumber, String name) {
		this.productNumber = productNumber;
		this.name = name;
	}

	public Long getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(Long productNumber) {
		this.productNumber = productNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}
}
