# 엔티티 매핑
## @Entity
JPA를 사용해서 테이블과 매핑할 클래스는 @Entity 어노테이션을 붙여야 한다.

### @Entity 속성
+ name
  + 기능 : JPA에서 사용할 엔티티의 이름을 지정한다.
  + 기본값 : 설정하지 않으면 클래스 이름을 그대로 사용한다.
  
### @Entity 적용 시 주의사항
+ 기본 생성자는 필수다.
+ final 클래스, enum, interface, inner 클래스에는 사용할 수 없다.
+ 저장할 필드에 final을 사용하면 안된다.

## @Table
엔티티와 매핑할 테이블을 지정한다.

### @Table 속성
+ name
  + 기능 : 매핑할 테이블 이름
  + 기본값 : 엔티티 이름을 사용한다.
+ catalog
  + 기능 : catalog 기능이 있는 데이터베이스에서 catalog를 매핑한다.
+ schema
  + 기능 : schema 기능이 있는 데이터베이스에서 schema를 매핑한다.
+ uniqueConstraint
  + 기능 : DDL 생성 시 유니크 제약조건을 만든다. 이 기능은 스키마 자동 생성 기능을 사용해 DDL을 만들 때만 사용된다.

## 다양한 매핑 사용
+ @Enumerated : 자바의 enum을 사용해 매핑해야 할 때 사용한다.
+ @Temporal : 자바의 날짜 타입을 매핑할 때 사용한다.
+ @Lob : DB의 CLOB, BLOB 타입을 매핑할 때 사용한다.

## 데이터베이스 스키마 자동 생성
스키마 자동 생성 기능을 사용하려면 `persistence.xml`에 ` <property name="hibernate.hbm2ddl.auto" value="create" />` 을 추가한다. 이것을 추가하면 애플리케이션 실행 시점에 데이터베이스 테이블을 자동으로 생성한다. 스키마 자동 생성 기능을 사용하면 편리하지만 스키마 자동 생성 기능이 만든 DDL은 운영 환경에서 사용할 만큼 완벽하진 않기에 참고 정도로만 사용하면 된다.

### hibernate.hbm2ddl.auto 속성
+ create : 기존 테이블을 삭제하고 새로 생성한다. DROP + CREATE
+ create-drop : create 속성에 추가로 애플리케이션을 종료할 때 생성한 DDL을 제거한다. DROP + CREATE + DROP
+ update : 데이터베이스 테이블과 엔티티 매핑정보를 비교해 변경 사항만 수정한다.
+ validate : 데이터베이스 테이블과 엔티티 매핑정보를 비교해서 차이가 있으면 경고를 남기고 애플리케이션을 실행하지 않는다. DDL은 수정하지 않는다. 

> `<property name="hibernate.ejb.naming_strategy" value="org.hibernate.cfg.ImprovedNamingStrategy" />` 를 사용하면 자바의 카멜 표기법을 테이블의 언더스코어 표기법으로 자동으로 변경한다.

## DDL 생성 기능
### 제약 조건 추가
```java
@Column(name = "NAME", nullable = false, length = 10)
```
+ nullable = false : not null 제약 조건
+ length : 문자 크기 지정
```java
@Table(name="MEMBER", uniqueConstraints = {@UniqueConstraint( //추가 //**
        name = "NAME_AGE_UNIQUE",
        columnNames = {"NAME", "AGE"} )})
```
+ 유니크 제약 조건을 추가한다.

위 제약조건들은 단지 DDL을 자동 생성할 때만 사용되고 JPA의 실행 로직에는 영향을 주지 않는다. 따라서 스키마 자동 생성 기능을 사용하지 않고 직접 DDL을 만든다면 사용할 이유가 없다.

## 기본 키 매핑
+ 직접 할당 : 기본 키를 애플리케이션에서 직접 할당한다.`@Id`만 사용하면 된다.
+ 자동 생성 : 대리 키 사용 방식이다. `@Id`에 `@GeneratedValue`를 추가하고 원하는 키 생성 전략을 선택하면 된다. 키 생성 전략을 사용하려면 persistence.xml에 ` <property name="hibernate.id.new_generator_mappings" value="true" />`을 추가해야 한다.
  + IDENTITY : 기본 키 생성을 데이터베이스에 위임한다.
  + SEQUENCE : 데이터베이스 시퀀스를 사용해서기본 키를 할당한다.
  + TABLE : 키 생성 테이블을 사용한다.
  
### 직접 할당 전략 
`@Id`로 매핑하면 된다. `persist()`로 엔티티를 저장하기 전에 애플리케이션에서 기본 키를 직접 할당하는 방법이다. 식별자 값 없이 저장하면 예외가 발생한다.
#### 적용 가능 자바 타입
+ 자바 기본형
+ 자바 래퍼(Wrapper)형
+ String
+ java.util.Date
+ java.sql.Date
+ java.math.BigDecimal
+ java.math.BigInteger

### IDENTITY 전략
기본 키 생성을 데이터베이스에 위임하는 전략이다. 주로 MySQL, PostgreSQL, SQL Server, DB2에서 사용한다. 데이터베이스에 값을 저장할 때 ID 컬럼을 비워두면 데이터베이스가 순서대로 값을 채워준다. 이 전략은 `persist()`를 호출하는 즉시 INSERT SQL이 데이터베이스에 전달된다. 즉 먼저 엔티티를 데이터베이스에 저장한 후에 식별자를 조회해서 엔티티의 식별자이ㅔ 할당한다.

