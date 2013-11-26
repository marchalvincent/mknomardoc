package domain;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

public abstract class AbstractDAO {
	
	protected Session session;
	private Transaction transaction;
	
	protected void openSession() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
	}
	
	protected void closeSession() throws HibernateException {
		if (transaction != null) // TODO voir si d'autres vérification??
			transaction.commit();
		if (session != null && session.isConnected())
			session.disconnect();
		if (session != null && session.isOpen())
			session.close();
	}
}
