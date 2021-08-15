package guru.springframework.sfgdi.config;

import guru.springframework.sfgdi.repositories.EnglishGreetingRepository;
import guru.springframework.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import guru.springframework.sfgdi.services.ConstructorInjectedGreetingService;
import guru.springframework.sfgdi.services.I18nEnglishGreetingService;
import guru.springframework.sfgdi.services.I18nSpanishGreetingService;
import guru.springframework.sfgdi.services.PrimaryGreetingService;
import guru.springframework.sfgdi.services.PropertyInjectedGreetingService;
import guru.springframework.sfgdi.services.SetterInjectedGreetingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration // --> Sagt Spring "das ist eine Konfigurationsklasse und definiert Beans"
public class GreetingServiceConfig {

	@Bean
	EnglishGreetingRepository englishGreetingRepository() {
		return new EnglishGreetingRepositoryImpl();
	}

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

	@Primary
	@Bean
	PrimaryGreetingService primaryGreetingService() {
		return new PrimaryGreetingService();
	}

	// --> Der Servicename ist der Methodenname (defaultmäßig). Also kann man "i18nService()" als Methodenname verwenden.
	// Das ist ähnlich wie in der Klasse selbst: @Service("i18nService"). Siehe nächsten Service!!!
	@Bean("i18nService")
	@Profile("EN")
	I18nEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository) {
		return new I18nEnglishGreetingService(englishGreetingRepository);
	}

	// --> Hier müsste man den Serivce auch "i18nService()" benennen, das geht aber Javamäßig nicht. Deshalb gibt man explizit
	// den Bean-Namen an. Sidenote: sieht total hässlich aus. Mal so, mal so.
	@Bean("i18nService")
	@Profile({"ES", "default"})
	I18nSpanishGreetingService i18nSpanishGreetingService() {
		return new I18nSpanishGreetingService();
	}
}
