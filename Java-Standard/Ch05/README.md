# 배열
## 배열이란?
+ 같은 타입의 여러 변수를 하나의 묶음으로 다루는 것
+ 서로 다른 타입의 변수들로 구성된 배열은 만들 수 없다.
+ 각 저장공간이 연속적으로 배치되어 있다.

## 배열의 선언과 생성
### 선언
```
1. 타입[] 변수이름;
2. 타입 변수이름[];
```
### 생성
```
변수이름 = new 타입[길이];
```
+ 선언은 단지 생성된 배열을 다루기 위한 참조변수를 위한 공간이 만들어지는 것이고, 배열을 생성해야만 값을 저장할 수 있는 공간이 만들어진다.
+ 배열을 생성하기 위해서는 연산자 'new'와 함게 배열의 타입과 길이를 지정해야 한다.
### 변수 타입별 기본값
|자료형|기본값|
|:---:|:----:|
|boolean|false|
|char|`'\n0000'`|
|byte, short, int|0|
|long|0L|
|float|0.0f|
|double|0.0|
|참조형 변수|null|
## 배열의 길이와 인덱스
### 인덱스(index)
+ 인덱스의 범위는 0부터 '배열길이 -1' 까지이다.
+ 인덱스로 상수 대신 변수나 수식도 사용할 수 있다.
+ 인덱스의 범위를 벗어난 값을 인덱스로 사용하면 에러(ArrayIndexOutOfBoundsException)가 발생한다.

### 길이
+ 배열의 길이는 양의 정수여야 하고 최대값은 int타입의 최대값, 약 20억이다.
+ 길이가 0인 배열도 생성 가능하다.
+ `배열이름.length`를 통해 배열의 길이에 대한 정보를 얻을 수 있다.
+ 배열은 한 번 생성하면 길이를 변경할 수 없다.
+ 배열의 길이를 변경하려면 더 큰 길이의 새로운 배열을 생성한 다음, 기존의 배열에 저장된 값들을 새로운 배열에 복사하면 된다.

## 배열의 초기화와 출력
### 초기화
```java
int[] nums = new int[]{ 1, 2, 3, 4, 5};
int[] nums = { 1, 2, 3, 4, 5}; // new int[] 생략 가능

// 배열의 선언과 생성을 따로 하는 경우에는 생략할 수 없다.
int[] nums;
nums = new int[]{ 1, 2, 3, 4, 5};
nums = { 1, 2, 3, 4, 5}; // 에러 발생
```

### 출력
1. for문을 이용해서 하나씩 꺼내기
2. `Arrays.toString(배열이름)` 이용하기. `[첫번째요소, 두번째요소, ...]` 형식으로 출력된다.

+ 만약 배열이름의 값을 바로 출력하게 되면 `타입@주소`가 출력된다.
+ 예외적으로 char 배열은 각 요소가 구분자없이 그대로 출력된다.
```java
char[] char = {'a', 'b', 'c', 'd'};
System.out.println(char); // abcd
```
## 배열의 복사
### for문을 이용해서 복사
```java
int[] arr = new int[5];

int[] tmp = new int[arr.length * 2]; // 기존 배열보다 넉넉하게 생성
for(int i = 0 ; i < arr.length; i++) {
	tmp[i] = arr[i]; // arr[i]의 값을 tmp[i]에 저장
}
arr = tmp; // 참조변수 arr이 새로운 변수를 가르키게 한다.
```

### `System.arraycopy()`를 이용해서 복사
```java
//System.arraycopy(기존배열이름, 기존 배열 시작 인덱스, 옮길배열이름, 옮길 배열 시작 인덱스, 복사할 개수)
System.arraycopy(num, 0, newNum, 0, num.length);
```

