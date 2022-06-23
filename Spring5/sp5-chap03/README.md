# 학습 목표
+ 메이븐과 그레이들을 이용해 프로젝트 생성하기
<br/>

# 메이븐 프로젝트
## 메이븐 의존 설정
```
# 예제
<dependency>
  <groupId>org.springframework</groupId>
  <artifactId>spring-context</artifactId>
  <version>5.0.2.RELEASE</version>
</dependency>
```
+ 메이븐은 한 개의 모듈을 아티팩트라는 단위로 관리
+ spring-context라는 식별자를 가진 5.0.2.RELEASE 버전의 아티팩트에 대한 의존을 추가한 것
+ 의존을 추가한다는 것은 일반적인 자바 어플리케이션에서 클래스 패스에 spring-context 모듈을 추가한다는 것을 의미
+ 각 아티팩트의 이름은 `아티팩트이름-버전.jar`이다.

## 메이븐 리포지토리
+ 메이븐은 코드를 컴파일하거나 실행할 때 <dependency>로 설정한 아티팩트 파일을 사용
+ 메이븐 로컬 레포에서 `[그룹ID]/[아티팩트ID]/[버전]` 폴더에 `아티팩트ID-버전.jar` 형식의 이름을 갖는 파일이 있는지 검사. 있으면 이 파일을 사용
+ 로컬 레포에 파일이 없으면 메이븐 원격 중앙 리포지토리로부터 해당 파일을 다운하여 로컬 레포에 복사한 뒤 그 파일을 사용한다.
+ 기본적으로 `/.m2/repository` 가 로컬 레포로 사용된다
+ 다운 받으려는 아티팩트가 의존하고 있는 아티팩트가 있으면 그것도 다운 받고 그 아티팩트가 의존하는 아티팩트도 있으면 그것도 다운받고 또...
+ 이렇게 의존대상이 다시 의존하는 대상까지 의존 대상에 포함하기 때문에 이를 의존 전의(Transitive Dependencies)라고 한다.

## 기본 폴더 구조
+ `src\main\java` : 자바 소스 코드 위치
+ `src\main\resources` : 자바 소스 코드 외의 다른 자원 파일 위치
+ `src\main\webapp` : 웹 어플리케이션 기준 폴더. 이 폴더를 기준으로 JSP 소스 코드나 WEB-INF\web.xml 파일등을 작성한다.

# 그레이들 프로젝트
+ 메이븐과 크게 다르지 않으나, `pom.xml` 대신 `build.gradle`을 사용한다.
