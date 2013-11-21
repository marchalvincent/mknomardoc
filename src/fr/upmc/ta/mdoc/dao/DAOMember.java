package fr.upmc.ta.mdoc.dao;

import fr.upmc.ta.mdoc.object.Member;
import fr.upmc.ta.mdoc.object.MembersContainer;

public class DAOMember {

	public static DAOMember instance = new DAOMember();
	
	public MembersContainer getAllMember() {
		
		MembersContainer container = new MembersContainer();
		Member m1 = new Member("kno", "mich", 18);
		m1.setId(1);
		container.add(m1);
		Member m2 = new Member("mar", "vinc", 21);
		m2.setId(2);
		container.add(m2);
		Member m3 = new Member("tran", "mamadidi", 18);
		m3.setId(3);
		container.add(m3);
		
		return container;
	}
	
	public boolean createMember(String name, String password, int age) {
		System.out.println("Create member : name : " + name + ", password : " + password + ", " + age + " years old.");
		return true;
	}
	
	public void updateMember() {
		// TODO
	}
	
	public void deleteMember(int memberId) {
		System.out.println("Delete the member with the id : " + memberId);
	}
	
	
}
