package hello.core.singleton;

public class StatefulService {

    private int price; //상태를 유지하는 필드

    public void order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);

        this.price = price; // 여기가 문제

        //문제를 해결하려면 price 값을 반환시켜 로컬변수로 할당해주고 맘대로 바뀌면 됨
    }

    public int getPrice() {
        return price;
    }
}
