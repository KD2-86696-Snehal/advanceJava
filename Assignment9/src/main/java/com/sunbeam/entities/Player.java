package com.sunbeam.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.*;


@Entity
@Table(name="Players")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper=true,exclude = {"playerTeamId"})
public class Player extends BaseEntity {
	
	@Column(length=20)
	private String firstName;
	
	@Column(length=20)
	private String lastName;
	
	@Column(name="date")
	private LocalDate DOB;
	
	@Column(name="batting_avg")
	private double battingAvg;
	
	@Column(name="wicket_taken")
	private int wicketsTaken;
	
	@ManyToOne
	@JoinColumn(name="Team_id")
	private Teams playerTeamId;

	public Player(String firstName, String lastName, LocalDate dOB, double battingAvg, int wicketsTaken) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		DOB = dOB;
		this.battingAvg = battingAvg;
		this.wicketsTaken = wicketsTaken;
	}
	
	
	
	
	//players(id bigint primary key auto_increment,first_name varchar(20),last_name varchar(20),
	//dob date,batting_avg double,wickets_taken int,team_id int ,
	//constraint fk_teams foreign key (team_id) references teams(team_id)

	

}
