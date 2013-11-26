package domain;

import java.io.Serializable;

import org.hibernate.HibernateException;

public class DAOAddress extends AbstractDAO {

	public static DAOAddress instance = new DAOAddress();
	public DAOAddress() { super(); }
	
	/**
	 * Get an address by id.
	 * @param id
	 * @return the address coresponding with this id.
	 * @throws HibernateException
	 */
	public Address getById(Integer id) throws HibernateException {
		try {
			this.openSession();
			
			Object addressO = session.get(Address.class, id);
			if (addressO != null && addressO instanceof Address)
				return (Address) addressO;
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			this.closeSession();
		}
		throw new HibernateException("Impossible to get the Address. getById(" + id + ").");
	}
	
	/**
	 * Add a new Address
	 * @param street
	 * @param city
	 * @param zip
	 * @param country
	 * @return the Address created in database
	 * @throws HibernateException
	 */
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
			
			return address;
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			this.closeSession();
		}
		throw new HibernateException("Impossible to create the Address.");
	}
	
	/**
	 * Update an address.
	 * @param id of the address to update
	 * @param street, the new street
	 * @param city, the new city
	 * @param zip, the new zip
	 * @param country, the new country
	 * @return the Address updated
	 * @throws HibernateException
	 */
	public Address updateAddress(int id, String street, String city, String zip, String country) 
	throws HibernateException {

		Address address = this.getById(id);
		address.setId(id);
		address.setStreet(street);
		address.setCity(city);
		address.setZip(zip);
		address.setCountry(country);
		
		try {
			this.openSession();
			session.update(address);
			return address;
		} catch (HibernateException e) {
			e.printStackTrace();
		}  finally {
			this.closeSession();
		}
		throw new HibernateException("Impossible to update the address.");
	}
	
	/**
	 * Delete an address from the database.
	 * @param id the id of the address to delete.
	 * @return false if the delete fail, true otherwise.
	 */
	public boolean deleteAddress(int id) {
		// TODO tester + voir la répercussion sur contact
		Address address = this.getById(id);
		try {
			this.openSession();
			session.delete(address);
			
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			this.closeSession();
		}
		return false;
	}
}
