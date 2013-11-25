package domain;

import static org.junit.Assert.*;

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
		Address address = DAOAddress.instance.addAddress("streetTest1", "cityTest1", "zipTest1", "countryTest1");
		assertTrue(address != null);
		// verification
		this.verification(address);
	}
	
	@Test
	public void testUpdate() {
		// insert 
		Address address = DAOAddress.instance.addAddress("streetTest2", "cityTest2", "zipTest2", "countryTest2");
		// and update
		assertTrue(DAOAddress.instance.updateAddress(address.getId(), "newStreetTest2", "newCityTest2", "newZipTest2", "newCountryTest2"));
		// verification, make the changes handly for test with the new values in database
		address.setStreet("newStreetTest2");
		address.setCity("newCityTest2");
		address.setZip("newZipTest2");
		address.setCountry("newCountryTest2");
		this.verification(address);
	}
	
	@Test
	public void testDelete() {
		assertTrue(DAOAddress.instance.deleteAddress(0));
	}

}
