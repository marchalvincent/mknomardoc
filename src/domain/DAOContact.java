package domain;

import util.ContactsContainer;

public class DAOContact {

	public static DAOContact instance = new DAOContact();
	
	public ContactsContainer getAllMember() {
		
		ContactsContainer container = new ContactsContainer();
		Contact m1 = new Contact();
		m1.setId(1);
		m1.setFirstName("michel");
		m1.setLastName("Knoertzer");
		m1.setEmail("mich.kno@gmail.com");
		container.add(m1);
		Contact m2 = new Contact();
		m2.setId(2);
		m2.setFirstName("vincent");
		m2.setLastName("marchal");
		m2.setEmail("vinc.mar@gmail.com");
		container.add(m2);
		Contact m3 = new Contact();
		m3.setId(2);
		m3.setFirstName("mamadidi");
		m3.setLastName("tran");
		m3.setEmail("mamadidi.tran@gmail.com");
		container.add(m3);
		
		return container;
	}
	
	public boolean addContact(int id, String firstname, String lastname, String emailC) {
		System.out.println("Create member : firstname : " + firstname + ", lastname : " + lastname + ", emailC " + emailC + ".");
		Contact contact = new Contact();
		contact.setId(id);
		contact.setFirstName(firstname);
		contact.setLastName(lastname);
		contact.setEmail(emailC);
		return true;
	}
	
	public boolean updateContact(int id, String firstname, String lastname, String emailC) {
		System.out.println("Update password id : " + id + ", firstname : " + firstname + ", lastname " +
				lastname + ", emailC : " + emailC);
		return true;
	}
	
	public boolean deleteContact(int memberId) {
		System.out.println("Delete the member with the id : " + memberId);
		return true;
	}
}
