# 프록시와 AOP
## 프록시(proxy)
+ 핵심 기능의 실행은 다른 객체에 위임하고 부가적인 기능을 제공하는 객체를 프록시라고 한다.
+ 접근 제어 관점에 초점이 맞춰져 있다.

## AOP
+ Aspect Oriented Programming의 약자로, 여러 객체에 공통으로 적용할 수 있는 기능을 분리해서 재사용성을 높여주는 프로그래밍 기법이다.
+ 핵심 기능의 코드를 수정하지 않으면서 공통 기능의 구현을 추가하는 것이다.
+ 핵심 기능에 공통 기능을 삽입하는 방법은 다음과 같다.
  1. 컴파일 시점에 코드에 공통 기능을 삽입
  2. 클래스 로딩 시점에 바이트 코드에 공통 기능을 삽입
  3. 런타임에 프록시 객체를 생성해서 공통 기능을 삽입
+ 1번과 2번은 AspectJ와 같이 AOP 전용 도구를 사용해서 적용할 수 있고 3번은 스프링에서 제공해준다.

![](https://velog.velcdn.com/images/aysel0230/post/f1dd6d31-3ff0-433f-a61e-ff8034cf0bda/image.png)
+ AOP 주요 용어

![](https://velog.velcdn.com/images/aysel0230/post/6fa6d612-3631-4da5-b969-7c67c0d11f1e/image.png)
+ 스프링에서 구현 가능한 Advice 종류

![](https://velog.velcdn.com/images/aysel0230/post/81c37b5d-4d8d-45e3-958d-e19e80829e68/image.png)

# 스프링 AOP 구현
+ Aspect로 사용할 클래스에 @Aspect를 붙인다.
+ @Pointcut 으로 공통 기능을 적용할 Pointcut을 정의한다
+ 공통 기능을 구현한 메서드에 @Around를 적용한다.
+ @EnableAspectJAutoProxy : @Aspect이 붙은 빈 객체를 찾아서 빈 객체의 @Pointcut 설정과 @Around 설정을 사용한다.
+ 스프링은 AOP를 위한 프록시 객체를 생성할 때 실제 생성할 빈 객체가 인터페이스를 상속하면 인터페이스를 이용해 프록시를 생성한다. 
+ `@EnableAspectJAutoProxy(proxyTargetClass = true)` 라고 설정하면 인터페이스가 아닌 자바 클래스를 상속받아 프록시를 생성한다.

## execution 명시자 표현식
```
execution(수식어패턴? 리턴타입패턴 클래스이름패턴?메서드이름패턴(파라미터패턴))
```
+ 수식어패턴은 생략 가능하다.
+ `*`을 이용해 모든 값을 표현할 수 있다.
+ `..`을 이용해 0개 이상이라는 의미를 표현할 수 있다.

![](https://velog.velcdn.com/images/aysel0230/post/ab607145-5b61-4e23-9526-5f6e24499a46/image.png)

## Advice 적용 순서
+ 한 Pointcut에 여러 Advice를 적용할 수 있다.
+ @Order를 이용해 적용순서를 지정할 수 있다. 지정한 값이 작으면 먼저 적용되고 크면 나중에 적용된다.

## @Around의 Pointcut 설정과 @Pointcut 재사용
+ 포인트 컷만 지정한 메서드를 생성해서 메서드 이름을 호출하면서 사용할 수 있다.
+ 아니면 @Around 옆에 execution을 직접 설정할 수 있다.

