package guru.springframework.sfgdi.services;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class LifeCycleDemoBean implements InitializingBean, DisposableBean, BeanNameAware,
		BeanFactoryAware, ApplicationContextAware {

	public LifeCycleDemoBean() {
		System.out.println();
		System.out.println("## 01 - I'm in the LifeCycleBean Constructor");
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("## 02 - My Bean Name is: " + name);
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("## 03 - Bean Factory has been set");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("## 04 - Application context has been set");
	}

	public void beforeInit() {
		System.out.println("## 05 - Before Init - Called by Bean Post Processor");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("## 06 - The Post Construct annotated method has been called");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("## 07 - The LifeCycleBean has its properties set!");
	}

	public void afterInit() {
		System.out.println("## 08 - After Init - Called by Bean Post Processor");
	}

	// Ab hier erscheinen die Meldungen erst viel später

	@PreDestroy
	public void preDestroy() {
		System.out.println("## 09 - The Predestroy annotated method has been called");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("## 10 - The Lifecycle bean has been terminated");
	}
}
