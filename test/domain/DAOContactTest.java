package domain;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.hibernate.HibernateException;
import org.junit.Test;

public class DAOContactTest {

	private void verification(Contact Contact) {
		Contact contact2 = DAOContact.instance.getById(Contact.getId());
		assertTrue(Contact.getFirstName().equals(contact2.getFirstName()));
		assertTrue(Contact.getLastName().equals(contact2.getLastName()));
		assertTrue(Contact.getEmail().equals(contact2.getEmail()));
		//TODO MKR : à améliorer (plus de donnés)
		//Changer le constructeur
		//assertTrue(Contact.getAddress().equals(contact2.getAddress()));
		//assertTrue(Contact.getBooks().equals(contact2.getBooks()));
		//assertTrue(Contact.getPhones().equals(contact2.getPhones()));
	}

	@Test
	public void testInsert() {
		// insert
		Contact contact = DAOContact.instance.addContact("michmich-Insert", "knoert-Insert", "michmich.knoert@gmail.com");
		assertTrue(contact != null);
		// verification
		this.verification(contact);
	}

	@Test
	public void testUpdate() {
		// insert
		Contact contact = DAOContact.instance.addContact("michmich-Update", "knoert-Update", "michmich.knoert@gmail.com");
		// and update
		Contact contactUpdated = DAOContact.instance.updateContact(contact.getId(), "vivi", "marchal", "vivi.marchal@gmail.com");

		// verification, test with the new values in database
		this.verification(contactUpdated);
	}

	@Test
	public void testDelete() {
		// insert
		Contact contact = DAOContact.instance.addContact("michmich-Update", "knoert-Update", "michmich.knoert@gmail.com");
		// and delete
		assertTrue(DAOContact.instance.deleteContact(contact.getId()));
		try {
			// a get must throw an exception
			DAOContact.instance.getById(contact.getId());
			fail();
		} catch (HibernateException e) {
		}
	}
}
