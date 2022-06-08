## 강의 목표
+ 순수 Java 코드로 회원 관리 시스템과 주문 시스템을 구축한다.
+ 설계 목표에 맞게 구현된 로직이 잘 작동하는지 JUnit을 이용해 Test 해본다.

## 설계
### 회원
+ 회원을 가입하고 조회할 수 있다.
+ 회원은 일반과 VIP 두 가지 등급이 있다.
+ 회원 데이터는 자체 DB를 구축할 수 있고, 외부 시스템과 연동할 수 있다. (미확정)
+ 회원 도메인 협력 관계
![image](https://user-images.githubusercontent.com/95426849/172660663-bdca0478-5ca4-445a-a358-175bb4e7649c.png)
+ 회원 클래스 다이어그램
![image](https://user-images.githubusercontent.com/95426849/172660722-1684a4f7-8750-463a-93d7-801f71e817b5.png)
+ 회원 객체 다이어그램
![image](https://user-images.githubusercontent.com/95426849/172660753-ac24ff60-25b6-46d9-bc4b-24f82de20fbb.png)

### 주문과 할인 정책
+ 회원은 상품을 주문할 수 있다.
+ 회원 등급에 따라 할인 정책을 적용할 수 있다.
+ 할인 정책은 모든 VIP는 1000원을 할인해주는 고정 금액 할인을 적용해달라. (나중에 변경 될 수 있다.)
+ 할인 정책은 변경 가능성이 높다. 회사의 기본 할인 정책을 아직 정하지 못했고, 오픈 직전까지 고민을 미루고 싶다. 최악의 경우 할인을 적용하지 않을 수 도 있다. (미확정)
+ 주문 도메인 협력, 역할, 책임
![image](https://user-images.githubusercontent.com/95426849/172661116-abdf256b-f29f-4330-87ed-00e76916a445.png)
+ 주문 도메인 전체
![image](https://user-images.githubusercontent.com/95426849/172661165-10507c19-2a6b-49ac-bc29-0c487dacddb4.png)
+ 주문 도메인 클래스 다이어그램
![image](https://user-images.githubusercontent.com/95426849/172661201-2a83d7cf-7002-4574-80b8-6a0a1d628283.png)
+ 주문 도메인 객체 다이어그램1
![image](https://user-images.githubusercontent.com/95426849/172661283-1f1f1891-c22a-4fcf-b8a3-4b0a88a9832c.png)
+ 주문 도메인 객체 다이어그램2
![image](https://user-images.githubusercontent.com/95426849/172661350-a51c2f33-1415-45c0-b363-5f6af5ca49dd.png)

## 설계 문제점
+ OCP 원칙을 준수하고 있지 않다. => 다른 저장소로 이동할 때 손쉽게 변경이 가능하다 ~(사실 이 부분이 잘 이해가 가지 않음.. 나중에 구현하면서 문제점을 짚어주신다고 하니 그때 잘 봐야 할듯)~
+ DIP 원칙을 지키고 있지 않다. => 한 클래스가 인터페이스 뿐만 아니라 구현체까지도 의존을 하고 있다.
