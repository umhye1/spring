
public class AuthApp {

	public static void main(String[] args) {
		System.out.println(args[0]);
		
		String id = "egoing";
		String inputId = args[0];
		
		String pass = "1111";
		String inputPass = args[1];
		
		System.out.println("Hi");
		if(inputId.equals(id)&&inputPass.equals(pass)) {
			System.out.println("Master!");
		}
		else {
			System.out.println("who are you?");
		}
	
	}
}
