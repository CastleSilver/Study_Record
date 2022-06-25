package aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
@Order(1)
public class ExeTimeAspect {
	
	// chap07이나 그 하위 패키지에 속한 빈 객체의 public 메서드를 설정
	@Pointcut("execution(public * chap07..*(..))")
	private void publicTarget() {
		
	}
	
	// ProceedingJoinPoint는 프록시 대상 객체의 메서드를 호출할 때 사용
	@Around("publicTarget()")
	public Object measure(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.nanoTime();
		try {
			// 실제 대상 객체의 메서드 호출
			Object result = joinPoint.proceed();
			return result;
		} finally {
			long finish = System.nanoTime();
			// 메서드 이름과 파라미터를 합쳐 시그니처라고 한다.
			// ProceedingJoinPoint.getSignature() : 호출되는 메서드에 대한 정보를 구한다.
			// ProceedingJoinPoint.getTarget() : 대상 객체를 구한다.
			// ProceedingJoinPoint.getArgs() : 파라미터 목록을 구한다.
			// Signature.getName() : 호출되는 메서드의 이름을 구한다.
			// Signature.toLongString() : 호출되는 메서드를 완전하게 표현한 문장을 구한다.(리턴 타입, 파라미터 타입이 모두 표시됨)
			// Signature.toShortString() : 호출되는 메서드를 축약해서 표현한 문장을 구한다(메서드의 이름만 구한다)
			Signature sig = joinPoint.getSignature();
			System.out.printf("%s.%s(%s) 실행 시간 : %d ns\n",
					joinPoint.getTarget().getClass().getSimpleName(),
					sig.getName(), Arrays.toString(joinPoint.getArgs()),
					(finish-start));
		}
	}
}
