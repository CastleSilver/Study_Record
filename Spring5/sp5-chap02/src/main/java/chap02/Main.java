package chap02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		//AnnotationConfigApplicationContext : 자바 설정에서 정보를 읽어와서 빈 객체를 생성하고 관리함
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(AppContext.class);
		//getBean(이름, 타입)
		Greeter g = ctx.getBean("greeter", Greeter.class);
		String msg = g.greet("스프링");
		System.out.println(msg);
		
		//싱글톤 객체
		// 스프링은 한 개의 빈 객체만을 생성하고 이 빈 객체는 싱글톤 범위를 갖는다.
		Greeter g1 = ctx.getBean("greeter", Greeter.class);
		Greeter g2 = ctx.getBean("greeter", Greeter.class);
		System.out.println("(g1 == g2) = "+(g1 == g2));// true
		ctx.close();
	}

}
