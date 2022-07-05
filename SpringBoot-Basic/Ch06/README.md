# 컴포넌트 스캔
+ 컴포넌트 스캔을 사용하려면 `@ComponentScan`을 붙여주면 된다.
+ 컴포넌트 스캔은 `@Component` 가 붙은 클래스를 스캔해서 스프링 빈으로 등록한다. 이때 스프링 빈의 기본 이름은 클래스명을 사용하되 맨 앞글자만 소문자를 사용한다.
+ 이름을 직접 지정하고 싶으면 `@Comoponent` 옆에 붙이고 싶은 이름을 적어주면 된다.
+ `@Configuration`도 소스코드를 열어보면 `@Component`가 붙어있다.
+ 자동 스캔에서 제외하고 싶은 대상이 있다면 `excludeFilters`를 이용한다.
<br/>

## 의존관계주입
+ 이전에는 `@Bean`으로 설정 정보를 작성하고, 의존관계도 직접 명시했지만 이제는 의존관계 주입도 이 클래스 안에서 해결해야 한다.
+ `@Autowired`는 의존관계를 자동으로 주입해준다. 이때 기본 조회 전략은 타입이 같은 빈을 찾아서 주입한다.
<br/>

## 탐색위치와 기본 스캔 대상
### 탐색위치
+ 필요한 위치부터 탐색하도록 시작 위치를 지정할 수 있다.
+ basepackage : 탐색할 패키지의 시작 위치로 지정한다. 이 패키지를 포함한 하위 패키지를 모두 탐색한다.
+ basepackageClasses : 지정한 클래스의 패키지를 탐색 시작 위로 지정한다.
+ default : `@ComponentScan` 가 붙은 설정 정보 클래스의 패키지가 시작 위치가 된다.
+ 스프링 부트를 사용하면 스프링 부트의 대표 시작 정보인 `@SpringBootApplication`을 프로젝트 시작 루트 위치에 두는 것이 관례이다. 그리고 이 애노테이션 안에 `@ComponentScan`이 들어있다.
<br/>

### 스캔 기본 대상
+ `@Component`
+ `@Controller`
+ `@Service`
+ `@Repository`
+ `@Configuration`
<br/>

> 컴포넌트 스캔의 용도
> + `@Controller` : 스프링 MVC 컨트롤러로 인식
> + `@Service` : 특별한 기능이 없다. 개발자 간 편리를 위해 사용
> + `@Repository` : 스프링 데이터 접근 계층으로 인식하고, 데이터 계층의 예외를 스프링 예외로 변환해준다.
> + `@Configuration` : 스프링 설정 정보로 인식하고, 스프링 빈이 싱글톤을 유지하도록 추가 처리를 한다.
<br/>

## 필터
+ `includeFilters` 컴포넌트 스캔 대상을 추가로 지정
+ `excludeFilters` 컨포넌트 스캔에서 제외할 대상을 지정
<br/>

### FilterType 옵션
+ ANNOTATION : 기본값, 애노테이션을 인식해서 동작한다.
  + ex) org.example.SomeAnnotation
+ ASSIGNABLE_TYPE : 지정한 타입과 자식 타입을 인식해서 동작한다.
  + ex) org.example.SomeClass
+ ASPECTJ : AspectJ 패턴 사용
  + ex) org.example..*Service+
+ REGEX : 정규 표현식
  + ex) org\.example\.Default.*
+ CUSTOM : TypeFilter 이라는 인터페이스를 구현해서 처리
  + ex) org.example.MyTypeFilter
<br/>

## 중복 등록과 충돌
### 자동 빈 등록 vs 자동 빈 등록
+ 컴포넌트 스캔에 의해 자동으로 빈이 등록되는데, 그 이름이 같으면 오류(ConflictingBeanDefinitionException)가 일어난다.
<br/>

### 수동 빈 등록 vs 자동 빈 등록
+ 수동 빈 등록이 우선권을 가진다.(수동 빈이 자동 빈을 오버라이딩 함)
