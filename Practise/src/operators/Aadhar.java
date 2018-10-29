package operators;

public class Aadhar {
	
private int number;
private String name;
private String dob;
/**
 * @return the number
 */
public int getNumber() {
	return number;
}
/**
 * @param number the number to set
 */
public void setNumber(int number) {
	this.number = number;
}
/**
 * @return the name
 */
public String getName() {
	return name;
}
/**
 * @param name the name to set
 */
public void setName(String name) {
	this.name = name;
}
/**
 * @return the dob
 */
public String getDob() {
	return dob;
}
/**
 * @param dob the dob to set
 */
public void setDob(String dob) {
	this.dob = dob;
}

public void incrementId() {
	this.number = this.number + 1;

}

public void addNumber(int i) {
	this.number = this.number + i;
}

}