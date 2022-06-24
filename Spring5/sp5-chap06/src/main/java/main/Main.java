package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import config.AppCtx;
import config.AppCtxWithPrototype;
import spring.Client2;
import spring.Client;

public class Main {

	public static void main(String[] args) {
//		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
//		
//		Client2 client = ctx.getBean(Client2.class);
//		client.send();
//		
//		ctx.close();
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtxWithPrototype.class);
		
		Client client = ctx.getBean(Client.class);
		client.send();
		
		ctx.close();
	}

}
