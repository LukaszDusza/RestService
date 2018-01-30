package com.dfsp.resource.data;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "example_data")
public class ExampleValues {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	@Column(name = "category")
	private String category;
	@Column(name = "values")
	private BigDecimal values;
	
	
	public ExampleValues() {
		super();
	}

	public ExampleValues(long id, String category, BigDecimal values) {
		super();
		this.id = id;
		this.category = category;
		this.values = values;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public BigDecimal getValues() {
		return values;
	}
	public void setValues(BigDecimal values) {
		this.values = values;
	}
	
	
	
	
	
}
