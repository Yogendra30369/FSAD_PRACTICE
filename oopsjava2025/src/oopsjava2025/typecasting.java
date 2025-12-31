package oopsjava2025;
import java.util.Scanner;
public class typecasting {
public static void main(String[] args) {
	Scanner scanner=new Scanner(System.in); 
	int a=scanner.nextInt();
	long b=a;
	float c=b;
	double d=c;
	System.out.println("long is " +b);
	scanner.close();
}
}
