package test.class_A;

public class Outer1 {
	
	private int height;
	private int width;
	
	public Outer1(int height, int width) {
	
		this.height = height;
		this.width = width;
	}

	public Inner getInner(){
		return new Inner();
	}
	
	class Inner {
		
		private float sum = 0;
		
		public float total(){
			return width * height / 2;
		}
	}
	
}
