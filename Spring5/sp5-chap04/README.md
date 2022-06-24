# Annotation
+ @Qulifier : 빈 이름 지정
+ @Autowired(required = false) : required가 false가 아니면 dateTimeFormatter가 null값이면 오류가 발생한다. 빈이 존재하지 않으면 메서드가 호출되지 않는다.
+ Optional : 자동 주입 대상 타입이 Optional일 경우, 일치하는 빈이 존재하지 않으면 값이 없는 Optional을 인자로 전달하고 일치하는 빈이 존재하면 해당 빈을 값으로 갖는 Optional을 인자로 전달한다.
+ @Nullable : 자동 주입할 빈이 존재하지 않으면 인자로 null을 전달한다. 자동 주입할 빈이 없어도 메서드가 호출된다.

