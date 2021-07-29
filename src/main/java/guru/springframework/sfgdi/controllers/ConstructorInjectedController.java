package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class ConstructorInjectedController {

	private final GreetingService greetingService;

	// Bei der Konstruktor-Variante @Autowired ist optional ab Spring 4.2
	// Mit @Qualifier(<lowerCaseBeanName>) kann man genauer sagen, welche Instanz man möchte, da man mit der Interface arbeitet
	public ConstructorInjectedController(@Qualifier("constructorInjectedGreetingService") GreetingService greetingService) {
		this.greetingService = greetingService;
	}

	public String getGreeting() {
		return greetingService.sayGreeting();
	}
}
