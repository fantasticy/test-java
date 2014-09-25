package test.enum_Test;

public enum Season2 {
	
	SPRING("봄"), SUMMER("여름"), FALL("가을"), WINTER("겨울");
	
	final private String name;
	
	Season2(String name) {
		this.name = name;
	}
	
	public String value(){
		return name;
	}

}
