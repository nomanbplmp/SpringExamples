package com.example.demo.beans;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

@Configuration
public class Registry implements ApplicationContextAware, ApplicationListener<ContextRefreshedEvent> {

	private ApplicationContext applicationContext;
	private Map<Class<? extends Instrument>, Validator> validatorRegistry ;
	private Map<Class<? extends Instrument>, RulesExtractor> rulesExtractorRegistry;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		validatorRegistry = registerValidators(Validator.class);

	}

	private void registerRegistrable() {
		/*
		 * Collection<Registrable> registrable =
		 * applicationContext.getBeansOfType(Registrable.class).values();
		 */
	}

	private Map<Class<? extends Instrument>, Validator> registerValidators(Class<Validator> clz) {
		
		HashMap<Class<? extends Instrument>, Validator> registry  = new HashMap<>();
		Collection<Validator> validators = applicationContext.getBeansOfType(clz).values();
		validators.forEach(v -> {
			InstrumentMeta annots = v.getClass().getAnnotation(InstrumentMeta.class);
			if (annots != null)
				registry.put(annots.value(), (Validator) applicationContext.getBean(v.getClass()));

		});
		return Collections.unmodifiableMap(registry);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;

	}
	
	

	public Validator validator(Instrument i) {
		return validatorRegistry.get(i.getClass());
	}

	/*
	 * public static void main(String... args) { SwapValidator v = new
	 * SwapValidator(); Registry reg = new Registry(); reg.register(v); }
	 */

}
