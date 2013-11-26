package domain;

import java.io.Serializable;

import org.hibernate.HibernateException;

public class DAOPhoneNumber extends AbstractDAO {

	public static DAOPhoneNumber instance = new DAOPhoneNumber();
	private DAOPhoneNumber () { super(); }
	
	public PhoneNumber getById(int id) {
		try {
			this.openSession();
			
			Object phoneO = session.get(PhoneNumber.class, id);
			if (phoneO != null && phoneO instanceof PhoneNumber)
				return (PhoneNumber) phoneO;
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			this.closeSession();
		}
		throw new HibernateException("Impossible to get the phone number. getById(" + id + ").");
	}
	
	public PhoneNumber addPhoneNumber(String phoneKind, String phoneNumber, Contact contact) {
		
		PhoneNumber phone = new PhoneNumber();
		phone.setPhoneKind(phoneKind);
		phone.setPhoneNumber(phoneNumber);
		phone.setContact(contact);
		
		try {
			this.openSession();

			Serializable newId = session.save(phone);
			if (newId instanceof Integer)
				phone.setId((Integer) newId);
			else // all ids are Integer in our database
				throw new HibernateException("Impossible to get the id of the new phone number.");

			return phone;

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			this.closeSession();
		}
		throw new HibernateException("Impossible to create the phone number.");
	}
	
	public boolean updatePhoneNumber(int id, String phoneKind, String phoneNumber, Contact contact) {
		
		return false;
	}
	
	public boolean deletePhoneNumber(int id) {
		
		return false;
	}
}
