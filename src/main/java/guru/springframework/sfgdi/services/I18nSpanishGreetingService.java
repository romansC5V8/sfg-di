package guru.springframework.sfgdi.services;

// Mit "default" wird ist Spanisch "Default" und man braucht das in den application.properties nicht mehr.
//@Profile({"ES", "default"}) --> Nach GreetingServiceConfig gewandert. Wird direkt an der @Bean dran geschrieben
//@Service("i18nService") --> Nach GreetingServiceConfig gewandert. Muss aber wegen mehrfachen Namen mit @Bean("<name>") angegeben werden.
public class I18nSpanishGreetingService implements GreetingService {

	@Override
	public String sayGreeting() {
		return "Hola Mundo - ES";
	}
}
