package oopsjava2025;

public class operators {
	public static void main(String args[]) {
    int a = 12,b = 5;
    System.out.println("a + b = " +(a + b));
    System.out.println("a - b = " + (a - b));
    System.out.println("a * b = " + (a * b));
    System.out.println("a / b = " + (a / b));
    System.out.println("a % b = " + (a % b));
    
    
    int c=9,d=10;
    System.out.println("c+= " + ++c);
    System.out.println("c-= " + --c);
    System.out.println("d-= " + d--);
    System.out.println("d= " + d);
    
    System.out.println((8>5)&&(5>6));
    System.out.println((5>3)&&(3>2));
    System.out.println((4>2)||(4>6));
    System.out.println((1>2)||(4>6));
    
    
    int Days = 29;
    String result;
    result = (Days == 28) ? "Not a leap year" : "Leap year";
    System.out.println(result);

    
    String str="Zero";
    boolean results;
    results = str instanceof String;
    System.out.println("string is " + results);
	}
}
