package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

//가짜 네트워크 클라이언트
public class NetworkClient implements InitializingBean, DisposableBean { // 초기화 빈
    private String url;
    public NetworkClient(){
        System.out.println("생성자 호출 , url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작시 호출
    public void connect(){
        System.out.println("connect: "+url);
    }

    public void call(String message){
        System.out.println("call: " + url + " message = " + message);
    }

    //서비스 종료시 호출
    public void disconnect(){
        System.out.println("close: "+url);
    }

    //의존 관계 주입 후 연결
    @Override
    public void afterPropertiesSet()throws Exception{
        connect();
        call("초기화 연결 메시지");
    }

    @Override
    public void destroy() throws Exception {
        disconnect();
    }
}
