package test.strategy;

public class CarSpeaker implements Speaker{
	
	@Override
	public void yell(String string){
		System.out.println(string);
	}

}
