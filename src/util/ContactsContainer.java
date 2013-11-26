package util;

import java.util.ArrayList;
import java.util.List;
import domain.Contact;

public class ContactsContainer {

	private List<Contact> contacts;

	public ContactsContainer() {
		super();
		contacts = new ArrayList<>();
	}

	public void add(Contact m) {
		contacts.add(m);
	}

	public boolean isEmpty() {
		return contacts.size() == 0;
	}

	public Contact pop() {
		return contacts.remove(0);
	}
}
