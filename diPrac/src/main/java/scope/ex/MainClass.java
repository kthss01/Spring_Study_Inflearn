package scope.ex;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		// 이러면 또 다름 참고하자
		GenericXmlApplicationContext ctx2 = 
				new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		InjectionBean injectionBean =
				ctx.getBean("injectionBean", InjectionBean.class);
		
		DependencyBean dependencyBean01 =
				ctx.getBean("dependencyBean", DependencyBean.class);
		
		DependencyBean dependencyBean02 =
				ctx.getBean("dependencyBean", DependencyBean.class);
//		DependencyBean dependencyBean02 =
//				ctx2.getBean("dependencyBean", DependencyBean.class);
		
		if (dependencyBean01.equals(dependencyBean02)) {
			System.out.println("dependencyBean01 == dependencyBean02");
		} else {
			System.out.println("dependencyBean01 != dependencyBean02");
		}
		
		
		
		
		ctx.close();
		
	}
	
}
