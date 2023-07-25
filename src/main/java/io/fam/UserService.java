package io.fam;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
public class UserService {

	@Autowired
	UserRepository repository;

	public void updateFirstNameById(Long id, Map<String, String> updatedFirstName) {
		User user = repository.findById(id).orElseGet(() -> new User());
		user.setFirstName(updatedFirstName.get("fname"));
		repository.save(user);
	}
	
}
