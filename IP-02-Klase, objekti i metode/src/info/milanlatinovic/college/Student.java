package info.milanlatinovic.college;

public class Student {
	
	// Atributi klase, podešeni na private, pristup samo pomoæu gettera i settera
	private String firstName;
	private String lastName;
	private String jmb;
	private int yearOfStudies;
	private boolean onBudget;
	
	// Konstruktor
	public Student() {
		// podešavamo poèetne vrijednosti
		firstName = null;
		lastName = null;
		jmb = null;
		yearOfStudies = 1;
		onBudget = false;
	}
	
	// funkcija za printanje studenta
	public String printStudent() {
		String result = null;
		result = "Student: " + firstName + " " + lastName + ", " + jmb + ", " + yearOfStudies + " godina studija. ";
		if (onBudget) {
			result += "Student jeste na budzetu.";
		}
		else {
			result += "Student nije na budzetu.";
		}
		System.out.println(result);
		return result;
	}
	
	// Getteri i Setteri
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getJmb() {
		return jmb;
	}
	public void setJmb(String jmb) {
		this.jmb = jmb;
	}
	public int getYearOfStudies() {
		return yearOfStudies;
	}
	public void setYearOfStudies(int yearOfStudies) {
		this.yearOfStudies = yearOfStudies;
	}
	public boolean isOnBudget() {
		return onBudget;
	}
	public void setOnBudget(boolean onBudget) {
		this.onBudget = onBudget;
	}
	
	

}
