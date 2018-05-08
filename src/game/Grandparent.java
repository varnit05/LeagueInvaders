package game;

public class Grandparent {
String lastName;

public Grandparent(String lastName) {
	this.lastName = lastName;
}
String getLastName() {
	return lastName;
	
}
void setlastname(String lastname) {
	this.lastName  = lastname;
}
void sayLastName() {
	System.out.println(lastName);
}
}
