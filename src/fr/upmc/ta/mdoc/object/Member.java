package fr.upmc.ta.mdoc.object;

public class Member {

	private int id;
	private String login;
	private String password;
	private int age;
	
	public Member(String login, String password, int age) {
		super();
		this.login = login;
		this.password = password;
		this.age = age;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String toString() {
		return "Je suis " + login + ", mon mdp est " + password + ", mon age est " + age;
	}
}
