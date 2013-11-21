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
	
	/**
	 * A supprimer pour plus tard lorsque les id seront gérés par hibernate et la bd automatiquement
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public int getAge() {
		return age;
	}

	public String toString() {
		return "Je suis " + firstName + " " + lastName + " mon age est de : " + age;
	}
}
