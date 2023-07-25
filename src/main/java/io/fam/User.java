package io.fam;

import java.time.*;

import jakarta.persistence.*;

import lombok.*;

@Entity
@Table(name = "userTable")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String firstName;
	private String lastName;
	private String email;
	private Double salary;
	private String address;
	private LocalDate birthDate;

}
