package package1;

public class Admin extends Person {
	private String id="Admin";
	private String pw="Admin1234";

	public Admin(String pname, String pphone) {
		super(pname, pphone);
		// TODO Auto-generated constructor stub
	}
	
	String getId() {
		return this.id;
	}
	
	String getPw() {
		return this.pw;
	}

}
