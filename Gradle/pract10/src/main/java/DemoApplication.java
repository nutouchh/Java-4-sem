import components.BeanConfig;
import interfaces.Programmer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootConfiguration
@Configuration
//@EnableAutoConfiguration
@ComponentScan
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
//		Programmer proger = context.getBean(Programmer.class);

		String[] programmers = new String[]{"Junior", "Middle", "Senior"};
		for (String p : programmers) {
			Programmer programmer = (Programmer) context.getBean(p);
			programmer.doCoding();
		}

//		proger.doCoding();
//
//		SpringApplication.run(Programmer.class, args);

//		Programmer pr = new Junior();
//		pr.doCoding();
	}

}
