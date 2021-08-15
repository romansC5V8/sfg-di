package guru.springframework.sfgdi;

import guru.springframework.sfgdi.controllers.ConstructorInjectedController;
import guru.springframework.sfgdi.controllers.I18nController;
import guru.springframework.sfgdi.controllers.MyController;
import guru.springframework.sfgdi.controllers.PetController;
import guru.springframework.sfgdi.controllers.PropertyInjectedController;
import guru.springframework.sfgdi.controllers.SetterInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

//@ComponentScan(basePackages = {"guru.springframework.sfgdi", "com.springframework.pets"}) --> Nach dem "Factory Beans"-Teil tut man so als
// würden die Pet-Services von einer 3rd-party-Komponente kommen. Da sie in der Config als FactoryBean instanziiert werden, braucht man nicht
// in anderen Packages zu scannen. Also kann @ComponentScan raus.
// ---------------------------
//@ImportResource("classpath:sfgdi-config.xml") // resources-Folder ist im Classpath. Hier geht's auch aber es liegt schon in der Config-Klasse.
@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

		System.out.println("\n***** PROFILES *****\n");

		PetController petController = ctx.getBean("petController", PetController.class);
		System.out.print("The Best Pet is: ");
		System.out.println(petController.whichPetIsTheBest() + "\n");

		I18nController i18nController = (I18nController) ctx.getBean("i18nController");

		System.out.println(i18nController.sayHello());

		System.out.println("\n\n***** PRIMARY BEAN *****\n");

		MyController myController = (MyController) ctx.getBean("myController");

		System.out.print("- Primary Bean: ");

		System.out.println(myController.sayHello() + "\n");

		System.out.println("\n***** DEPENDENCY INJECTION *****\n");

		System.out.print("- Property: ");

		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");

		System.out.println(propertyInjectedController.getGreeting() + "\n");

		System.out.print("- Setter: ");

		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");

		System.out.println(setterInjectedController.getGreeting() + "\n");

		System.out.print("- Constructor: ");

		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");

		System.out.println(constructorInjectedController.getGreeting() + "\n");

	}
}
