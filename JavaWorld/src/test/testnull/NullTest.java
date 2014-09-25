package test.testnull;

public class NullTest {
	
	public static void main(String[] args) {
		
		UserModel model = new UserModel();
		
		System.out.println(model.getUserId());
		System.out.println(model.getUserName());
		System.out.println(model.getUserAge());
		System.out.println(model.getA());
		System.out.println(model.getB());
		System.out.println(model.getC());
		
	}
	
	private static class UserModel{
		
		private String userId;
		private String userName;
		private String userAge;
		private int a;
		private long b;
		private double c;
		
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getUserAge() {
			return userAge;
		}
		public void setUserAge(String userAge) {
			this.userAge = userAge;
		}
		public int getA() {
			return a;
		}
		public void setA(int a) {
			this.a = a;
		}
		public long getB() {
			return b;
		}
		public void setB(long b) {
			this.b = b;
		}
		public double getC() {
			return c;
		}
		public void setC(double c) {
			this.c = c;
		}
		
	}

}
