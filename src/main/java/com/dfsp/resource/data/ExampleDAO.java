package com.dfsp.resource.data;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ExampleDAO {
	static final String chartConfigHibernateCfg = "chartConfig-hibernate-cfg.xml";

	@SuppressWarnings({ "unchecked", "deprecation" })
	public static List<ExampleValues> getExampleValues() {

		List<ExampleValues> result = new ArrayList<>();

		SessionFactory sessionFactory = new Configuration().configure(chartConfigHibernateCfg)
				.addAnnotatedClass(ExampleValues.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		try {
			result = session.createCriteria(ExampleValues.class).list();
			session.getTransaction().commit();

		} catch (Exception e) {

		} finally {
			session.close();
			sessionFactory.close();
		}

		return result;
	}
}
