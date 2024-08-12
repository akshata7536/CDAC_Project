package com.sunbeam.DTO;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.sunbeam.entities.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {
	@JsonProperty(access = Access.READ_ONLY)
	private Long id;
	private String firstName;

	private String lastName;

	private String password;

	private String phoneNumber;

	private String email;

	@JsonProperty(access = Access.READ_ONLY)
	private Role role;

	private LocalDate dob;

	@JsonProperty(access = Access.READ_ONLY)
	private boolean isBlocked;

	public UserDTO(String firstName, String lastName, String password, String email, LocalDate dob) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.dob = dob;

	}

}
