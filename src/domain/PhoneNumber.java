package domain;

import util.PhoneKind;

public class PhoneNumber {

	private int id;
	private PhoneKind phoneKind;
	private String phoneNumber;
	private Contact contact;

	public PhoneNumber() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhoneKind() {
		return phoneKind.toString();
	}

	public void setPhoneKind(String phoneKind) {
		for (PhoneKind kind : PhoneKind.values()) {
			if (kind.toString().equals(phoneKind)) {
				this.phoneKind = kind;
				return;
			}
		}
		// kind not found
		this.phoneKind = PhoneKind.fixe;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}
}
