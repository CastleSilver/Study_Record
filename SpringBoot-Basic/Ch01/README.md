## 스프링 핵심 개념
+ 스프링은 객체 지향 언어의 장점을 살리기 위해 개발된 프레임워크
+ 스프링은 다형성을 극대화해서 이용할 수 있게 도와준다.
## 객체 지향 특징
+ 추상화
+ 캡슐화
+ 상속
+ 다형성
## 객체 지향 프로그래밍
+ 객체 지향 프로그래밍은 유연하고 변경이 용이하다. - 다형성
## 다형성
+ 역할과 구현을 분리 - 유연해지며 변경이 편리해짐
+ 클라이언트는 대상의 역할만 알면된다.
+ 클라이언트는 내부구조를 몰라도 되고, 내부구조가 변경되어도 영향 받지 않는다.
+ 클라이언트는 구현 대상 자체를 변경해도 영향 받지 않는다.
## 좋은 객체지향설계의 5가지 원칙(SOLID)
### SRP 단일 책임 원칙(Single responsibility principle)
+ 한 클래스는 하나의 책임만 가져야 한다.
+ 하나의 책임은 문맥과 상황에 따라 달라진다.
+ 중요한 기준은 변경이다. 변경이 있을 때 파급효과가 적으면 단일 책임 원칙을 잘 따른 것이다.
### OCP 개방-폐쇄 원칙(Open/closed principle)
+ 소프트웨어 요소는 확장에는 열려 있으나 변경에는 닫혀 있어야 한다.
+ 다형성을 활용하여 인터페이스를 구현한 새로운 클래스를 만들어 새로운 기능을 구현한다.
### LSP 리스코프 치환 원칙(Liskov Substitution principle)
+ 프로그램의 객체는 프로그램의 정확성을 깨뜨리지 않으면서 하위 타입의 인스턴스로 바꿀 수 있어야 한다.
+ 다형성에서 하위 클래스는 인터페이스 규약을 다 지켜야 한다는 것을 의미한다.
### ISP 인터페이스 분리 원칙(Interface segregation principle)
+ 여러개 인터페이스가 범용 인터페이스 하나보다 낫다.
+ 인터페이스가 명확해지고, 대체 가능성이 높아진다.
### DIP 의존관계 역전 원칙(Dependency inversion principle)
+ 구현 클래스에 의존하지 말고, 인터페이스에 의존해야 한다.
+ 구현체에 의존하게 되면 변경이 어려워 진다.

# 다형성 만으로는 OCP, DIP를 지킬 수 없다! => 스프링 프레임워크 개발
