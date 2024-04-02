
public class AuthApp3 {

	public static void main(String[] args) {
		
		String[][] users = {
				{"sungcheol","1111"},
				{"suhyeon","2222"},
				{"seungwoo","3333"}
		};
		 
		String inputId = args[0];
		String inputPass = args[1];
		
		boolean isLogined = false;
		for(int i =0; i<users.length; i++) {
			String[] current = users[i]; // users가 배열이기 때문에 currentId로 못 담음 -> 배열로 만들어줘야함 
			
			if(current[0].equals(inputId)&&current[1].equals(inputPass)) {
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
