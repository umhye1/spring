public class ArrayApp {
 
    public static void main(String[] args) {
         
    	String[] users = new String[3];
    	users[0] = "sungcheol";
    	users[1] = "suhyeon";
    	users[2] = "jiyong";
    	
    	System.out.println(users);
    	System.out.println(users[0]);
    	System.out.println(users.length);
 
    	for(int i =0; i<users.length; i++) {
    		System.out.println(users[i]+",");
    	}
	
}
}
