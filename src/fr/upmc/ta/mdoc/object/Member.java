package fr.upmc.ta.mdoc.object;

public class Member {


	private int id;
	private String lastName;
	private String firstName;
	private int age;
	
	public Member(String lastName, String firstName, int age) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.age = age;
	}
	
	public int getId(){
		return id;
	}
	
	public String toString(){
		return "Je suis " + firstName + " " + lastName + " mon age est de : " + age;
	}
	
}
