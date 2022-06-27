# 컨테이너 초기화와 종료
+ 스프링 컨테이너는 설정 클래스에서 정보를 읽어와 알맞은 빈 객체를 생성하고 각 빈을 연결(의존 주입)하는 작업을 수행한다.
+ 생성자(ex. `AnnotaionConfigApplicationContext`)를 이용해서 컨텍스트 객체를 생성할 때 스프링 컨테이너가 초기화된다.
+ 컨테이너 초기화가 완료되면 컨테이너를 사용할 수 있다. 컨테이너를 사용하는 것은 `getBean()`과 같은 메서드를 이용해서 컨테이너에 보관된 빈 객체를 구한다는 것을 의미한다. 
+ 컨테이너 사용이 끝나면 컨테이너를 종료한다.
+ 컨테이너를 초기화하고 종료할 때는 다음 작업도 함께 수행된다.
  + 초기화 : 빈 객체의 생성, 의존 주입, 초기화
  + 종료 : 빈 객체의 소멸
  
# 스프링 빈 객체의 라이프사이클
![](https://velog.velcdn.com/images/aysel0230/post/ac5f85ca-e479-4ee9-8d25-b7c4d4eabc0d/image.png)
+ 스프링 컨테이너가 초기화될 때 스프링 컨테이너는 빈 객체를 생성하고 의존을 설정한다.
+ 의존 설정이 완료되면 빈 객체의 초기화가 수행된다.
+ 스프링 컨테이너가 종료되면 빈 객체가 소멸된다.

## 빈 객체의 초기화와 소멸
### 스프링 인터페이스
+ 초기화 인터페이스 : import org.springframework.beans.factory.InitializingBean
+ 소멸 인터페이스 : import org.springframework.beans.factory.DisposableBean
+ 초기화 인터페이스를 구현하면 스프링 컨테이너는 초기화 과정에서 `afterPropertiesSet()`메서드를 실행한다.
+ 소멸 인터페이스를 구현하면 소멸과정에서 `destroy()` 메서드를 실행한다.

### 커스텀 메서드
+ 인터페이스를 사용하고 싶지 않거나 사용할 수 없을 때에는 커스텀 메서드를 사용할 수 있다.
+ @Bean 태그에서 `initMethod` 속성이나 `destroyMethod` 속서을 사용해서 초기화 메서드와 소멸 메서드의 이름을 설정하면 된다.
+ 이때 호출되는 메서드에는 파라미터가 있으면 안된다.

# 빈 객체의 생성과 관리 범위
+ 스프링 컨테이너에 의해 설정된 빈은 싱글톤 범위를 갖지만 예외를 줄 수 있다.
+ 프로토타입 범위의 빈을 설정하면 빈 객체를 구할 때마다 매번 새로운 객체를 생성한다.
+ 빈을 설정할 때 `@Scope("prototype")`을 추가하면 된다.
+ 프로토타입 범위의 빈은 완전한 라이프사이클을 따르지 않기 때문에 소멸 처리를 직접 처리해야 한다.
+ 싱글톤 범위를 명시하고 싶을 때는 `@Scope("singleton")`를 사용한다.
