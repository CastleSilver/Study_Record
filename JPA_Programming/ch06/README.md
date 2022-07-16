# 다양한 연관관계 매핑
## 다대일
+ 일과 다의 관계에서 연관관계의 주인은 항상 다쪽이다.
+ 양방향은 외래 키가 있는 쪽이 연관관계의 주인이다.
+ 양방향 연관관계는 항상 서로를 참조해야 한다.

## 일대다
+ 일대다 단반향 관계를 매핑할 때는 `@JoinColum`을 명시해야 한다.
+ 일대다 단방향 매핑의 단점은 매핑한 객체가 관리하는 외래 키가 다른 테이블에 있다는 점이다.
+ 다른 테이블에 외래 키가 있기에 연관관계 처리를 위한 UPDATE SQL을 추가로 실행해야 한다.
+ 일대다 단방향 매핑보다는 다대일 양방향 매핑을 사용하자

## 일대일
+ 일대일은 그 반대도 일대일 관계이다.
+ 일대일은 주 테이블이나 대상 테이블 둘 중 어느 곳이나 외래 키를 가질 수 있다.
+ 주 테이블에 외래키를 둬야 한다. 대상 테이블에 외래 키가 있는 단방향 관계는 JPA에서 지원하지 않는다.

## 다대다
+ 관계형 데이터베이스는 정규화된 테이블 2개로 다대다 관계를 표현할 수 없다.
+ 객체는 `@ManyToMany`를 사용해서 다대다 관계를 만들 수 있다.
+ 단순히 Id만 이용해서 연결테이블을 만들거면 따로 객체를 생성할 필요가 없지만, 그렇지 않다면 객체를 생성해야 한다.

### @JoinTable 속성
+ @JoinTable.name : 연결 테이블 지정. 여기서는 Member_Product 테이블을 선택함
+ @JoinTable.joinColumns: 현재 방향인 회원과 매핑할 조인 칼럼 정보를 지정
+ @JoinTable.inverseJoinColumns : 반대 방향인 상품과 매핑할 조인 칼럼 정보 지정

### 복합 기본 키
+ JPA에서 복합 키를 사용하려면 별도의 식별자 클래스를 만들어야 한다. 그리고 엔티티에 `@IdClass`를 사용해 식별자 클래스를 지정하면 된다.
+ 식별자 클래스는 다음의 특징을 지닌다.
  + Serializable을 구현해야 한다.
  + equals와 hashCode 메소드를 구현해야 한다.
  + 기본 생성자가 있어야 한다.
  + 식별자 클래스는 public이어야 한다.
  + `@IdClass`말고 `@EmbeddedId`를 사용하는 방법도 있다.

### 새로운 기본 키 사용
+ 데이터베이스에서 자동으로 생성해주는 대리 키를 사용하고 연결되는 id 값들은 외래 키로 사용한다