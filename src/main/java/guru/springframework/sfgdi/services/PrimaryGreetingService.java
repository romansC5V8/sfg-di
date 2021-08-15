package guru.springframework.sfgdi.services;

// Mit @Primary kann man so eine Art Default definieren, falls es mehrere Services (ohne @Qualifier) zur Auswahl stehen.
// @Qualifiert geht vor @Primary!
//@Primary --> Diese Annotation ist jetzt in der Config
//@Service --> Diese Annotationen sind jetzt in der Config
public class PrimaryGreetingService implements GreetingService {

	@Override
	public String sayGreeting() {
		return "Hello World - From the PRIMARY Bean";
	}
}
