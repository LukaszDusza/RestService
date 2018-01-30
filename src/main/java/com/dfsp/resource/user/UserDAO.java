package com.dfsp.resource.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.dfsp.access.PasswordAuth;

public class UserDAO {

	static final String USER_HIBERNATE_CFG = "user-hibernate-cfg.xml";

	@SuppressWarnings({ "unchecked", "deprecation" })
	public static List<User> getAllUsers() {

		List<User> users = new ArrayList<>();

		SessionFactory sessionFactory = new Configuration().configure(USER_HIBERNATE_CFG).addAnnotatedClass(User.class)
				.buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();
		// Session session = sessionFactory.openSession();
		session.beginTransaction();

		try {
			users = session.createCriteria(User.class).list();
			session.getTransaction().commit();

		} catch (Exception e) {

		} finally {
			session.close();
			sessionFactory.close();
		}

		return users;

	}

	public static boolean checkUserEmail(String email) {

		SessionFactory sessionFactory = new Configuration().configure(USER_HIBERNATE_CFG).addAnnotatedClass(User.class)
				.buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		boolean result = false;
		try {
			session.beginTransaction();
			Criteria criteria = session.createCriteria(User.class);
			criteria.add(Restrictions.eq("email", email));
			criteria.setProjection(Projections.rowCount());
			long count = (Long) criteria.uniqueResult();
			if (count != 0) {
				result = true;

			} else {
				result = false;
			}

			session.getTransaction().commit();
		} catch (Exception e) {

		} finally {
			session.close();
			sessionFactory.close();
		}
		System.out.println("check email exist in DB. Result: " + result);
		return result;
	}

	
	public static String getPassword(String email) {
		SessionFactory sessionFactory = new Configuration()
				.configure(USER_HIBERNATE_CFG)
				.addAnnotatedClass(User.class)
				.buildSessionFactory();
		
		Session session = sessionFactory
				.getCurrentSession();	
		Transaction transaction = null;	
		List<User> result = new ArrayList<>();	
		 
		try {
			transaction = session.beginTransaction();
			
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
			Root<User> root = criteriaQuery.from(User.class);
			criteriaQuery.select(root).where(builder.equal(root.get("email"), email));
			Query<User> query = session.createQuery(criteriaQuery);			
			result = query.getResultList();	
			
			transaction.commit();
		} catch (Exception e) {			

		} finally {
			session.close();
			sessionFactory.close();
		}

		return result.get(0).getPassword();

	}
}
