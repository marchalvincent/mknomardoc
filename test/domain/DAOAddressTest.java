package domain;

import static org.junit.Assert.*;
import org.hibernate.HibernateException;
import org.junit.Test;

public class DAOAddressTest {

	private void verification(Address address) {
		Address address2 = DAOAddress.instance.getById(address.getId());
		assertTrue(address.getStreet().equals(address2.getStreet()));
		assertTrue(address.getCity().equals(address2.getCity()));
		assertTrue(address.getZip().equals(address2.getZip()));
		assertTrue(address.getCountry().equals(address2.getCountry()));
	}

	@Test
	public void testInsert() {
		// insert
		Address address = DAOAddress.instance.addAddress("streetTest1",
				"cityTest1", "zipTest1", "countryTest1");
		assertTrue(address != null);
		// verification
		this.verification(address);
	}

	@Test
	public void testUpdate() {
		// insert
		Address address = DAOAddress.instance.addAddress("streetTest2",
				"cityTest2", "zipTest2", "countryTest2");
		// and update
		Address addressUpdated = DAOAddress.instance.updateAddress(
				address.getId(), "newStreetTest2", "newCityTest2",
				"newZipTest2", "newCountryTest2");
		// verification, test with the new values in database
		this.verification(addressUpdated);
	}

	@Test
	public void testDelete() {
		// insert
		Address address = DAOAddress.instance.addAddress("streetTestDelete",
				"cityTestDelete", "zipTestDelete", "countryTestDelete");
		// and delete
		assertTrue(DAOAddress.instance.deleteAddress(address.getId()));
		try {
			// a get must throw an exception
			DAOAddress.instance.getById(address.getId());
			fail();
		} catch (HibernateException e) {}
	}
}
