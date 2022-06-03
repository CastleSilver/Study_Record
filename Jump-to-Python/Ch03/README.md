## IF

```
if 조건문:
    수행할 문장1
    수행할 문장2
    ...
elif <조건문>:
    <수행할 문장1>
    <수행할 문장2>
    ...
else:
    수행할 문장A
    수행할 문장B
    ...
```
### 주의할 점
+ 조건문 뒤에 : 을 붙여줘야 한다.
+ 수행할 문장은 들여쓰기를 해줘야 한다. 이때 들여쓰기는 동일한 간격을 유지해야 한다.
+ 조건문을 만족해도 아무일도 안일어나게 하고 싶으면 수행할 문장대신 pass를 입력하면 된다.

### and, or, not
```
if 조건문1 or 조건문 2:
	수행할 문장A
elif 조건문1 and 조건문2:
	수행할 문장B
elif not 조건문1:
	수행할 문장
```
### in, not in
|in|not in|
|:--:|:--:|
|x in 리스트|x not in 리스트|
|x in 튜플|x not in 튜플|
|x in 문자열|x not in 문자열|

+ 요소가 포함되어 있으면 True를 아니면 False를 반환한다.

```py
>>> pocket = ['paper', 'cellphone', 'money']
>>> if 'money' in pocket:
...     print("택시를 타고 가라")
... else:
...     print("걸어가라")
...
택시를 타고 가라
>>>
```

<br/>

## While
```
while <조건문>:
    <수행할 문장1>
    <수행할 문장2>
    <수행할 문장3>
    ...
```
+ 조건문이 true일 때까지 반복하다가 false면 반복문이 끝난다.
+ 반복문을 강제로 빠져나가고 싶을 때는 break를 사용한다.
+ 반복문의 첫 줄로 돌아가고 싶으면 continue를 사용한다.

<br/>

## for문

```
for 변수 in 리스트(또는 튜플, 문자열):
    수행할 문장1
    수행할 문장2
    ...
```
```py
>>> a = [(1,2), (3,4), (5,6)]
>>> for (first, last) in a:
...     print(first + last)
...
3
7
11
```
+ continue를 사용해 처음으로 돌아갈 수 있다.

### range 함수
+ range(10) : 0부터 10 미만의 숫자를 포함하는 range 객체를 만들어 준다.
+ range(1, 11) : 1부터 11미만의 숫자를 포함하는 range 객체를 만들어 준다.
```py
>>> a = [1,2,3,4]
>>> result = [num * 3 for num in a if num % 2 == 0]
>>> print(result)
[6, 12]
```
+ 리스트를 사용할 떄 위와 같이 사용할 수 있다.
