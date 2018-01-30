package com.dfsp.resource.component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "chartcfg", schema = "public")
public class ChartConfig {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	@Column(name = "type_chart")
	private String typeChart;
	@Column(name = "title_chart")
	private String titleChart;
	@Column(name = "title_category")
	private String titleCategory;
	@Column(name = "title_value")
	private String titleValue;

	
	public ChartConfig() {
		super();
	}

	public ChartConfig(long id, String typeChart, String titleChart, String titleCategory, String titleValue) {
		super();
		this.id = id;
		this.typeChart = typeChart;
		this.titleChart = titleChart;
		this.titleCategory = titleCategory;
		this.titleValue = titleValue;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTypeChart() {
		return typeChart;
	}

	public void setTypeChart(String typeChart) {
		this.typeChart = typeChart;
	}

	public String getTitleChart() {
		return titleChart;
	}

	public void setTitleChart(String titleChart) {
		this.titleChart = titleChart;
	}

	public String getTitleCategory() {
		return titleCategory;
	}

	public void setTitleCategory(String titleCategory) {
		this.titleCategory = titleCategory;
	}

	public String getTitleValue() {
		return titleValue;
	}

	public void setTitleValue(String titleValue) {
		this.titleValue = titleValue;
	}

}
