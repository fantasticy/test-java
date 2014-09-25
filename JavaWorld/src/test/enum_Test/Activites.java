package test.enum_Test;

public enum Activites {
	
	REQUEST_REGISTER("register"), REQUEST_MODIFY("modify"), REQUEST_SUCCESS("success"), REQUEST_FALIED("failed"),
	TRUE("true"), FALSE("false"), COMPLETE_MESSAGE("completeMessage");
	
	final private String name;
	
	private Activites(String name) {
		this.name = name;
	}
	
	public String value(){
		return name;
	}

}
