package fr.upmc.ta.mdoc.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import domain.Contact;

public class Main {

	public static void main(String[] args) {
		Session session = null;
		try{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
			//begin a transaction
			org.hibernate.Transaction tx = session.beginTransaction();
			//create a contact and save it into the DB
			Contact member = new Contact();
			member.setId(1);
			member.setFirstName("Robbie");
			//save the contact into the DB
			session.save(member); // or session.persist(contact);
			//if you modify one of its properties, no need to save it again
			member.setLastName("Robin");
			//mandatory to flush the data into the DB
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
