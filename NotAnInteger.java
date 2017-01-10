package cs2s03;

public class NotAnInteger extends Throwable{
	
	private String expected;
	
	public NotAnInteger(String given){
		this.expected = given;
	}
	
	
}
