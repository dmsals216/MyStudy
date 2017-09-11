## Interface

#### Interface란?

1. 인터페이스는 클래스를 메뉴화(?)시킨 추상 클래스이다.

2. 동작하는 메서드를 만들지 않고 메서드들만 정의시킨다.

3. 인터페이스는 동작을 하지 않으므로 상속을 받은 클래스가 받은 메서드들을 구현해야한다.


#### 인터페이스를 이용하여 callback형태를 만들기
1. interface
```Java
public interface InterfaceC {
  public void callback();
}
```
2. interface의 callback 메서드를 호출시키는 class
```Java
public class ClassC {
  public void process(InterfaceC c) {
    //....처리
    //....처리
    //....처리
    c.callback();
  }
}
```
3. 그 기능을 구현하는 class
```Java
public class AAA implements InterfaceC {
  public void process() {
    ClassC c = new ClassC();
    c.process(this);
  }
  public void afterProcess() {
    System.out.println("실행이 완료되었습니다.");
  }
  @Override
  public void callback() {
    afterProcess();
  }
}
```
