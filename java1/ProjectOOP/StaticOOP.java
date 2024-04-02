class Foo{
	public static String classVar = "I class var";
	public String instanceVar = "I class instanceVar";
	
	public static void classMethod() {
		System.out.println(classVar);
//		System.out.println(instanceVar); // error
		
	}
	public void instanceMethod() {
		System.out.println(classVar);
		System.out.println(instanceVar);
	}
}


public class StaticOOP {

	public static void main(String[] args) {
		System.out.println(Foo.classVar);
//		System.out.println(Foo.instanceVar); // error
		
	}

}
