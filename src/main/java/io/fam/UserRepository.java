package io.fam;

import java.util.*;
import java.time.*;

import org.springframework.stereotype.*;
import org.springframework.data.repository.*;

@Component
public interface UserRepository extends CrudRepository<User, Long> {

	List<User> findByFirstName(String firstName);

	List<User> findByLastName(String lastName);

	List<User> findByEmail(String email);

	List<User> findBySalary(Double salary);

	List<User> findByAddress(String address);

	List<User> findByBirthDate(LocalDate birthDate);

	List<User> findByFirstNameIgnoreCase(String firstName);

	List<User> findByLastNameIgnoreCase(String lastName);

	List<User> findByEmailIgnoreCase(String email);

	List<User> findByAddressIgnoreCase(String address);

	List<User> findBySalaryGreaterThan(Double salary);
	
}
