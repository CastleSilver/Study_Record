# ch02. 파이썬 프로그래밍의 기초, 자료형

## 숫자형
+ 정수형, 실수형 등이 구분되는 것은 자바와 동일하지만, 자바는 자료형이 정해져 있어 계산 결과도 자료형에 구속받는 것에 비해, 파이썬은 정수형끼리의 연산도 결과값이 실수형이면 실수형으로 반환된다.

## 문자형
### 문자형 만드는 방법
1. 큰따옴표(")로 양쪽 둘러싸기
2. 작은따옴표(')로 양쪽 둘러싸기
3. 큰따옴표 3개를 연속(""")으로 써서 양쪽 둘러싸기
4. 작은따옴표 3개를 연속(''')으로 써서 양쪽 둘러싸기

+ 이렇게 만드는 방법이 여러개인 경우는 ' 나 "를 문자열에 포함시켜야 하는 경우 때문이다. '을 포혐시켜야 한다면 "를 이용해서, "를 포함시킬 때는 '를 이용해서 문자열을 만들면 된다.
+ 위 방법을 사용하지 않고도 백슬래시('\')뒤에 '나 "를 작성하면 오류없이 출력할 수 있다.
+ 문자열을 여러줄로 출력하고 싶으면 '\n'를 입력하면 된다.
+ 아니면 큰따옴표나 작은따옴표를 3개 연속으로 써서 블록을 지정하면 된다.
```python
>>> multiline="""
... Life is too short
... You need python
... """
>>> print(multiline)
Life is too short
You need python
```

### 문자열 연산
#### 문자열 곱하기
문자열을 더하는 것은 자바에도 있었지만 놀랍게도 파이썬에는 문자열 곱하기가 가능하다!
```python
>>> a = "python"
>>> a * 2
'pythonpython'
```
#### 문자열 길이 구하기
```python
>>> a = "Life is too short"
>>> len(a)
17
```
#### 문자열 인덱싱
공백도 포함해서 센다.
```python
>>> a = "Life is too short, You need Python"
>>> a[0]
'L'
>>> a[12]
's'
# 문자열 뒤에서 첫번째 글자
>>> a[-1]
'n'
# a[-0]은 a[0]과 똑같은 값을 보여 준다.
```
#### 숫자형과의 연산
+ 자바와 달리 숫자형과 문자형을 더하면 자동으로 문자형으로 형변환되지 않고 TypeError가 발생한다
+ 따라서 숫자형과 연산하기 위해서는 숫자형을 문자형으로 변환시켜 줘야 한다
```py
>>>str(3) + "hi"
3hi
```
### 문자열 슬라이싱
```python
>>> a = "Life is too short, You need Python"
>>> a[0:4]
'Life'
```
+ 한 글자가 아닌 여러 글자를 가져올 때 사용한다
+ 슬라이싱 할때 끝번호는 가져오지 않는다
+ 끝 번호를 생략하면 시작 번호부터 문자열 끝까지 가져온다
+ 시작 번호를 생략하면 문자열의 처음부터 끝 번호까지 가져온다
+ 시작 번호와 끝 번호를 생략하면 문자열의 처음부터 끝까지 가져온다
+ 슬라이싱에도 -를 사용할 수 있다. 이때도 끝번호 -1까지만 가져온다
```python
>>> a[19:-7]
'You need'
```
#### 슬라이싱을 이용해서 문자열 중간 문자 수정하기
```python
>>> a = "Pithon"
>>> a[:1]
'P'
>>> a[2:]
'thon'
>>> a[:1] + 'y' + a[2:]
'Python'
```
### 문자열 포맷팅
```python
>>> number = 10
>>> day = "three"
>>> "I ate %d apples. so I was sick for %s days." % (number, day)
'I ate 10 apples. so I was sick for three days.'
```
#### 포맷 코드

|코드|설명|
|:---:|:---:|
|%s|문자열(String)|
|%c|문자 1개(character)|
|%d|정수(Integer)|
|%f|부동소수(floating-point)|
|%o|8진수|
|%x|16진수|
|%%|Literal % (문자 % 자체)|

#### 포맷 함수를 이용한 포매팅
```python
# 인덱스로 넣기
>>> number = 10
>>> day = "three"
>>> "I ate {0} apples. so I was sick for {1} days.".format(number, day)
'I ate 10 apples. so I was sick for three days.'
```
```python
# 이름으로 넣기
>>> "I ate {number} apples. so I was sick for {day} days.".format(number=10, day=3)
'I ate 10 apples. so I was sick for 3 days.'
```
```python
# 인덱스와 이름을 혼용하기
>>> "I ate {0} apples. so I was sick for {day} days.".format(10, day=3)
'I ate 10 apples. so I was sick for 3 days.'
```
```python
# 왼쪽 정렬
>>> "{0:<10}".format("hi")
'hi        '
# 오른쪽 정렬
>>> "{0:>10}".format("hi")
'        hi'
# 가운데 정렬
>>> "{0:^10}".format("hi")
'    hi    '
```
```python
# 공백 채우기
>>> "{0:=^10}".format("hi")
'====hi===='
>>> "{0:!<10}".format("hi")
'hi!!!!!!!!'
```
#### f 문자열 포매팅
+ 문자열 앞에 f 접두사를 붙이면 f 문자열 포매팅 기능을 사용할 수 있다
+  f 문자열 포매팅은 표현식<sub>문자열 안에서 변수와 +, -와 같은 수식을 함께 사용하는 것</sub>을 지원한다
+ 정렬과 공백 채우기 등은 포맷함수와 동일하다
```python
>>> name = '홍길동'
>>> age = 30
>>> f'나의 이름은 {name}입니다. 나이는 {age+1}입니다.'
'나의 이름은 홍길동입니다. 나이는 31입니다.'
```
```python
# 딕셔너리 사용법
>>> d = {'name':'홍길동', 'age':30}
>>> f'나의 이름은 {d["name"]}입니다. 나이는 {d["age"]}입니다.'
'나의 이름은 홍길동입니다. 나이는 30입니다.'
```

### 문자열 관련 함수
#### 문자 개수 세기(count)
```python
>>> a = "hobby"
>>> a.count('b')
2
```
#### 위치 알려주기(find, index)
```python
# find는 찾는 문자가 없으면 -1을, index는 찾는 문자가 없으면 오류를 반환한다
>>> a = "Python is the best choice"
>>> a.find('b')
14
>>> a.find('k')
-1
>>> a.index('k')
Traceback (most recent call last):
File "<stdin>", line 1, in <module>
ValueError: substring not found
```
#### 문자열 삽입(join)
```python
# 문자열 뿐만 아니라 리스트나 튜플에도 사용 가능하다
>>> ",".join('abcd')
'a,b,c,d'
>>> ",".join(['a', 'b', 'c', 'd'])
'a,b,c,d'
```
#### 소문자를 대문자로 바꾸기(upper)
```python
>>> a = "hi"
>>> a.upper()
'HI'
```
#### 대문자를 소문자로 바꾸기(lower)
```python
>>> a = "HI"
>>> a.lower()
'hi'
```
#### 왼쪽 공백 지우기(lstrip)
```python
>>> a = " hi "
>>> a.lstrip()
'hi '
```
#### 오른쪽 공백 지우기(rstrip)
```python
>>> a= " hi "
>>> a.rstrip()
' hi'
```
#### 양쪽 공백 지우기(strip)
```python
>>> a = " hi "
>>> a.strip()
'hi'
```
#### 문자열 바꾸기(replace)
```python
>>> a = "Life is too short"
>>> a.replace("Life", "Your leg")
'Your leg is too short'
```
#### 문자열 나누기(split)
```py
# 괄호 안에 아무 값도 넣어 주지 않으면 
# 공백(스페이스, 탭, 엔터 등)을 기준으로 문자열을 나누어 준다
>>> a = "Life is too short"
>>> a.split()
['Life', 'is', 'too', 'short']

# 괄호 안에 특정 값이 있을 경우에는 
# 괄호 안의 값을 구분자로 해서 문자열을 나누어 준다
>>> b = "a:b:c:d"
>>> b.split(':')
['a', 'b', 'c', 'd']
```
## 리스트
### 리스트란?
+ 리스트명 = [요소1, 요소2, 요소3, ...]
+ 요소는 어떤 자료형도 포함시킬 수 있으며 다양한 자료형이 한 리스트에 담길 수 있다
+ 비어 있는 리스트는 a = list()로 생성할 수도 있다
+ 문자열과 동일하게 인덱싱과 슬라이싱이 가능하다
### 리스트의 수정과 삭제
#### 수정
```py
>>> a = [1, 2, 3]
>>> a[2] = 4
>>> a
[1, 2, 4]
```
#### del 함수 사용해 리스트 요소 삭제하기
```py
# del은 모든 객체에 사용 가능하다
>>> a = [1, 2, 3]
>>> del a[1]
>>> a
[1, 3]

# 슬라이싱 기법을 이용해 여러개 삭제도 가능하다
>>> a = [1, 2, 3, 4, 5]
>>> del a[2:]
>>> a
[1, 2]
```
### 리스트 관련 함수
#### 리스트에 요소 추가(append)
``` py
>>> a = [1, 2, 3]
>>> a.append(4)
>>> a
[1, 2, 3, 4]
```
#### 정렬
``` py
# 순서대로 정렬
>>> a = ['a', 'c', 'b']
>>> a.sort()
>>> a
['a', 'b', 'c']

# 역순으로 정렬
>>> a = ['a', 'c', 'b']
>>> a.reverse()
>>> a
['b', 'c', 'a']
```
#### 위치 반환(index)
```py
>>> a = [1,2,3]
>>> a.index(3)
2
>>> a.index(1)
0
>>> a.index(0)
Traceback (most recent call last):
  File "<stdin>", line 1, in <module>
ValueError: 0 is not in list
```
#### 리스트에 요소 삽입(insert)
```py
>>> a = [1, 2, 3]
>>> a.insert(0, 4)
>>> a
[4, 1, 2, 3]
```
#### 리스트 요소 제거(remove)
```py
>>> a = [1, 2, 3, 1, 2, 3]
>>> a.remove(3)
>>> a
[1, 2, 1, 2, 3]
```
#### 리스트 요소 끄집어내기(pop)
```py
# pop()은 리스트의 맨 마지막 요소를 돌려주고 그 요소는 삭제한다
>>> a = [1,2,3]
>>> a.pop()
3
>>> a
[1, 2]

# pop(x)는 리스트의 x번째 요소를 돌려주고 그 요소는 삭제한다
>>> a = [1,2,3]
>>> a.pop(1)
2
>>> a
[1, 3]
```
#### 리스트에 포함된 요소 x의 개수 세기(count)
```py
# count(x)는 리스트 안에 x가 몇 개 있는지 조사하여 그 개수를 돌려준다
>>> a = [1,2,3,1]
>>> a.count(1)
2
```
#### 리스트 확장(extend)
``` py
# extend(x)에서 x에는 리스트만 올 수 있으며 원래의 a 리스트에 x 리스트를 더하게 된다.
>>> a = [1,2,3]
>>> a.extend([4,5])
>>> a
[1, 2, 3, 4, 5]
>>> b = [6, 7]
>>> a.extend(b)
>>> a
[1, 2, 3, 4, 5, 6, 7]
```
<br/>


## 튜플
### 튜플이란?
+ 다음의 차이점을 제외하고는 리스트와 동일하다.
+ ()로 감싸져있다. 괄호는 생략 가능하다.
+ 요소가 1개만 존재할 경우, 뒤에 ,를 붙여줘야 한다.
+ 수정,삭제가 불가능하다.
+ 인덱싱과 슬라이싱이 가능하다.
+ 튜플끼리 더하기와 곱하기가 가능하다.
+ len함수로 길이를 구할 수 있다.

## 딕셔너리
### 딕셔너리란?
```
{Key1:Value1, Key2:Value2, Key3:Value3, ...}
```
+ key와 value가 짝을 이루고, key를 호출하면 value가 반환된다
+ 자바의 Map과 비슷하다
+ value에는 리스트, 숫자형, 문자형 등이 올 수 있다.

### 딕셔너리 추가, 삭제하기
#### 추가하기
```py
딕셔너리이름[key] = value
```
#### 삭제하기
```py
del 딕셔너리이름[key]
```
#### 주의사항
+ key값으로 가져오기에 중복된 key가 존재하면 한 개를 제외한 나머지는 무시된다.
+ key로 리스트는 사용할 수 없으나, 튜플은 사용할 수 있다. 이는 key는 고유해야한다는 성질 때문이다.
### 딕셔너리 관련 함수들
#### key리스트 만들기
```py
>>> a = {'name': 'pey', 'phone': '0119993323', 'birth': '1118'}
>>> a.keys()
dict_keys(['name', 'phone', 'birth'])
```
keys를 이용하면 dict_keys를 반환한다.
```py
>>> list(a.keys())
['name', 'phone', 'birth']
```
리스트 형식으로 반환하려면 위와 같이 해주면 된다.
#### Value 리스트 만들기(values)
```py
>>> a.values()
dict_values(['pey', '0119993323', '1118'])
```
#### Key, Value 쌍 얻기(items)
```py
>>> a.items()
dict_items([('name', 'pey'), ('phone', '0119993323'), ('birth', '1118')])
```
#### Key: Value 쌍 모두 지우기(clear)
```py
>>> a.clear()
>>> a
{}
```
#### Key로 Value얻기(get)
```py
>>> a = {'name':'pey', 'phone':'0119993323', 'birth': '1118'}
>>> a.get('name')
'pey'
>>> a.get('phone')
'0119993323'
```
존재하지 않는 키를 호출할 때 get함수는 None을 반환하고, 키로 직접 호출하는 방식은 오류를 발생시킨다.
```py
>>> a = {'name':'pey', 'phone':'0119993323', 'birth': '1118'}
>>> print(a.get('nokey'))
None
>>> print(a['nokey'])
Traceback (most recent call last):
  File "<stdin>", line 1, in <module>
KeyError: 'nokey'
```
get함수는 default값을 설정할 수 있다. 키가 존재하지 않으면 default를 반환한다.
```py
# get(x, '디폴트 값')
>>> a.get('foo', 'bar')
'bar'
```
#### 해당 Key가 딕셔너리 안에 있는지 조사하기(in)
```py
>>> a = {'name':'pey', 'phone':'0119993323', 'birth': '1118'}
>>> 'name' in a
True
>>> 'email' in a
False
```
존재하면 True, 존재하지 않으면 False를 반환한다.

## 집합

### 집합이란?
+ 괄호 안에 리스트를 입력하여 만들거나 문자열을 입력하여 만들 수도 있다.
```py
>>> s1 = set([1,2,3])
>>> s1
{1, 2, 3}
>>> s2 = set("Hello")
>>> s2
{'e', 'H', 'l', 'o'}
```
+ 집합은 중복을 허용하지 않고, 순서가 없기 때문에 인덱싱을 사용할 수 없다.
+ 인덱싱을 사용하려면 집합을 리스트나 튜플로 변환한 뒤 사용해야 한다.

### 교집합, 합집합, 차집합 구하기
```py
>>> s1 = set([1, 2, 3, 4, 5, 6])
>>> s2 = set([4, 5, 6, 7, 8, 9])
```
#### 교집합 구하기
```py
>>> s1 & s2
{4, 5, 6}

>>> s1.intersection(s2)
{4, 5, 6}
```

#### 합집합 구하기
```py
# 중복된 값은 하나만 표시된다.
>>> s1 | s2
{1, 2, 3, 4, 5, 6, 7, 8, 9}

>>> s1.union(s2)
{1, 2, 3, 4, 5, 6, 7, 8, 9}
```

#### 차집합 구하기
```py
>>> s1 - s2
{1, 2, 3}
>>> s2 - s1
{8, 9, 7}

>>> s1.difference(s2)
{1, 2, 3}
>>> s2.difference(s1)
{8, 9, 7}
```

### 집합 관련 함수들
#### 값 1개 추가하기(add)
```py
>>> s1 = set([1, 2, 3])
>>> s1.add(4)
>>> s1
{1, 2, 3, 4}
```
#### 값 여러 개 추가하기(update)
```py
>>> s1 = set([1, 2, 3])
>>> s1.update([4, 5, 6])
>>> s1
{1, 2, 3, 4, 5, 6}
```
#### 특정 값 제거하기(remove)
```py
>>> s1 = set([1, 2, 3])
>>> s1.remove(2)
>>> s1
{1, 3}
```

## 불
### 불(bool)이란?
True와 False 두 가지 값으로 존재하는 것으로 참 거짓의 유무를 판별할 때 쓰인다.

### 자료형의 참과 거짓
문자열, 리스트, 튜플, 딕셔너리의 빈 객체나, 숫자형의 0, None은 거짓이다.
```py
>>> a = [1, 2, 3, 4]
>>> while a:
...     print(a.pop())
...
4
3
2
1
```
자료형이 빌 때까지 pop을 이용해 안에 있는 값을 반환한다.

## 변수
### 변수란?
+ 데이터 타입을 지정해주는 자바나 C와 달리 파이썬은 데이터 타입을 알아서 판단한다.
+ 변수는 객체의 주소를 가르킨다. 주소는 내장함수 id(변수이름)를 통해 알아낼 수 있다.
### 변수를 복사할 때
+ 단순히 '='를 써서 복사하는 것은 같은 주소를 가르키기 때문에 얕은 복사가 된다.
#### 깊은 복사를 하는 법
1. [:] 사용
```py
>>> a = [1, 2, 3]
>>> b = a[:]
>>> a[1] = 4
>>> a
[1, 4, 3]
>>> b
[1, 2, 3]

```
2. copy 모듈 이용
```py
>>> from copy import copy
>>> a = [1, 2, 3]
>>> b = copy(a)
```
### 변수를 만드는 다양한 방법
```
>>> a, b = ('python', 'life')
>>> (a, b) = 'python', 'life'
>>> [a,b] = ['python', 'life']
```
