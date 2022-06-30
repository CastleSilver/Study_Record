# 강의 목표
+ 스프링 컨테이너의 동작 원리를 이해한다.
+ 스프링 빈의 동작 원리를 이해한다.
<br/>

# 스프링 컨테이너
## 생성
```
ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
```
+ `ApplicationContext`를 스프링 컨테이너라 한다.
+ `ApplicationContext`는 인터페이스다.
+ 스프링 컨테이너는 1. XML을 기반으로 하거나 2. 애노테이션 기반의 자바 설정 클래스로 만들 수 있다.
![image](https://user-images.githubusercontent.com/95426849/174606286-171a0fc2-a306-47fd-b0d2-9f183aeb7d5a.png)
<br/>

## 메서드
```
AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
```
+ `ac.getBeanDefinitionNames()` : 스프링에 등록된 모든 빈 이름을 조회한다.
+ `ac.getBean()` : 빈 이름으로 빈 객체를 조회한다.
+ `BeanDefinition.ROLE_APPLICATION` : 사용자가 정의한 빈
+ `BeanDefinition.ROLE_INFRASTRUCTURE` : 스프링이 내부에서 사용하는 빈
+ 동일한 타입의 스프링 빈이 둘 이상일 때는 `ac.getBean(빈이름, 타입)` 처럼 이름을 지정해 호출하면 된다.
+ `ac.getBeansOfType()`을 사용하면 해당 타입의 모든 빈을 조회할 수 있다.
+ 부모타입으로 조회하면, 자식 타입도 조회된다. 따라서 최고 부모 타입인 `Object`로 조회하면 모든 스프링 빈이 조회된다.
<br/>

# 스프링 빈
## 등록
![image](https://user-images.githubusercontent.com/95426849/174606491-8c2a5557-9109-47bc-bbc6-7b8ffe35d56d.png)
+ 설정 클래스에 담긴 정보를 이용하여 스프링 빈을 등록한다.
+ 빈 이름은 메서드 이름을 사용하거나 직접 부여할 수 있다.(`@Bean(name="userService2")`)
+ 빈 이름은 각각 달라야 한다. 같은 이름을 부여하면 다른 빈이 무시되거나, 기존 빈을 덮어버려 설정에 따라 오류가 발생한다.
<br/>

## 의존 관계 설정
![image](https://user-images.githubusercontent.com/95426849/174606974-e32ea534-d189-47ff-a4b4-1ae410f8fba0.png)
+ 스프링 컨테이너는 설정 정보를 참고하여 의존관계를 주입한다.
+ 자바 클래스로 스프링 빈을 등록하면 빈의 생성과 의존관계 주입이 한번에 처리된다. 원래는 단계가 나누어져 있다.
<br/>
<br/>

# BeanFactory & ApplicationContext
![image](https://user-images.githubusercontent.com/95426849/174609086-8c4c6384-702f-40d9-9f75-ab85d9f4642d.png)
<br/>

## BeanFactory
+ 스프링 컨테이너의 최상위 인터페이스이다.
+ 스프링 빈을 관리하고 조회하는 역할을 담당한다.
+ `getBean()`을 제공한다.
+ 자식 클래스인 ApplicationContext 덕분에 사용할 일이 거의 없다.
<br/>

## ApplicationContext
+ BeanFactory 기능을 모두 상속받아 제공한다.
+ 빈을 관리하고 조회하는 기능에 더해 수 많은 부가기능을 제공한다.
<br/>

### ApplicationContext가 제공하는 부가기능
![image](https://user-images.githubusercontent.com/95426849/174609511-b7b6ba53-d8f2-41db-aa6c-d099b0bafe61.png)
+ MessafeSource를 활용한 국제화 기능
 + 한국에서 들어오면 한국어로, 영어권에서 들어오면 영어로 출력
+ EnvironmentCapable
 + 로컬, 개발, 운영등을 구분해서 처리
+ ApplicationEventPublisher
 + 이벤트를 발생하고 구독하는 모델을 편리하게 지원
+ ResourceLoader
 + 파일, 클래스패스, 외부 등에서 리소스를 편리하게 조회
<br/>
<br/>

# 다양한 설정 형식 지원
![image](https://user-images.githubusercontent.com/95426849/174610104-4924d889-182e-4ac4-b543-2710050db8cb.png)
+ 스프링 컨테이너는 다양한 형식(자바 코드, XML, Groovy 등등)의 설정 정보를 받아드릴 수 있게 유연하게 설계되어 있다.
<br/>

## AnnotationConfigApplicationContext
+ `new AnnotationConfigApplicationContext(AppConfig.class)`
+ `AnnotationConfigApplicationContext`클래스를 사용하면서 자바 코드로 된 설정 정보를 넘기면 된다.
<br/>

## XML 설정 사용
+ 최근에는 스프링 부트를 사용하면서 XML 기반 설정은 잘 사용하지 않는다.
+ `GenericXmlApplicationContext`를 사용하면서 xml 설정 파일을 넘기면 된다.
<br/>

## 스프링 빈 설정 메타 정보
![image](https://user-images.githubusercontent.com/95426849/174611290-6b7e1f43-fd7e-416e-a2e4-1e9824591fcb.png)
![image](https://user-images.githubusercontent.com/95426849/174612331-ff0c0f91-a0ed-4b66-9f3e-8a4b110cf3a5.png)
+ 스프링이 다양한 설정 형식을 지원할 수 있는 이유는 역할과 구현을 개념적으로 나눴기 때문이다.
+ 역할 부여
 + 자바 코드나 XML을 읽어서 BeanDefinition을 생성한다.
 + `@bean`이나 `<bean>`당 하나씩 메타 정보를 생성한다.
+ 구현
 + 스프링 컨테이너는 어떤 걸로 만들어졌는지 몰라도 그냥 BeanDefinition을 읽으면 된다.
 + 스프링 컨테이너는 메타정보를 기반으로 스프링 빈을 생성한다.
<br/>

### BeanDefinition 정보
+ BeanClassName: 생성할 빈의 클래스 명
+ factoryBeanName: 팩토리 역할의 빈을 사용할 경우 이름, 예) appConfig
+ factoryMethodName: 빈을 생성할 팩토리 메서드 지정, 예) memberService
+ Scope: 싱글톤(기본값)
+ lazyInit: 스프링 컨테이너를 생성할 때 빈을 생성하는 것이 아니라, 실제 빈을 사용할 때까지 최대한 생성을 지연 처리 하는지 여부
+ InitMethodName: 빈을 생성하고, 의존관계를 적용한 뒤 호출되는 초기화 메서드 명 
+ DestroyMethodName: 빈의 생명주기가 끝나 제거하기 직전에 호출되는 메서드 명
+ Constructor arguments, Properties: 의존관계 주입에서 사용
