package hello.core.singleton;

public class SingletonService {

    //자바가 실행될 때 static 이므로 실행되어 객체가 생성됨, 객체를 미리 생성해놓는 가장 단순한 방법
    private static final SingletonService instance = new SingletonService();

    // instance 객체가 필요하면 오직 getInstance 메서드를 통해서만 조회할 수 있다. 항상 같은 인스턴스 반환한다.
    public static SingletonService getInstance() {
        return instance;
    }

    // 생성자를 private로 막아서 외부에서 new를 하지 못하도록 한다.
    private SingletonService() {

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

    // 싱글톤 패턴의 문제점
    // 1. 위 코드를 다 적어야 한다.
    // 2. 의존관계상 클라이언트가 구체 클래스에 의존 ->DIP위반
    // 3. 이미 객체를 생성하기 때문에 유연하게테스트하기 어렵다.
    // 4. private이기 때문에 자식 클래스를 만들기 어렵다
    // 5. 결론적으로 유연성이 떨어짐

    // 스프링 프레임워크는 싱글톤 패턴의 문제점을 다 없애주면서 관리해줌
}
