package test.enum_Test;

public class EnumExample {
	
	public static void main(String[] args) {
		
		printSeason(Season.SPRING);
		printSeason(Season.SUMMER);
		printSeason(Season.FALL);
		printSeason(Season.WINTER);
		System.out.println();
		
		printSeasonOrdinal(Season.SPRING);
		printSeasonOrdinal(Season.SUMMER);
		printSeasonOrdinal(Season.FALL);
		printSeasonOrdinal(Season.WINTER);
		System.out.println();
		System.out.println(Season.valueOf(Season.class, "SPRING"));
		System.out.println();
		
		printSeason2(Season2.SPRING);
		printSeason2(Season2.SUMMER);
		printSeason2(Season2.FALL);
		printSeason2(Season2.WINTER);
		System.out.println();
		System.out.println(Season2.valueOf(Season2.class, "SPRING"));
		System.out.println();
		
		printSeason2Ordinal(Season2.SPRING);
		printSeason2Ordinal(Season2.SUMMER);
		printSeason2Ordinal(Season2.FALL);
		printSeason2Ordinal(Season2.WINTER);
	}
	
	public static void printSeason(Season season){
		System.out.println(season);
	}
	
	public static void printSeasonOrdinal(Season season){
		System.out.println(season.ordinal());
	}
	
	public static void printSeason2(Season2 season){
		System.out.println(season.value());
	}
	
	public static void printSeason2Ordinal(Season2 season){
		System.out.println(season.ordinal());
	}

}
