package model;

public class Member {
	private String name;
	private Integer id;
	
	public Member(String name, Integer id){
		this.name = name;
		this.id = id;
	}

	public Member(String name){
		this.name = name;
		this.id = -1;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public Integer getId() {
		return id;
	}
	
	public String toString() {
		String s = "name=" + this.name + " id=" + this.id.toString();
		return s;   
	}
}
