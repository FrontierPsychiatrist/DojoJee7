package domain;

import java.io.Serializable;

public class Transaction implements Serializable {
	private String name;
	private int wert1;
	private int wert2;
	private String expression;

	public Transaction(String expression) {
		this.expression = expression;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the wert1
	 */
	public int getWert1() {
		return wert1;
	}
	/**
	 * @param wert1 the wert1 to set
	 */
	public void setWert1(int wert1) {
		this.wert1 = wert1;
	}
	/**
	 * @return the wert2
	 */
	public int getWert2() {
		return wert2;
	}
	/**
	 * @param wert2 the wert2 to set
	 */
	public void setWert2(int wert2) {
		this.wert2 = wert2;
	}
	/**
	 * @return the expression
	 */
	public String getExpression() {
		return expression;
	}
	/**
	 * @param expression the expression to set
	 */
	public void setExpression(String expression) {
		this.expression = expression;
	}
	
	public String toString(){
		
		return "Name: " + name + " Wert1: " + wert1 + " Wert2: " + wert2 + " Expression: " + expression; 
	}
}
