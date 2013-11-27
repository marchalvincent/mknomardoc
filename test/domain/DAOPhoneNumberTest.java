package domain;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

import util.PhoneKind;

public class DAOPhoneNumberTest {


	private void verification(PhoneNumber phoneNumber) {
		// get another phone from database
		PhoneNumber phoneNumber2 = DAOPhoneNumber.instance.getById(phoneNumber.getId());
		assertTrue(phoneNumber.getId() == phoneNumber2.getId());
		assertTrue(phoneNumber.getPhoneKind().equals(phoneNumber2.getPhoneKind()));
		assertTrue(phoneNumber.getPhoneNumber().equals(phoneNumber2.getPhoneNumber()));
		assertTrue(phoneNumber.getContact().equals(phoneNumber2.getContact()));
	}
	
	@Test
	public void testInsert() {
		// insert a new phoneNumber without Contact
		PhoneNumber phoneNumber = DAOPhoneNumber.instance.addPhoneNumber(PhoneKind.fixe.toString(), "012345", null);
		// verification
		this.verification(phoneNumber);
	}
}
