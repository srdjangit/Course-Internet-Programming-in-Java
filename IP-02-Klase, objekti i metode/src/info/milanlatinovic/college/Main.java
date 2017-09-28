package info.milanlatinovic.college;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Student student1 = new Student();
		student1.setFirstName("Marko");
		student1.setLastName("Markovic");
		student1.setJmb("12121212121212");
		student1.setOnBudget(true);
		student1.setYearOfStudies(3);
		
		student1.printStudent();
	
		Student student2 = new Student();
		student2.setFirstName("Goran");
		student2.setOnBudget(false);
		
		student2.printStudent();
	
		student2 = student1;
	
		student2.printStudent();

		student1.setYearOfStudies(student1.getYearOfStudies() + 1);

		student1.printStudent();
	
		student1.setOnBudget(false);
	
		student1.printStudent();

	}

}
