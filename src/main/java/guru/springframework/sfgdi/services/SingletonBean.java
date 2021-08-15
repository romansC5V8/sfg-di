package guru.springframework.sfgdi.services;

import org.springframework.stereotype.Component;

//@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON) --> Das braucht man nicht, weil es der Default-Scope ist.
@Component
public class SingletonBean {

	public SingletonBean() {
		// Diese Bean wird gleich zum Start erstellt
		System.out.println("\nCreating a Singleton bean!!!!!!!!!!\n");
	}

	public String getMyScope() {
		return "I'm a Singleton";
	}
}
