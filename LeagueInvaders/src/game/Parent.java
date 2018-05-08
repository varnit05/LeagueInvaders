package game;

public class Parent extends Grandparent{
	String firstName;
public Parent(String lastName, String firstName) {
	super(lastName);
	
}
	String getfirstName() {
		return firstName;
		
	}
	void setfirstname(String firstname) {
		this.firstName  = firstname;
	}
	void sayfirstName() {
		System.out.println(firstName);
	}
	
}


