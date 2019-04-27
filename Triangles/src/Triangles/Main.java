package Triangles;
import java.text.DecimalFormat;

public class Main {
	
	static String b1, b2, b3;
	
	
	
	public static void main(String[] args) {
		
		DecimalFormat numberFormat = new DecimalFormat("#.##");
		
		b1 = numberFormat.format(Triangel.bisektris(1, 2, 3));
		b2 = numberFormat.format(Triangel.bisektris(4, 1, 1));
		b3 = numberFormat.format(Triangel.bisektris(2, 4, 2));
		
		System.out.println("Bisektris 1: " + b1 + " Bisektris 2: " + b2 + " Bisektris 3: " + b3);
	}

}
