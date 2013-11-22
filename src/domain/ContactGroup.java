package domain;

import java.util.ArrayList;
import java.util.List;

public class ContactGroup {

	private int groupId;
	private String groupName;
	private List<Contact> contacts;
	
	public ContactGroup() {
		contacts = new ArrayList<>();
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupeId) {
		this.groupId = groupeId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupeName) {
		this.groupName = groupeName;
	}

	public List<Contact> getContacts() {
		return contacts;
	}
	
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
}
