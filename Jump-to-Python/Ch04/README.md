## 함수
### 함수의 구조
```
def 함수명(매개변수):
    <수행할 문장1>
    <수행할 문장2>
    ...
    return 결과값
```
+ 매개변수는 생략 가능하다.
+ 매개변수는 여러개가 입력될 수 있다.
+ 결과값은 생략 가능하다.
+ return을 만나면 함수를 빠져나온다.
+ 함수 안에서 선언한 매개변수는 함수 안에서만 사용될 뿐 함수 밖에서는 사용되지 않는다.

### 매개변수 지정해서 호출하기
```py
>>> result = add(b=5, a=3)  # b에 5, a에 3을 전달
>>> print(result)
8
```
+ 매개변수를 지정해서 호출하면 순서에 상관없이 호출 가능하다.

### 매개변수 불특정
```
def 함수이름(*매개변수): 
    <수행할 문장>
    ...
```
+ 매개변수가 몇개일지 모를 때는 위와 같이 사용하면 된다.
```py
# 예제
>>> def add_many(*args): 
...     result = 0 
...     for i in args: 
...         result = result + i 
...     return result 
... 
>>>
>>> result = add_many(1,2,3)
>>> print(result)
6
```
### 키워드 파라미터
```py
>>> def print_kwargs(**kwargs):
...     print(kwargs)
...
```
+ 딕셔너리 형태로 저장이 된다.
```py
# 예제
>>> print_kwargs(a=1)
{'a': 1}
>>> print_kwargs(name='foo', age=3)
{'age': 3, 'name': 'foo'}
```
### 결과값을 여러개 줄 경우
```py
>>> def add_and_mul(a,b): 
...     return a+b, a*b

>>> result = add_and_mul(3,4)
result = (7, 12)

>>> result1, result2 = add_and_mul(3, 4)
result1, result2 = (7, 12)
```
+ 결과값을 여러개 주면 튜플 형식으로 출력이 되고, 결과 별수를 여러개 주면 그 변수에 값이 하나씩 저장이 된다.

### 매개변수 초기화
```py
def say_myself(name, old, man=True): 
    print("나의 이름은 %s 입니다." % name) 
    print("나이는 %d살입니다." % old) 
    if man: 
        print("남자입니다.")
    else: 
        print("여자입니다.")
```
+ 매개변수를 초기화해서 사용할 수 있다.
+ 초깃값을 설정해 놓은 매개변수 뒤에 초깃값을 설정해 놓지 않은 매개변수는 사용할 수 없다.

### global 변수
```py
# vartest_global.py
a = 1 
def vartest(): 
    global a 
    a = a+1

vartest() 
print(a)
```
+ global을 사용하면 함수 밖 변수를 사용할 수 있다.

### lambda
```
lambda 매개변수1, 매개변수2, ... : 매개변수를 이용한 표현식
```
+ def와 동일한 역할을 한다.
+ 한 줄로 간결하게 함수를 사용할 때 쓰인다.
```py
# 예제
>>> add = lambda a, b: a+b
>>> result = add(3, 4)
>>> print(result)
7
```

<br/>

## 사용자 입력과 출력
### 사용자 입력(input)
```py
>>> a = input()
Life is too short, you need python
>>> a
'Life is too short, you need python'
>>>
```
+ 입력되는 값을 문자열로 취급한다.
+ input("질문내용")을 추가할 수 있다.

### 출력(print)
#### 큰따옴표(")로 둘러싸인 문자열은 + 연산과 동일하다
```py
>>> print("life" "is" "too short") # ①
lifeistoo short
>>> print("life"+"is"+"too short") # ②
lifeistoo short
```
#### 문자열 띄어쓰기는 콤마로 한다
```py
>>> print("life", "is", "too short")
life is too short
```
#### 한 줄에 결괏값 출력하기
```py
>>> for i in range(10):
...     print(i, end=' ')
...
0 1 2 3 4 5 6 7 8 9
```
+ 한 줄에 결괏값을 계속 이어서 출력하려면 매개변수 end를 사용해 끝 문자를 지정해야 한다.

<br/>

## 파일 읽고 쓰기
### 파일 생성하기
```
파일 객체 = open(파일 이름, 파일 열기 모드)
```

|파일열기모드|설명|
|:--:|:--:|
|r|읽기모드 - 파일을 읽기만 할 때 사용|
|w|쓰기모드 - 파일에 내용을 쓸 때 사용|
|a|추가모드 - 파일의 마지막에 새로운 내용을 추가 시킬 때 사용|

```py
f = open("C:/doit/새파일.txt", 'w')
for i in range(1, 11):
    data = "%d번째 줄입니다.\n" % i
    f.write(data)
f.close()
```
+ 디렉토리 위치를 지정해주지 않는다면 프로그램을 실행한 디렉터리에 새로운 파일이 하나 생성된다.
+ write 메서드를 쓰면 파일에 쓸 수 있다.

### 프로그램의 외부에 저장된 파일을 읽는 방법
#### readline
```py
f = open("C:/doit/새파일.txt", 'r')
line = f.readline()
print(line)
f.close()
```
+ 한 줄만 출력한다.
+ 여러줄을 출력하고 싶으면 반복문을 사용해야 한다.
```py
f = open("C:/doit/새파일.txt", 'r')
while True:
    line = f.readline()
    if not line: break
    print(line)
f.close()
```

#### readlines

```py
f = open("C:/doit/새파일.txt", 'r')
lines = f.readlines()
for line in lines:
	line = line.strip()  # 줄 끝의 줄 바꿈 문자를 제거한다.
    print(line)
f.close()
```
+ 파일의 모든 줄을 읽어서 각각의 줄을 요소로 갖는 리스트로 돌려준다.

#### read
```
f = open("C:/doit/새파일.txt", 'r')
data = f.read()
print(data)
f.close()
```
+ 파일의 내용 전체를 문자열로 돌려준다. 

### 파일에 새로운 내용 추가하기
+ 쓰기 모드('w')로 파일을 열 때 이미 존재하는 파일을 열면 그 파일의 내용이 모두 사라지게 된다.
+ 원래 있던 값을 유지하면서 단지 새로운 값만 추가해야 할 경우도 있다. 이런 경우에는 파일을 추가 모드('a')로 열면 된다. 

### with문
```py
with open("foo.txt", "w") as f:
    f.write("Life is too short, you need python")
```
+ 파일을 열고 닫는 걸 자동으로 처리해준다.

