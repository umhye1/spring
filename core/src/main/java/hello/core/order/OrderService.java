package hello.core.order;

public interface OrderService {

    //1. 주문 생성, 4. 주문 반환
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
