package guru.springframework.sfgdi.services;

import guru.springframework.sfgdi.repositories.EnglishGreetingRepository;

//@Profile("EN") --> Nach GreetingServiceConfig gewandert. Wird direkt an der @Bean dran geschrieben
//@Service("i18nService") --> Nach GreetingServiceConfig gewandert. Der Qualifier wurde zum Methodennamen
public class I18nEnglishGreetingService implements GreetingService {


	private final EnglishGreetingRepository englishGreetingRepository;

	public I18nEnglishGreetingService(EnglishGreetingRepository englishGreetingRepository) {
		this.englishGreetingRepository = englishGreetingRepository;
	}

	@Override
	public String sayGreeting() {
		return englishGreetingRepository.getGreeting();
	}
}
