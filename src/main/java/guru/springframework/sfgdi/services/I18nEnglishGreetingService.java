package guru.springframework.sfgdi.services;

//@Profile("EN") --> Nach GreetingServiceConfig gewandert. Wird direkt an der @Bean dran geschrieben
//@Service("i18nService") --> Nach GreetingServiceConfig gewandert. Der Qualifier wurde zum Methodennamen
public class I18nEnglishGreetingService implements GreetingService {

	@Override
	public String sayGreeting() {
		return "Hello World - EN";
	}
}
