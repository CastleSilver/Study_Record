# JPA 소개
## SQL을 직접 다룰 때 발생하는 문제점
+ 객체를 데이터베이스에 CRUD 할때 너무 많은 SQL문을 작성해야 한다.
+ 수정이 용이하지 않다.
+ SQL에 의존적인 개발을 하게 된다.
+ JPA를 사용하면 개발자가 직접 SQL을 다룰 필요 없이 JPA가 제공하는 API를 사용하면 된다.

## 패러다임의 불일치
+ 객체와 관계형 데이터베이스는 지향하는 목적이 다르므로 둘의 기능과 표현 방법도 다르다. 이를 객체와 관계형 데이터베이스의 패러다임 불일치 문제라 한다.
+ 상속 : 객체에는 상속이 있으나 데이터베이스에는 상속이 없다. 그러나 JPA는 상속받은 객체를 저장하면 되기에 이러한 패러다임의 불일치 문제를 해결해준다.
+ 참조 : 객체 모델은 외래키가 필요 없고 참조만 있으면 되지만 테이블은 참조가 필요 없고 외래 키만 있으면 된다. 따라서 개발자가 중간에 변환 역할을 해줘야 한다. JPA는 개체의 참조를 외래키로 변환해서 적절한 SQL문을 데이터베이스에 전달해주기에 이를 해결해준다.
+ 객체 그래프 탐색 : SQL을 직접 다루면 처음 실행하는 SQL에 따라 객체 그래프를 어디까지 탐색할 수 있는지가 정해진다. 그러나 JPA를 사용하면 객체 그래프를 마음껏 탐색할 수 있다.

## JPA란 무엇인가?
+ JPA(Java Persistence API)는 자바 진영의 ORM 기술 표준이다. JPA는 애플리케이션과 JDBC 사이에서 동작한다.
![](https://velog.velcdn.com/images/aysel0230/post/4fe85eff-881a-4e9e-a4b5-ec5961fe15b1/image.png)
+ ORM(Object-Relational Mapping)은 객체와 관계형 데이터베이스를 매핑한다는 의미이다. ORM 프레임 워크는 객체와 테이블을 매핑해서 패러다임의 불일치 문제를 개발자 대신 해결해준다. 따라서 객체 측면에서는 정교한 객체 모델링이 가능하고 관계형 데이터베이스는 데이터베이스에 맞도록 모델링을 할 수 있다. 그리고 둘을 어떻게 매핑할지만 ORM 프레임워크에게 알려주면 된다.
+ JPA를 사용하면 생산성, 유지보수, 패러다임의 불일치 해결, 성능, 데이터 접근 추상화의 장점이 있다.
