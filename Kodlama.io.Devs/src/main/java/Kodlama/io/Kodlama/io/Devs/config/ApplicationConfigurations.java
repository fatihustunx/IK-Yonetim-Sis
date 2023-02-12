package Kodlama.io.Kodlama.io.Devs.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfigurations {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
