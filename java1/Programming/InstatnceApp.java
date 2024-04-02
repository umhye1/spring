import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
public class InstatnceApp {

	public static void main(String[] args) throws FileNotFoundException {
		//인스턴스 사용
		//하나의 클래스를 만들어서 인스턴스 복제. 각각 다른 상태의 인스턴스 생성 
		PrintWriter p1 = new PrintWriter("result1.txt");
		p1.write("hello1");
		p1.close();
		
		PrintWriter p2 = new PrintWriter("result2.txt");
		p2.write("hello2");
		p2.close();
		
		// 클래스에 직접 write - 그때 그때 어디에 쓸지 지정해줘야
		//PrintWriter.write("result1.txt","hello1");
		//PrintWriter.write("result2.txt","hello2");
	}
 
}
