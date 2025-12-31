package oopsjava2025;
import java.util.Scanner;
public class typecastnarrowing {
public static void main(String[] args) {
	Scanner scanner=new Scanner(System.in);
	double a=scanner.nextDouble();
	float b=(float) a;
	long c=(long) b;
	int d=(int) c;
	System.out.println("int is " +d);
	scanner.close();
}
}
