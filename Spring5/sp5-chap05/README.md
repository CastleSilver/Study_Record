# 컴포넌트 스캔
+ @Component, @Controller, @Serivce, @Repository, @Aspect, @Configuration : 클래스에 붙이면 빈으로 등록된다
+ @ComponentScan(basepackages = {"패키지명"}, excludeFilters = @Filter(type = 필터타입, pattern = "패턴")
  + basepackages : 패키지명에 Component가 붙은 것들을 빈으로 등록
  + 필터타입
    1. FilterType.REGEX -> 정규 표현식을 사용해서 제외 대상을 지정
    2. FilterType.ASPECTJ -> AspectJ 패턴을 사용해서 대상을 지정
    3. FilterType.ASSIGNABLE_TYPE -> 특정 타입이나 하위 타입을 제외
    4. FilterType.ANNOTATION -> 특정 애노테이션을 붙인 타입을 제외
  + 설정할 필터가 두 개 이상이면 배열을 사용해 @Filter 목록을 전달하면 된다
+ 수동 등록한 빈과 컴포넌트 스캔을 이용한 빈의 이름이 동일하여 충돌할 경우 수동 등록된 빈이 우선한다.
