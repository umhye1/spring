
//public class MyOOP {
//	public static void main(String[] args) {
//		delimeter="----";
//		printA();
//		printA();
//		printB();
//		printB();
//		
//		delimeter ="****";
//		printA();
//		printA();
//		printB();
//		printB();
//				
//	}
//	
//	public static String delimeter= "----";
//	public static void printA() {
//	System.out.println(delimeter);
//	System.out.println("A");
//	}
//	public static void printB() {
//		System.out.println(delimeter);
//		System.out.println("B");
//		}
//	
//
//}
class Print{
	public String delimeter ="";
	//생성자
	public Print(String _delimeter) {
		this.delimeter = delimeter;
	}
	public void A() {
		System.out.println(this.delimeter);
		System.out.println("A");
		System.out.println("A");
	}
	public void B() {
		System.out.println(this.delimeter);
		System.out.println("B");
		System.out.println("B");
	}	
}