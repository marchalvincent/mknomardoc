package fr.upmc.ta.mdoc.dao;

public class DAOMember {

	public static DAOMember instance = new DAOMember();
	
	public boolean createMember(String name, String password, int age) {
		System.out.println("Create member : name : " + name + ", password : " + password + ", " + age + " years old.");
		return true;
	}
	
	public void updateMember() {
		// TODO
	}
	
	public void deleteMember() {
		// TODO
	}
}
