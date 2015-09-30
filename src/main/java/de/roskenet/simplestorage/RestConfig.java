package de.roskenet.simplestorage;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

import de.roskenet.simplestorage.entity.Tag;

@Configuration
public class RestConfig extends RepositoryRestMvcConfiguration {

	@Override
	protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(Tag.class);
//		config.useHalAsDefaultJsonMediaType(false);
	}
}
