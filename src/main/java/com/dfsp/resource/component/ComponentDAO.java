package com.dfsp.resource.component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ComponentDAO {

//	static final String PATH = "http://localhost:8080/RestService/webapi/";
	static final String PATH = "http://89.67.4.242:11780/restservice/webapi/";
	static final String COMPONENT_HIBERNATE_CFG = "component-hibernate-cfg.xml";
	static final String chartConfigHibernateCfg = "chartConfig-hibernate-cfg.xml";

	@SuppressWarnings({ "unchecked", "deprecation" })
	public static List<Selector> getSelectors() {

		List<Selector> selector = new ArrayList<>();

		SessionFactory sessionFactory = new Configuration().configure(COMPONENT_HIBERNATE_CFG)
				.addAnnotatedClass(Selector.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		try {
			selector = session.createCriteria(Selector.class).list();
			session.getTransaction().commit();

		} catch (Exception e) {

		} finally {
			session.close();
			sessionFactory.close();
		}

		return selector;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public static List<Selector> getSelectorsDefault() {

		List<Selector> selector = new ArrayList<>();

		selector.add(new Selector(1, "snapshot example 1", PATH + "snapshot/charts/random"));
		selector.add(new Selector(2, "snapshot example 2", PATH + "snapshot/table/random"));
		return selector;
	}

	public static List<Object> getChartsRandom() {

		final String CHART = "chart"; // name in
		List<Object> results = new ArrayList<>();
		Map<String, Chart> charts = new HashMap<>();
		List<ChartConfig> cfg = new ArrayList<>();
		List<Score> scores = new ArrayList<>();

		Random rn = new Random();
		int min = 100;
		int max = 500;

		scores.add(new Score("styczen", new BigDecimal(rn.nextInt(max - min + 1) + min),
				new BigDecimal(rn.nextInt(max - min + 1) + min), new BigDecimal(rn.nextInt(max - min + 1) + min),
				new BigDecimal(rn.nextInt(max - min + 1) + min), new BigDecimal(rn.nextInt(max - min + 1) + min),
				new BigDecimal(rn.nextInt(max - min + 1) + min)));

		scores.add(new Score("luty", new BigDecimal(rn.nextInt(max - min + 1) + min),
				new BigDecimal(rn.nextInt(max - min + 1) + min), new BigDecimal(rn.nextInt(max - min + 1) + min),
				new BigDecimal(rn.nextInt(max - min + 1) + min), new BigDecimal(rn.nextInt(max - min + 1) + min),
				new BigDecimal(rn.nextInt(max - min + 1) + min)));

		scores.add(new Score("marzec", new BigDecimal(rn.nextInt(max - min + 1) + min),
				new BigDecimal(rn.nextInt(max - min + 1) + min), new BigDecimal(rn.nextInt(max - min + 1) + min),
				new BigDecimal(rn.nextInt(max - min + 1) + min), new BigDecimal(rn.nextInt(max - min + 1) + min),
				new BigDecimal(rn.nextInt(max - min + 1) + min)));

		scores.add(new Score("kwiecien", new BigDecimal(rn.nextInt(max - min + 1) + min),
				new BigDecimal(rn.nextInt(max - min + 1) + min), new BigDecimal(rn.nextInt(max - min + 1) + min),
				new BigDecimal(rn.nextInt(max - min + 1) + min), new BigDecimal(rn.nextInt(max - min + 1) + min),
				new BigDecimal(rn.nextInt(max - min + 1) + min)));

		scores.add(new Score("maj", new BigDecimal(rn.nextInt(max - min + 1) + min),
				new BigDecimal(rn.nextInt(max - min + 1) + min), new BigDecimal(rn.nextInt(max - min + 1) + min),
				new BigDecimal(rn.nextInt(max - min + 1) + min), new BigDecimal(rn.nextInt(max - min + 1) + min),
				new BigDecimal(rn.nextInt(max - min + 1) + min)));

		scores.add(new Score("czerwiec", new BigDecimal(rn.nextInt(max - min + 1) + min),
				new BigDecimal(rn.nextInt(max - min + 1) + min), new BigDecimal(rn.nextInt(max - min + 1) + min),
				new BigDecimal(rn.nextInt(max - min + 1) + min), new BigDecimal(rn.nextInt(max - min + 1) + min),
				new BigDecimal(rn.nextInt(max - min + 1) + min)));

		cfg.add(new ChartConfig(1, "PieChart", "example data 1", "Months", "Amount1"));
		cfg.add(new ChartConfig(2, "BarChart", "example data 2", "Months", "Amount2"));
		cfg.add(new ChartConfig(3, "LineChart", "example data 3", "Months", "Amount3"));
		cfg.add(new ChartConfig(4, "ColumnChart", "example data 4", "Months", "Amount4"));
		cfg.add(new ChartConfig(5, "ScatterChart", "example data 5", "Months", "Amount5"));
		cfg.add(new ChartConfig(6, "Table", "example data 6", "Months", "Amount6"));

		charts.put(CHART, new Chart(cfg, scores));
		results.add(charts);

		return results;
	}

	public static List<Object> getTableRandom() {

		final String CHART = "chart";
		List<Object> results = new ArrayList<>();
		Map<String, Chart> charts = new HashMap<>();
		List<ChartConfig> cfg = new ArrayList<>();
		List<Score> scores = new ArrayList<>();

		Random rn = new Random();
		int min = 100;
		int max = 500;

		scores.add(new Score("styczen", new BigDecimal(rn.nextInt(max - min + 1) + min),
				new BigDecimal(rn.nextInt(max - min + 1) + min), new BigDecimal(rn.nextInt(max - min + 1) + min),
				new BigDecimal(rn.nextInt(max - min + 1) + min), new BigDecimal(rn.nextInt(max - min + 1) + min),
				new BigDecimal(rn.nextInt(max - min + 1) + min)));

		scores.add(new Score("luty", new BigDecimal(rn.nextInt(max - min + 1) + min),
				new BigDecimal(rn.nextInt(max - min + 1) + min), new BigDecimal(rn.nextInt(max - min + 1) + min),
				new BigDecimal(rn.nextInt(max - min + 1) + min), new BigDecimal(rn.nextInt(max - min + 1) + min),
				new BigDecimal(rn.nextInt(max - min + 1) + min)));

		scores.add(new Score("marzec", new BigDecimal(rn.nextInt(max - min + 1) + min),
				new BigDecimal(rn.nextInt(max - min + 1) + min), new BigDecimal(rn.nextInt(max - min + 1) + min),
				new BigDecimal(rn.nextInt(max - min + 1) + min), new BigDecimal(rn.nextInt(max - min + 1) + min),
				new BigDecimal(rn.nextInt(max - min + 1) + min)));

		scores.add(new Score("kwiecien", new BigDecimal(rn.nextInt(max - min + 1) + min),
				new BigDecimal(rn.nextInt(max - min + 1) + min), new BigDecimal(rn.nextInt(max - min + 1) + min),
				new BigDecimal(rn.nextInt(max - min + 1) + min), new BigDecimal(rn.nextInt(max - min + 1) + min),
				new BigDecimal(rn.nextInt(max - min + 1) + min)));

		scores.add(new Score("maj", new BigDecimal(rn.nextInt(max - min + 1) + min),
				new BigDecimal(rn.nextInt(max - min + 1) + min), new BigDecimal(rn.nextInt(max - min + 1) + min),
				new BigDecimal(rn.nextInt(max - min + 1) + min), new BigDecimal(rn.nextInt(max - min + 1) + min),
				new BigDecimal(rn.nextInt(max - min + 1) + min)));

		scores.add(new Score("czerwiec", new BigDecimal(rn.nextInt(max - min + 1) + min),
				new BigDecimal(rn.nextInt(max - min + 1) + min), new BigDecimal(rn.nextInt(max - min + 1) + min),
				new BigDecimal(rn.nextInt(max - min + 1) + min), new BigDecimal(rn.nextInt(max - min + 1) + min),
				new BigDecimal(rn.nextInt(max - min + 1) + min)));

		scores.add(new Score("lipiec", new BigDecimal(rn.nextInt(max - min + 1) + min),
				new BigDecimal(rn.nextInt(max - min + 1) + min), new BigDecimal(rn.nextInt(max - min + 1) + min),
				new BigDecimal(rn.nextInt(max - min + 1) + min), new BigDecimal(rn.nextInt(max - min + 1) + min),
				new BigDecimal(rn.nextInt(max - min + 1) + min)));

		scores.add(new Score("sierpien", new BigDecimal(rn.nextInt(max - min + 1) + min),
				new BigDecimal(rn.nextInt(max - min + 1) + min), new BigDecimal(rn.nextInt(max - min + 1) + min),
				new BigDecimal(rn.nextInt(max - min + 1) + min), new BigDecimal(rn.nextInt(max - min + 1) + min),
				new BigDecimal(rn.nextInt(max - min + 1) + min)));

		scores.add(new Score("wrzesien", new BigDecimal(rn.nextInt(max - min + 1) + min),
				new BigDecimal(rn.nextInt(max - min + 1) + min), new BigDecimal(rn.nextInt(max - min + 1) + min),
				new BigDecimal(rn.nextInt(max - min + 1) + min), new BigDecimal(rn.nextInt(max - min + 1) + min),
				new BigDecimal(rn.nextInt(max - min + 1) + min)));

		scores.add(new Score("pazdziernik", new BigDecimal(rn.nextInt(max - min + 1) + min),
				new BigDecimal(rn.nextInt(max - min + 1) + min), new BigDecimal(rn.nextInt(max - min + 1) + min),
				new BigDecimal(rn.nextInt(max - min + 1) + min), new BigDecimal(rn.nextInt(max - min + 1) + min),
				new BigDecimal(rn.nextInt(max - min + 1) + min)));

		scores.add(new Score("listopad", new BigDecimal(rn.nextInt(max - min + 1) + min),
				new BigDecimal(rn.nextInt(max - min + 1) + min), new BigDecimal(rn.nextInt(max - min + 1) + min),
				new BigDecimal(rn.nextInt(max - min + 1) + min), new BigDecimal(rn.nextInt(max - min + 1) + min),
				new BigDecimal(rn.nextInt(max - min + 1) + min)));

		scores.add(new Score("grudzien", new BigDecimal(rn.nextInt(max - min + 1) + min),
				new BigDecimal(rn.nextInt(max - min + 1) + min), new BigDecimal(rn.nextInt(max - min + 1) + min),
				new BigDecimal(rn.nextInt(max - min + 1) + min), new BigDecimal(rn.nextInt(max - min + 1) + min),
				new BigDecimal(rn.nextInt(max - min + 1) + min)));

		cfg.add(new ChartConfig(1, "PieChart", "example data 1", "Months", "Amount1"));
		cfg.add(new ChartConfig(2, "BarChart", "example data 2", "Months", "Amount2"));
		cfg.add(new ChartConfig(3, "AreaChart", "example data 3", "Months", "Amount3"));
		cfg.add(new ChartConfig(4, "ColumnChart", "example data 4", "Months", "Amount4"));
		cfg.add(new ChartConfig(5, "ScatterChart", "example data 5", "Months", "Amount5"));
		cfg.add(new ChartConfig(6, "PieChart", "example data 6", "Months", "Amount6"));

		charts.put(CHART, new Chart(cfg, scores));
		results.add(charts);

		return results;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public static List<ChartConfig> getCharts() {

		List<ChartConfig> chart = new ArrayList<>();

		SessionFactory sessionFactory = new Configuration().configure(chartConfigHibernateCfg)
				.addAnnotatedClass(ChartConfig.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		try {
			chart = session.createCriteria(ChartConfig.class).list();
			session.getTransaction().commit();

		} catch (Exception e) {

		} finally {
			session.close();
			sessionFactory.close();
		}

		return chart;
	}

	/*
	 * public static List<ChartConfig> getCurrenChart(int id) { SessionFactory
	 * sessionFactory = new Configuration() .configure(chartConfigHibernateCfg)
	 * .addAnnotatedClass(ChartConfig.class) .buildSessionFactory();
	 * 
	 * Session session = sessionFactory .getCurrentSession(); Transaction
	 * transaction = null; List<ChartConfig> result = new ArrayList<>();
	 * 
	 * try { transaction = session.beginTransaction();
	 * 
	 * CriteriaBuilder builder = session.getCriteriaBuilder();
	 * CriteriaQuery<ChartConfig> criteriaQuery =
	 * builder.createQuery(ChartConfig.class); Root<ChartConfig> root =
	 * criteriaQuery.from(ChartConfig.class);
	 * criteriaQuery.select(root).where(builder.equal(root.get("id"), id));
	 * Query<ChartConfig> query = session.createQuery(criteriaQuery); result =
	 * query.getResultList();
	 * 
	 * transaction.commit(); } catch (Exception e) {
	 * 
	 * } finally { session.close(); sessionFactory.close(); }
	 * 
	 * return result;
	 * 
	 * }
	 * 
	 */

	public static List<ChartConfig> getChartConfig(int id) {
		SessionFactory sessionFactory = new Configuration().configure(chartConfigHibernateCfg)
				.addAnnotatedClass(ChartConfig.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = null;
		List<ChartConfig> chartCfg = new ArrayList<>();
		// List<User> users = new ArrayList<>();
		// Map<String, Object> result = new HashMap<>();
		try {
			// users = UserDAO.getAllUsers();
			transaction = session.beginTransaction();

			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<ChartConfig> criteriaQuery = builder.createQuery(ChartConfig.class);
			Root<ChartConfig> root = criteriaQuery.from(ChartConfig.class);
			criteriaQuery.select(root).where(builder.equal(root.get("id"), id));
			Query<ChartConfig> query = session.createQuery(criteriaQuery);
			chartCfg = query.getResultList();
			transaction.commit();
			// result.put("config", chartCfg);
			// result.put("users", users);
		} catch (Exception e) {

		} finally {
			session.close();
			sessionFactory.close();
		}

		return chartCfg;

	}

}
