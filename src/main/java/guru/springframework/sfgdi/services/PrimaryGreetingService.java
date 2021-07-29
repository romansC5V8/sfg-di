package guru.springframework.sfgdi.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

// Mit @Primary kann man so eine Art Default definieren, falls es mehrere Services (ohne @Qualifier) zur Auswahl stehen.
// @Qualifiert geht vor @Primary!
@Primary
@Service
public class PrimaryGreetingService implements GreetingService {

	@Override
	public String sayGreeting() {
		return "Hello World - From the PRIMARY Bean";
	}
}
