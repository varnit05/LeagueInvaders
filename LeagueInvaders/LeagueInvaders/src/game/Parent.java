package game;

public class Parent extends Grandparent{
	
public Parent(String lastName) {
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
}

}
