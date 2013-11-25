package domain;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DAOAddress {

	public static DAOAddress instance = new DAOAddress();
	
	private Session session;
	private Transaction tx;
	
	public DAOAddress() {
		super();
	}
	
	
	@SuppressWarnings("deprecation")
	private void openSession() throws HibernateException {
		session = new Configuration().configure().buildSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void closeSession() throws HibernateException {
		tx.commit();
		session.disconnect();
		session.close();
	}
	
	public Address getById(Integer id) {
		try {
			this.openSession();
			
			Object addressO = session.get(Address.class, id);
			if (addressO != null && addressO instanceof Address) {
				this.closeSession();
				return (Address) addressO;
			}
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		throw new HibernateException("Impossible to get the Address. getById(" + id + ").");
	}
	
	public Address addAddress(String street, String city, String zip, String country) throws HibernateException {
		
		Address address = new Address();
		address.setStreet(street);
		address.setCity(city);
		address.setZip(zip);
		address.setCountry(country);
		
		try {
			this.openSession();
			
			Serializable newId = session.save(address);
			if (newId instanceof Integer)
				address.setId((Integer) newId);
			else // all ids are Integer in our database
				throw new HibernateException("Impossible to get the id of the new Address.");
			
			this.closeSession();
			return address;
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		throw new HibernateException("Impossible to create the Address.");
	}
	
	public boolean updateAddress(int id, String street, String city, String zip, String country) {

		Address address = this.getById(id);
		address.setId(id);
		address.setStreet(street);
		address.setCity(city);
		address.setZip(zip);
		address.setCountry(country);
		
		try {
			this.openSession();
			session.update(address);
			this.closeSession();
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean deleteAddress(int id) {
		// TODO tester
		Address address = this.getById(id);
		try {
			this.openSession();
			session.delete(address);
			this.closeSession();
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