## 배열의 활용
### 로또 번호 생성
```java
class Lotto { 
	public static void main(String[] args) { 
		// 45개의 정수값을 저장하기 위한 배열 생성. 
		int[] ball = new int[45];       

		// 배열의 각 요소에 1~45의 값을 저장한다. 
		for(int i=0; i < ball.length; i++)       
			ball[i] = i+1;    // ball[0]에 1이 저장된다.

		int temp = 0;  // 두 값을 바꾸는데 사용할 임시변수 
		int j = 0;     // 임의의 값을 얻어서 저장할 변수 

		// 배열의 i번째 요소와 임의의 요소에 저장된 값을 서로 바꿔서 값을 섞는다. 
		// 0번째 부터 5번째 요소까지 모두 6개만 바꾼다.
		for(int i=0; i < 6; i++) {       
			j = (int)(Math.random() * 45); // 0~44범위의 임의의 값을 얻는다. 
			temp     = ball[i]; 
			ball[i] = ball[j]; 
			ball[j] = temp; 
		} 

		// 배열 ball의 앞에서 부터 6개의 요소를 출력한다.
		for(int i=0; i < 6; i++) 
			System.out.printf("ball[%d]=%d%n", i, ball[i]); 
	} 
} 
```
### 버블 정렬
```java
class BubbleSort {
	public static void main(String[] args) {
		int[] numArr = new int[10];

		for (int i=0; i < numArr.length ; i++ ) {
			System.out.print(numArr[i] = (int)(Math.random() * 10));
		}
		System.out.println();

		for (int i=0; i < numArr.length-1 ; i++ ) {
			boolean changed = false;	// 자리바꿈이 발생했는지를 체크한다.

			for (int j=0; j < numArr.length-1-i ;j++) {
				if(numArr[j] > numArr[j+1]) { // 옆의 값이 작으면 서로 바꾼다.
					int temp = numArr[j];
					numArr[j] = numArr[j+1];
					numArr[j+1] = temp;
					changed = true;	// 자리바꿈이 발생했으니 changed를 true로.
				}
			} // end for j

			if (!changed) break;	// 자리바꿈이 없으면 반복문을 벗어난다.

			for(int k=0; k<numArr.length;k++)
				System.out.print(numArr[k]); // 정렬된 결과를 출력한다.
			System.out.println();
		} // end for i
	} // main의 끝
}
```
### Count 배열
```java
class CountArr {
	public static void main(String[] args) {
		int[] numArr  = new int[10];
		int[] counter = new int[10];

		for (int i=0; i < numArr.length ; i++ ) {
			numArr[i] = (int)(Math.random() * 10); // 0~9의 임의의 수를 배열에 저장
			System.out.print(numArr[i]);
		}
		System.out.println();

		for (int i=0; i < numArr.length ; i++ ) {
			counter[numArr[i]]++;
		}

		for (int i=0; i < numArr.length ; i++ ) {
			System.out.println( i +"의 개수 :"+ counter[i]);
		}
	} // main의 끝
}
```

<br/>

# String 배열
## String 배열의 선언과 생성
+ int 배열의 선언, 생성방법과 다르지 않다.

## String 배열의 초기화
+ String 배열의 경우 배열에 저장되는 것은 객체의 주소이다.

## String 배열과 Char 배열
+ String 배열은 char 배열에 기능(메서드)를 추가한 것이다.
#### String 클래스의 주요 메서드
|메서드|설명|
|:----:|:---:|
|char charAt(int index)|문자열에서 해당 인덱스에 있는 문자를 반환한다.|
|int length()|문자열의 길이를 반환한다.|
|String substring(int from, int to)|문자열에서 해당 범위에 있는 문자열을 반환한다.(to는 범위에 포함되지 않는다)|
|boolean equals(Object obj)|문자열의 내용이 obj와 같은지 확인한다. 같으면 결과는 true, 다르면 false(대소문자를 구분하지 않고 비교하려면 `equalsIgnoreCase()`를 사용해야 한다.|
|char[] toCharArray()|문자열을 문자배열로 변환해서 반환한다.|
+ String 객체(문자열)는 읽을 수만 있을 뿐 내용을 변경할 수 없다.
+ 변경되는 것 처럼 보여도 새로운 내용의 문자열이 생성된 것이다.
+ 변경 가능한 문자열을 다루려면 `StringBuffer`클래스를 사용하면 된다.

### char 배열 -> String
```java
String str = new String(chArr);
```
## 커맨드 라인을 통해 입력 받기
+ 커맨드 라인을 통해 입력된 두 문자열은 String배열에 담겨서 MainTest클래스의 main메서드의 매개변수(args)에 전달된다.

<br/>

# 다차원 배열
## 2차원 배열의 선언과 인덱스
### 선언
```
1. 타입[][] 변수이름;
2. 타입 변수이름[][];
3. 타입[] 변수이름[];
```
### 인덱스
```
배열이름[행idx][열idx];
```
## 2차원 배열의 초기화
```java
int[][] arr = new int[][]{{1,2,3},{4,5,6}};
int[][] arr = {{1,2,3},{4,5,6}};
```
+ `arr.length`의 값은 arr의 행의 개수인 2이다.
+ 행의 개수는 `arr[0].length` 나 `arr[1].length`로 구할 수 있다.

## 가변 배열
+ 2차원 이상의 다차원 배열을 생성할 때 전체 배열 차수 중 마지막 차수의 길이를 지정하지 않고, 추후에 각기 다른 길이의 배열을 생성함으로써 고정된 형태가 아닌 보다 유동적인 가변 배열을 구성할 수 있다.
```java
// 예
int[][] arr = new int[3][];
arr[0] = new int[4];
arr[1] = new int[2];
arr[2] = new int[3];
```
