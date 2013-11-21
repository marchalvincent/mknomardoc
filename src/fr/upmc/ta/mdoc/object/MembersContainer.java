package fr.upmc.ta.mdoc.object;

import java.util.ArrayList;
import java.util.List;

public class MembersContainer {

	private List<Member> members;
	
	public MembersContainer() {
		super();
		members = new ArrayList<>();
	}
	
	public void add(Member m) {
		members.add(m);
	}
	
	public boolean isEmpty() {
		return members.size() == 0;
	}
	
	public Member pop() {
		return members.remove(0);
	}
}