### SEQUENCE 전략
유일한 값을 순서대로 생성하는 특별한 데이터베이스 오브젝트인 시퀀스를 사용해서 기본 키를 생성하는 전략이다. 주로 오라클, PostgreSQL, DB2, H2에서 사용한다. 이 전략은 `persist()`를 호출할 때 먼저 데이터베이스 시퀀스를 사용해서 식별자를 조회한다. 그리고 조회한 식별자를 엔티티에 할당한 후에 엔티티를 영속성 컨텍스트에 저장한다. 이후 트랜잭션을 커밋해서 플러시가 일어나면 엔티티를 데이터베이스에 저장한다.
#### @SequenceGenerator 속성
+ name
  + 기능 : 식별자 생성기 이름
  + 기본값 : 필수
+ sequenceName
  + 기능 : 데이터베이스에 등록되어 있는 시퀀스 이름
  + 기본값 : hibernate_sequence
+ initialValue
  + 기능 : DDL 생성 시에만 사용됨, 시퀀스 DDL을 생성할 때 처음 시작하는 수를 지정한다.
  + 기본값 : 1
+ allocationSize
  + 기능 : 시퀀스 한 번 호출에 증가하는 수(성능 최적화에 사용됨)
  + 기본값 : 50
+ catalog, schema
  + 기능 : 데이터베이스 catalog, schema 이름

### TABLE 전략
키 생성 전용 테이블을 하나 만들고 여기에 이름과 값으로 사용할 칼럼을 만들어 데이터베이스 시퀀스를 흉내내는 전략이다. 이 전략은 테이블을 사용하므로 모든 데이터베이스에 적용할 수 있다.

#### @TableGenerator 속성
+ name
  + 기능 : 식별자 생성기 이름
  + 기본값 : 필수
+ table
  + 기능 : 키생성 테이블명
  + 기본값 : hibernate_sequences
+ pkColumnName
  + 기능 : 시퀀스 컬럼명
  + 기본값 : sequence_name
+ valueColumnName
  + 기능 : 시퀀스 값 컬럼명
  + 기본값 : next_val
+ pkColumnValue
  + 기능 : 키로 사용할 값 이름
  + 기본값 : 엔티티 이름
+ initialValue
  + 기능 : 초기 값, 마지막으로 생성된 값이 기준이다.
  + 기본값 : 0
+ allocationSize
  + 기능 : 시퀀스 한 번 호출에 증가하는 수(성능 최적화에 사용됨)
  + 기본값 : 50
+ catalog, schema
  + 기능 : 데이터베이스 catalog, schema 이름
+ uniqueConstraints(DDL)
  + 기능 : 유니크 제약 조건을 지정할 수 있다.

### AUTO 전략
선택한 데이터베이스 방언에 따라 IDENTITY, SEQUENCE, TABLE 전략 중 하나를 자동으로 선택한다. 데이터베이스를 병경해도 코드를 수정할 필요가 없다는 장점이 있다. 

### 기본 키 매핑 정리
+ 직접할당 : `persist()`를 호출하기 전에 애플리케이션에서 직접 식별자 값을 할당해야 한다.
+ SEQUENCE : 데이터베이스 시퀀스에서 식별자 값을 획득한 후 영속성 컨텍스트에 저장한다.
+ TABLE : 데이터베이스 시퀀스 생성용 테이블에서 식별자 값을 획득한 후 영속성 컨텍스트에 저장한다.
+ IDENTITY : 데이터베이스에 엔티티를 저장해서 식별자 값을 획득한 후 영속성 컨텍스트에 저장한다.

## 필드와 컬럼 매핑: 레퍼런스
![](https://velog.velcdn.com/images/aysel0230/post/4cb4ad16-6983-4be9-bed4-77666b7a402d/image.png)
### @Column
![](https://velog.velcdn.com/images/aysel0230/post/1369c19a-1cf5-4b5d-8d3c-ebbb921ab965/image.jpg)

### @Enumerated
![](https://velog.velcdn.com/images/aysel0230/post/935fa159-f77d-478e-86ce-920da7b3893f/image.png)
+ EnumType.ORDINAL : enum에 정의된 순서대로 0부터 값이 매겨저 DB에 저장된다.
  + 장점 : DB에 저장된 데이터 크기가 작다.
  + 단점 : 이미 저장된 enum의 순서를 변경할 수 없다.

+ EnumType.STRING : enum 이름 그대로 DB에 저장된다.
  + 장점 : 저장된 enum의 순서가 바뀌거나 값이 추가되어도 안전하다.
  + 단점 : DB에 저장되는 크기가 ORDINAL 보다 크다.
  
### @Temporal
날짜 타입을 매핑할 때 사용한다.
![](https://velog.velcdn.com/images/aysel0230/post/ef2889a5-1d45-4e13-8280-39969d1d2644/image.png)

### @Lob
데이터베이스 BLOB, CLOB 타입과 매핑한다. 매핑하는 필드 타입이 문자면 CLOB로 매핑하고 나머지는 BLOB으로 매핑한다.

### @Transient
이 필드는 매핑하지 않는다. DB에 저장, 조회하지도 않는다. 객체에 임시로 어떤 값을 보관하고 싶을 때 사용한다.

### @Access
JPA가 엔티티 데이터에 접근하는 방식을 지정한다. 이 어노테이션을 사용하지 않으면 @Id의 위치를 기준으로 접근 방식이 설정된다.
+ AccessType.FIELD : 필드에 직접 접근한다.
+ AccessType.PROPERTY : 프로퍼티에 접근한다. 접근자(Getter)를 사용한다.
