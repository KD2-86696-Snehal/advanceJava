package com.sunbeam.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Setter
@Getter
@ToString(callSuper=true , exclude= {"team"})
public class Owner extends BaseEntity {
	@Column(length=30)
	private String name;
	
	@Column(length=30)
	private String email;
	
	@Column(length=30)
	private String companyName;
	
	@OneToOne
	@JoinColumn(name="team_id")
	private Teams team;

	public Owner(String name, String email, String companyName) {
		super();
		this.name = name;
		this.email = email;
		this.companyName = companyName;
		
	}
	
	
	

}
