package domain;

import java.io.Serializable;
import java.util.Set;
import org.hibernate.HibernateException;

public class DAOContactGroup extends AbstractDAO {

	public static DAOContactGroup instance = new DAOContactGroup();

	private DAOContactGroup() {
		super();
	}

	/**
	 * Get an {@link ContactGroup} by id.
	 * 
	 * @param id
	 * @return the contact group coresponding with this id.
	 * @throws {@link HibernateException}
	 */
	public ContactGroup getById(Integer id) throws HibernateException {
		try {
			this.openSession();
			Object contactGroupO = session.get(ContactGroup.class, id);
			if (contactGroupO != null && contactGroupO instanceof ContactGroup)
				return (ContactGroup) contactGroupO;
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			this.closeSession();
		}
		throw new HibernateException(
				"Impossible to get the contact group. getById(" + id + ").");
	}

	/**
	 * Add a new {@link ContactGroup}
	 * 
	 * @param groupName
	 * @param contacts
	 * @return the {@link ContactGroup} created in database.
	 * @throws {@link HibernateException}
	 */
	public ContactGroup addContactGroup(String groupName, Set<Contact> contacts)
			throws HibernateException {
		ContactGroup group = new ContactGroup();
		group.setGroupName(groupName);
		group.setContacts(contacts);
		try {
			this.openSession();
			Serializable newId = session.save(group);
			if (newId instanceof Integer)
				group.setGroupId((Integer) newId);
			else // all ids are Integer in our database
			throw new HibernateException(
					"Impossible to get the id of the new ContactGroup.");
			return group;
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new HibernateException(
					"Impossible to create the ContactGroup.");
		} finally {
			this.closeSession();
		}
	}

	/**
	 * Add a {@link Contact} to a group in database.
	 * 
	 * @param id
	 * @param contact
	 * @return
	 * @throws {@link HibernateException}
	 */
	// TODO voir si besoin
	public boolean addContactToGroup(int idGroup, Contact contact)
			throws HibernateException {
		return false;
	}

	/**
	 * Update a {@link Contact}  group.
	 * 
	 * @param id
	 * @param groupName
	 * @param contacts
	 * @return the {@link ContactGroup} updated.
	 * @throws {@link HibernateException}
	 */
	public ContactGroup updateContactGroup(int id, String groupName,
			Set<Contact> contacts) throws HibernateException {
		// get from database
		ContactGroup group = this.getById(id);
		// set the new values
		group.setGroupName(groupName);
		group.setContacts(contacts);
		try {
			this.openSession();
			session.update(group);
			return group;
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new HibernateException(
					"Impossible to update the contact group.");
		} finally {
			this.closeSession();
		}
	}

	/**
	 * Delete a {@link ContactGroup} from database
	 * 
	 * @param id
	 * @return false if the delete fail, true otherwise.
	 */
	public boolean deleteContactGroup(int id) {
		ContactGroup group = this.getById(id);
		try {
			this.openSession();
			session.delete(group);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		} finally {
			this.closeSession();
		}
	}
}
