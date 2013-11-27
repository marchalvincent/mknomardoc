package domain;

import java.io.Serializable;

import org.hibernate.HibernateException;

public class DAOPhoneNumber extends AbstractDAO {

	public static DAOPhoneNumber instance = new DAOPhoneNumber();

	private DAOPhoneNumber() {
		super();
	}

	/**
	 * Get an {@link PhoneNumber} by id.
	 * @param id
	 * @return the {@link PhoneNumber} corresponding with this id.
	 * @throws {@link HibernateException}
	 */
	public PhoneNumber getById(int id) throws HibernateException {
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
		throw new HibernateException(
				"Impossible to get the phone number. getById(" + id + ").");
	}

	/**
	 * Add a new {@link PhoneNumber}
	 * @param phoneKind
	 * @param phoneNumber
	 * @param contact
	 * @return the {@link PhoneNumber} created in database.
	 * @throws {@link HibernateException}
	 */
	public PhoneNumber addPhoneNumber(String phoneKind, String phoneNumber,
			Contact contact) throws HibernateException {
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
			throw new HibernateException(
					"Impossible to get the id of the new phone number.");
			return phone;
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			this.closeSession();
		}
		throw new HibernateException("Impossible to create the phone number.");
	}

	/**
	 * Update an {@link PhoneNumber}.
	 * @param id
	 * @param phoneKind
	 * @param phoneNumber
	 * @param contact
	 * @return the {@link PhoneNumber} updated.
	 * @throws {@link HibernateException}
	 */
	public PhoneNumber updatePhoneNumber(int id, String phoneKind,
			String phoneNumber, Contact contact) throws HibernateException {
		
		PhoneNumber newPhoneNumber = this.getById(id);
		newPhoneNumber.setPhoneKind(phoneKind);
		newPhoneNumber.setPhoneNumber(phoneNumber);
		newPhoneNumber.setContact(contact);
		
		try{
			this.openSession();
			session.save(newPhoneNumber);
			return newPhoneNumber;
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		finally {
			this.closeSession();
		}
		throw new HibernateException("Impossible to update the phoneNumber.");
	}

	/**
	 * Delete an {@link PhoneNumber} from the database.
	 * @param id the id of the {@link PhoneNumber} to delete.
	 * @return false if the delete fail, true otherwise.
	 */
	public boolean deletePhoneNumber(int id) {
		PhoneNumber newPhoneNumber = this.getById(id);
		try{
			this.openSession();
			session.delete(newPhoneNumber);
			return true;
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		finally{
			this.closeSession();
		}
		return false;
	}
}
