package com.masai.app.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Email")
public class Email {

	@Id
	private int id;
	private String subject;
	private String content;
	private boolean starred=false;
	
	/**unidirectional mapping **/
	@OneToOne(cascade = CascadeType.ALL)
	private User to;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private User from;
	
}
