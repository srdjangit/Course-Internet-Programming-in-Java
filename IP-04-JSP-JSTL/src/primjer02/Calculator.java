package primjer02;

/**
 *
 * @author mlatinovic
 */
public class Calculator {

	private int number1;
	private int number2;
	private int suma;


	public void setNumber1(String value) {
            this.number1 =  Integer.parseInt(value);
	}
	public void setNumber2(String value) {
            this.number2 =  Integer.parseInt(value);
	}
        public void setSuma(int value) {
            this.suma = value;
        }
        public String getNumber1() {
            return Integer.toString(number1);
        }
        public String getNumber2() {
        	return Integer.toString(number1);
        }
        public int getSuma() {
            return suma;
        }
	public int sumiranje() {
            this.suma = number1 + number2;
            return suma;
	}
        public String helloWorld() {
            return "HelloWorld";
        }
}
