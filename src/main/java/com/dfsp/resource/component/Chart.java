package com.dfsp.resource.component;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Chart {

	private List<ChartConfig> configurations;
	private List<Score> scores;

	public List<ChartConfig> getConfigurations() {
		return configurations;
	}

	public void setConfigurations(List<ChartConfig> configurations) {
		this.configurations = configurations;
	}

	public List<Score> getScores() {
		return scores;
	}

	public void setScores(List<Score> scores) {
		this.scores = scores;
	}

	public Chart(List<ChartConfig> configurations, List<Score> scores) {
		super();
		this.configurations = configurations;
		this.scores = scores;
	}

	public Chart() {
		super();
	}

}
