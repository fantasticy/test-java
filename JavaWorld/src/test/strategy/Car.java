package test.strategy;

public class Car {
	
	private Speaker speaker;
	
	public Car(Speaker speaker) {
		this.speaker = speaker;
	}
	
	public void suddenStop(int level){

		//System.out.println("버럭 !! " + level + "번");
		CarSpeaker speaker = new CarSpeaker();
		speaker.yell("버럭 ! " + level + "번");
	
	}

}
