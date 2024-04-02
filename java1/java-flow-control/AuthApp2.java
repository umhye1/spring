
public class AuthApp2 {

	public static void main(String[] args) {
		
		String[] users = {"sungcheol","seungwoo","jiyong"};
		String inputId = args[0];
		
		boolean isLogined = false;
		
		for(int i =0; i<users.length; i++) {
			String currentId = users[i];
			if(currentId.equals(inputId)){
				isLogined = true;
				break;
			}
			
		}
		
		System.out.println("hi");
		if(isLogined) {
			System.out.println("Mastser");
		}
		else {
			System.out.println("who are you?"); 
		}

	}

}
