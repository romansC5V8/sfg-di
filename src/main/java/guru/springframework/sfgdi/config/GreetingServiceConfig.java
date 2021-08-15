package guru.springframework.sfgdi.config;

import guru.springframework.sfgdi.services.ConstructorInjectedGreetingService;
import guru.springframework.sfgdi.services.PropertyInjectedGreetingService;
import guru.springframework.sfgdi.services.SetterInjectedGreetingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // --> Sagt Spring "das ist eine Konfigurationsklasse und definiert Beans"
public class GreetingServiceConfig {

	// --> Mit dieser Annotation wird das zurückgegebene Objekt zu einer Spring-Komponente. EHER FÜR THIRD-PARTY-KLASSEN !!!!
	@Bean
	ConstructorInjectedGreetingService constructorInjectedGreetingService() {
		return new ConstructorInjectedGreetingService();
	}

	// --> Defaultmäßig wird der Methodenname als Bean-Name im Spring-Container verwendet (am Besten Klassenname mit Kleinbuchstabe am Anfang)
	@Bean
	PropertyInjectedGreetingService propertyInjectedGreetingService() {
		return new PropertyInjectedGreetingService();
	}

	@Bean
	SetterInjectedGreetingService setterInjectedGreetingService() {
		return new SetterInjectedGreetingService();
	}
}
