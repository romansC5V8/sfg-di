package guru.springframework.sfgdi.services;

//@Service --> Hier braucht man nicht die Annotation. Diese Mimik wurde in der GreetingServiceConfig über eine Bean definiert.
public class ConstructorInjectedGreetingService implements GreetingService {

	@Override
	public String sayGreeting() {
		return "Hello World - Constructor";
	}
}
