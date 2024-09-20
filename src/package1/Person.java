package package1;

public class Person {
	private String name;
	private String phone;
	
	Person(String pname, String pphone){
		this.name=pname;
		this.phone=pphone;
	}
	
	String getName() {
		return this.name;
	}
	String getPhone() {
		return this.phone;
	}
	void setName(String pname) {
		this.name=pname;
	}
	
	void setPhone(String pphone) {
		this.phone=pphone;
	}
}
