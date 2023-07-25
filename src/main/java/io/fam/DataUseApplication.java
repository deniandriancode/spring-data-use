package io.fam;

import java.time.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;

@SpringBootApplication
public class DataUseApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataUseApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(UserRepository repository) {
		return (args) -> {
			repository.save(new User(Long.valueOf(1L), "John", "Doe", "johndoe@email.com", Double.valueOf(7658.42), "New York", LocalDate.of(1998, Month.MAY, 24)));
			repository.save(new User(Long.valueOf(2L), "Jane", "Doe", "janedoe@email.com", Double.valueOf(6567.113), "Los Angeles", LocalDate.of(2000, Month.JUNE, 18)));
			repository.save(new User(Long.valueOf(3L), "Brown", "Doug", "browndoug@email.com", Double.valueOf(8686.23), "California", LocalDate.of(1994, Month.DECEMBER, 1)));
			repository.save(new User(Long.valueOf(4L), "Chelsea", "McMal", "chelseamcmal@email.com", Double.valueOf(9125.87), "California", LocalDate.of(1997, Month.NOVEMBER, 4)));
			repository.save(new User(Long.valueOf(5L), "Cindy", "Graham", "cindygr@email.com", Double.valueOf(9467.90), "Florida", LocalDate.of(1998, Month.JULY, 22)));
			repository.save(new User(Long.valueOf(6L), "Claire", "P.Y.", "cpy@email.com", Double.valueOf(7123.21), "Texas", LocalDate.of(1999, Month.APRIL, 13)));
			repository.save(new User(Long.valueOf(7L), "Jake", "Dust", "jakedust@email.com", Double.valueOf(6984.67), "Washington, D.C.", LocalDate.of(1991, Month.JUNE, 15)));
		};
	}

}
