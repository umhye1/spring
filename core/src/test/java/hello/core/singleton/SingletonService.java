package hello.core.singleton;


public class SingletonService {

    // 내부에 private Static으로 하나 가짐 - 클래스 레벨에 올라감 -> 하나만 존재
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }

    private SingletonService(){
    }

    public void logic(){
        System.out.println("싱글톤 객체 호출");
    }


}
