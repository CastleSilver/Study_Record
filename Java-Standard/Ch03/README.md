## ch03. 연산자
### 연산자와 피연산자
+ 연산자 : 연산을 수행하는 기호
+ 피연산자 : 연산자의 작업 대상
+ 연산자는 피연산자로 연산을 수행하고 나면 항상 결과값을 반환한다.
+ 작성한 식을 프로그램에 포함시키려면, 식의 끝에 ';'를 붙여서 문장으로 만들어야 한다.
### 연산자의 종류
+ 개수에 의한 분류 : 피연산자의 개수에 따라 단항, 이항, 삼항 연산자로 분류 된다.
### 연산자의 우선순위와 결합규칙
+ 단항 연산자가 이항 연산자보다 우선 순위가 높다.
+ 곱셈과 나눗셈이 덧셈과 뺄셈보다 우선순위가 높다.
+ 비교 연산자보다 산술연산자가 먼저 수행된다.
+ 논리 연산자보다 비교연산자가 먼저 수행된다.
+ 대입 연산자는 연산자 중에서 제일 우선순위가 낮다.
+ 논리 연산자 중에서 '&'와 '&&'가 '|'와 '||'보다 우선순위가 높다.

정리하자면 다음과 같다.

1. 산술 > 비교 > 논리 > 대입
2. 단항 > 이항 > 삼항
3. 단항 연산자와 대입 연산자를 제외한 모든 연산의 진행방향은 왼쪽에서 오른쪽이다.

### 산술 변환
피연산자의 타입이 서로 다르면 연산 전에 형변환 연산자로 타입을 일치시켜야 한다.

1. 두 피연산자의 타입을 같게 일치시킨다. (큰 타입으로 일치 시킨다.)
2. 피연산자의 타입이 int 보다 작은 타입이면 int로 변환된다.

<br/>

## 단항 연산자
### 증감 연산자
+ 증가 연산자( ++ ) : 피연산자의 값을 1 증가 시킨다.
+ 감소 연산자( -- ) : 피연산자의 값을 1 감소 시킨다.

증감 연산자는 두 가지 타입이 있다.
+ 전위형 : 값이 참조되기 전에 증감 시킨다.
+ 후위형 : 값이 참조된 후에 증감시킨다.

<br/>

## 산술 연산자
### 사칙 연산자
+ 곱셈, 나눗셈이 덧셈, 뺄셈보다 우선순위가 높다.
+ 피연산자가 정수형일 경우, 나누는 수로 0을 사용할 수 없다.
+ int형 끼리의 연산 결과 int 범위를 넘어가면 단순히 결과값을 long 변수에 담지 말고 계산 중간에 long으로 형변환을 해줘야 한다.
```java
long c = a * b;
long c = 1000000 * 2000000;
long c = -1454759936;

long c = (long) a * b;
long c = (long)1000000 * 2000000;
long c = 1000000L * 2000000;
long c = 1000000L * 2000000L;
long c = 2000000000000L;
```
+ 사칙연산자의 피연산자로 숫자뿐만 아니라 문자도 가능하다.
+ 문자를 숫자로 변환시키려면 '0'을 빼주면 된다.
```java
int a = '2' - '0';
int a = 2;
```
+ 상수 또는 리터럴 간의 연산은 실행 과정동안 변하는 값이 아니기 때문에, 컴파일 시에 컴파일러가 계산해서 그 결과로 대체한다. 컴파일러가 미리 덧셈연산을 수행하기 때문에 실행 시에는 덧셈 연산이 수행되지 않는다.
```java
# 컴파일 전
char c2 = 'a' + 1;
# 컴파일 후
char c2 = 'b';
# 컴파일 에러 발생
char c2 = c1 + 1;
# 컴파일 에러 없음
char c2 = 'a' + 1;
```

<br/>

## 비교 연산자
+ 문자열을 비교하고 싶을 땐 '=='대신 equals() 메서드를 사용한다.
+ 대소문자 비교 없이 구별하고 싶으면 equalsIgnoreCase()를 사용한다.

<br/>

## 논리 연산자

+ && 이 || 보다 우선순위가 높다.
+ ||의 경우에는 참일 가능성이 높은 것을 왼쪽에 놓으면 효율적이다.
+ ! 는 논리 부정 연산자로 true와 false를 반대로 바꾸는 것이다.

### 비트 연산자
+ | ( OR연산자 ) : 1이 하나라도 있으면 1을 결과로 얻는다. 
+ & ( AND연산자 ) : 모두 1이어야 1을 결과로 얻는다.
+ ^ ( XOR연산자 ) : 값이 서로 다를 때만 1을 결과로 얻는다.
+ ~ ( 전환연산자 ) : 0은 1로, 1은 0으로 바꾼다.
+ << >> ( 쉬프트연산자 ) : 자리이동으로 저장범위를 벗어난 값들은 버려지고 빈자리는 0으로 채워진다. 왼쪽 피연산자가 음수일 경우 빈자리는 1로 채운다.

<br/>

## 그 외 연산자
+ 삼항 연산자 : 조건식이 true면 식1을, false면 식2를 반환한다. 
```
조건식 ? 식1 : 식2
```
