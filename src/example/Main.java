package example;

import java.io.Serializable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import domain.Contact;

public class Main {

	public static void main(String[] args) {
		Session session = null;
		try {
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = new Configuration().configure()
					.buildSessionFactory();
			session = sessionFactory.openSession();
			// begin a transaction
			org.hibernate.Transaction tx = session.beginTransaction();
			// create a contact and save it into the DB
			Contact member = new Contact();
			member.setId(2);
			member.setFirstName("Mich");
			// save the contact into the DB
			Serializable id = session.save(member); // or session.persist(contact);
			// session.update(member);
			// session.delete(member);
			// if you modify one of its properties, no need to save it again
			member.setLastName("Knor");
			// mandatory to flush the data into the DB
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
