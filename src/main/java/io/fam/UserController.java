package io.fam;

import java.util.*;
import java.time.*;
import java.time.format.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public ResponseEntity<String> getBase() {
		return new ResponseEntity<String>("index", HttpStatus.OK);
	}
	
	@GetMapping("/user")
	public ResponseEntity<String> getIndex() {
		return new ResponseEntity<String>("Connection Success", HttpStatus.OK);
	}

	@GetMapping("/user/all")
	public List<User> getAllUsers() {
		List<User> allUsers = new ArrayList<>();
		userRepository.findAll().forEach(allUsers::add);

		return allUsers;
	}

	@GetMapping("/user/id/{id}")
	public User getUserById(@PathVariable("id") Long id) {
		return userRepository.findById(id).orElseGet(() -> new User());
	}

	@GetMapping("/user/find/fname")
	public List<User> getUserByFirstName(@RequestParam("fname") String firstName, @RequestParam(name = "case", required = false) boolean isCase) {
		return isCase ? userRepository.findByFirstName(firstName) : userRepository.findByFirstNameIgnoreCase(firstName);
	}

	@GetMapping("/user/find/lname")
	public List<User> getUserByLastName(@RequestParam("lname") String lastName, @RequestParam(name = "case", required = false) boolean isCase) {
		return isCase ? userRepository.findByLastName(lastName) : userRepository.findByLastNameIgnoreCase(lastName);
	}

	@GetMapping("/user/find/email")
	public List<User> getUserByEmail(@RequestParam("email") String email, @RequestParam(name = "case", required = false) boolean isCase) {
		return isCase ? userRepository.findByEmail(email) : userRepository.findByEmailIgnoreCase(email);
	}

	@GetMapping("/user/find/address")
	public List<User> getUserByAddress(@RequestParam("address") String address, @RequestParam(name = "case", required = false) boolean isCase) {
		return isCase ? userRepository.findByAddress(address) : userRepository.findByAddressIgnoreCase(address);
	}

	@GetMapping("/user/find/salary")
	public List<User> getUserBySalary(@RequestParam("salary") Double salary, @RequestParam(name = "gt", required = false) boolean greaterThan) {
		return greaterThan ? userRepository.findBySalaryGreaterThan(salary) : userRepository.findBySalary(salary);
	}

	@GetMapping("/user/find/birth")
	public List<User> getUserByBirthDate(@RequestParam("birth") LocalDate birthDate) {
		return userRepository.findByBirthDate(birthDate);
	}

	@PostMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addNewUser(@RequestBody User user) {
		userRepository.save(user);
		return new ResponseEntity("User created successfully!", HttpStatus.OK);
	}

	@PutMapping(value = "/user/fname/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateUserFirstNameById(@PathVariable("id") Long id, @RequestBody Map<String, String> updatedFirstName) {
		userService.updateFirstNameById(id, updatedFirstName);
		return ResponseEntity.ok().body("User updated successfully!");
	}

	@DeleteMapping(value = "user/{id}")
	public ResponseEntity<String> deleteUserById(@PathVariable("id") Long id) {
		userRepository.deleteById(id);
		return ResponseEntity.ok().body("User deleted successfully!");
	}

}
