package com.masai.app.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User")
public class User {

	@Id
	@jakarta.validation.constraints.Email
	private String email;
	@Pattern(regexp = "^[a-zA-Z]+$",message = "No numbers or specials characters")
	private String firstName;
	@Pattern(regexp = "^[a-zA-Z]+$",message = "No numbers or special characters")
	private String lastName;
	@Size(min = 10,max = 10,message = "Mobile number must have 10 digits")
	private String mobileNumber;
	@Past(message = "The date of birth should not be a future date")
	private LocalDate dateOfBirth;
	
	/**a user can send multiple emails but an email can be associated to one user**/
	/**see this user as sender user **/
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "from")
	@JsonIgnore
	private List<Email> sendMails;
	
	
}
