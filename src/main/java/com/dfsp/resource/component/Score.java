package com.dfsp.resource.component;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Score {

	private String category;
	private BigDecimal value1;
	private BigDecimal value2;
	private BigDecimal value3;
	private BigDecimal value4;
	private BigDecimal value5;
	private BigDecimal value6;

	public Score() {
		super();
	}

	public Score(String category, BigDecimal value1, BigDecimal value2, BigDecimal value3, BigDecimal value4,
			BigDecimal value5, BigDecimal value6) {
		super();
		this.category = category;
		this.value1 = value1;
		this.value2 = value2;
		this.value3 = value3;
		this.value4 = value4;
		this.value5 = value5;
		this.value6 = value6;

	}

	public Score(String category, BigDecimal value1, BigDecimal value2, BigDecimal value3, BigDecimal value4,
			BigDecimal value5) {
		super();
		this.category = category;
		this.value1 = value1;
		this.value2 = value2;
		this.value3 = value3;
		this.value4 = value4;
		this.value5 = value5;

	}

	public Score(String category, BigDecimal value1, BigDecimal value2, BigDecimal value3, BigDecimal value4) {
		super();
		this.category = category;
		this.value1 = value1;
		this.value2 = value2;
		this.value3 = value3;
		this.value3 = value4;
	}

	public Score(String category, BigDecimal value1, BigDecimal value2, BigDecimal value3) {
		super();
		this.category = category;
		this.value1 = value1;
		this.value2 = value2;
		this.value2 = value3;

	}

	public Score(String category, BigDecimal value1, BigDecimal value2) {
		super();
		this.category = category;
		this.value1 = value1;
		this.value2 = value2;

	}

	public Score(String category, BigDecimal value1) {
		super();
		this.category = category;
		this.value1 = value1;

	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public BigDecimal getValue1() {
		return value1;
	}

	public void setValue1(BigDecimal value1) {
		this.value1 = value1;
	}

	public BigDecimal getValue2() {
		return value2;
	}

	public void setValue2(BigDecimal value2) {
		this.value2 = value2;
	}

	public BigDecimal getValue3() {
		return value3;
	}

	public void setValue3(BigDecimal value3) {
		this.value3 = value3;
	}

	public BigDecimal getValue4() {
		return value4;
	}

	public void setValue4(BigDecimal value4) {
		this.value4 = value4;
	}

	public BigDecimal getValue5() {
		return value5;
	}

	public void setValue5(BigDecimal value5) {
		this.value5 = value5;
	}

	public BigDecimal getValue6() {
		return value6;
	}

	public void setValue6(BigDecimal value6) {
		this.value6 = value6;
	}

}
