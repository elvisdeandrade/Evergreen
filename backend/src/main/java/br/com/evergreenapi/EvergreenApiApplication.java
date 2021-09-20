package br.com.evergreenapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import br.com.evergreenapi.Repositories.FeedRepository;
import br.com.evergreenapi.Repositories.ProfileRepository;
import br.com.evergreenapi.Repositories.UserRepository;

@SpringBootApplication
public class EvergreenApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EvergreenApiApplication.class, args);
	}

	@Bean
	public CommandLineRunner seed(UserRepository users, FeedRepository feeds, ProfileRepository profiles) {
		return (args) -> {

		};

	}
}
