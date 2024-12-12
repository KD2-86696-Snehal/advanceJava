package com.sunbeam.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="teams")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper=true ,exclude={"players"})
public class Teams extends BaseEntity {
	
	

	
	@Column(length= 100)
	private String name;
	
	@Column(length= 10, unique=true)
	private String abbreviation;
	
	@Column(name="max_player_age")
	private int maxPlayerAge;
	
	@Column(name = "batting_avg")
	private double battingAvg;
	
	@Column(name = "wickets_taken")
	private int wicketTaken;
	
	@OneToMany(mappedBy="playerTeamId",cascade=CascadeType.ALL ,orphanRemoval=true)
	private List<Player>players=new ArrayList<>();
	
	public Teams(String name, String abbreviation, int maxPlayerAge, double battingAvg,
			int wicketTaken) {
		
		
		this.name = name;
		this.abbreviation = abbreviation;
		this.maxPlayerAge = maxPlayerAge;
		this.battingAvg = battingAvg;
		this.wicketTaken = wicketTaken;
	}
	
	

//	public Teams(String abbreviation, String owner) {
//		super();
//		this.abbreviation = abbreviation;
//		this.owner = owner;
//	}



	public void addPlayer(Player newPlayer) {
		// TODO Auto-generated method stub
		this.players.add(newPlayer);
		newPlayer.setPlayerTeamId(this);
		
		
	}



	public void removePlayer(Player player) {
		// TODO Auto-generated method stub
		this.players.remove(player);
		player.setPlayerTeamId(null);
		
	}



	
		
	
	
	
	

}
