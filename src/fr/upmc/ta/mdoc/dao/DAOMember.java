package fr.upmc.ta.mdoc.dao;

import java.util.ArrayList;
import java.util.List;

import fr.upmc.ta.mdoc.object.Member;

public class DAOMember {

	public static DAOMember instance = new DAOMember();
	
	public List<Member> getAllMember(){
		
		List<Member> members = new ArrayList<Member>();
		members.add(new Member("kno", "mich", 18));
		members.add(new Member("mar", "vinc", 21));
		members.add(new Member("tran", "mamadidi", 18));
		return members;
	}
	
	public void createMember() {
		// TODO
	}
	
	public void updateMember() {
		// TODO
	}
	
	public void deleteMember() {
		// TODO
	}
	
	
}
