package com.isa.platform.upc.Ejercicio5;

import com.isa.platform.upc.Ejercicio5.shared.util.Utilities;
import com.isa.platform.upc.Ejercicio5.users.model.enums.ERole;
import com.isa.platform.upc.Ejercicio5.users.repository.IRoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;

@Slf4j

@SpringBootApplication

public class Ejercicio5Application {

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio5Application.class, args);
	}
	@Bean
	CommandLineRunner initDatabase(IRoleRepository roleRepository) {
		return args -> {
			Utilities.insertRoleIfNotFound(roleRepository, ERole.ROLE_USER);
			Utilities.insertRoleIfNotFound(roleRepository, ERole.ROLE_ADMIN);
		};
	}

}
