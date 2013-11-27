package domain;

import java.io.Serializable;

import org.hibernate.HibernateException;

import util.ContactsContainer;

public class DAOContact extends AbstractDAO {

	public static DAOContact instance = new DAOContact();

	public DAOContact() {
		super();
	}
	
	/**
	 * Get an {@link Contact} by his id.
	 * @param id
	 * @return the contact corresponding with this id.
	 * @throws {@link HibernateException}
	 */
	public Contact getById(Integer id) throws HibernateException {
		try {
			this.openSession();
			Object contactO = session.get(Contact.class, id);
			if(contactO != null && contactO instanceof Contact)
				return (Contact) contactO;
		}
		catch(HibernateException e){
			e.printStackTrace();
		}
		finally{
			this.closeSession();
		}
		throw new HibernateException("Impossible to get the Contact. getById("
				+ id + ").");
	}
	
	/**
	 * Get all of member contained in this Database.
	 * @return all of member contained in this Database in the {@link ContactsContainer} object.
	 * @throws {@link HibernateException}
	 */
	public ContactsContainer getAllMember() throws HibernateException{
		//ContactsContainer contactContainer = new ContactsContainer();
		
		try{
			this.openSession();
			//TODO MKR : we have to do this ! RETURN Null ! 
			//Object  = session.get(Contact.class);
			return null;
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		finally
		{
			this.closeSession();
		}
		return null;
	}

	/**
	 * Add a new {@link Contact}
	 * @param id
	 * @param firstname
	 * @param lastname
	 * @param emailC
	 * @return the {@link Contact} created in database
	 * @throws {@link HibernateException}
	 */
	public Contact addContact(String firstname, String lastname,
			String emailC) throws HibernateException{
		
		Contact contact = new Contact();
		contact.setFirstName(firstname);
		contact.setLastName(lastname);
		contact.setEmail(emailC);
		try{
			this.openSession();
			Serializable newID = session.save(contact);
			if(newID instanceof Integer)
				contact.setId((Integer) newID);
			else //We have to stay in the if bloc, all ids are Integer
				throw new HibernateException(
						"Impossible to get the new ID of the Contact saved.");
			return contact;
		}catch(HibernateException e)
		{
			e.printStackTrace();
		}
		finally {
			this.closeSession();
		}
		throw new HibernateException("Impossible to create the Contact.");
		
	}

	/**
	 * Update an {@link Contact}.
	 * @param id
	 * @param firstname
	 * @param lastname
	 * @param emailC
	 * @return the {@link Contact} updated.
	 * @throws HibernateException
	 */
	public Contact updateContact(int id, String firstname, String lastname,
			String emailC) throws HibernateException{
		Contact contact = this.getById(id);
		contact.setFirstName(firstname);
		contact.setLastName(lastname);
		contact.setEmail(emailC);
		
		try{
			this.openSession();
			session.update(contact);
			return contact;
		}
		catch(HibernateException e){
			e.printStackTrace();
		}
		finally{
			this.closeSession();
		}
		throw new HibernateException("Impossible to update the Contact where the id is " + id + " .");
	}

	/**
	 * Delete an {@link Contact} from the database.
	 * @param memberId
	 * 					the memberId of the {@link Contact} to delete.
	 * @return
	 */
	public boolean deleteContact(int memberId) {
		Contact contact = this.getById(memberId);
		try{
			this.openSession();
			session.delete(contact);
			return true;
		}
		catch(HibernateException e){
			e.printStackTrace();
		}
		finally{
			this.closeSession();
		}
		return false;
	}
}
