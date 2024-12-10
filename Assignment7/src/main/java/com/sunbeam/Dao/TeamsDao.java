package com.sunbeam.Dao;

import java.util.List;

import com.sunbeam.entities.Teams;

public interface TeamsDao {
	
	 String addTeam(Teams team);
	 List<Teams> getAllTeams();
	 List<Teams> getSelectedTeams(int maxAge, double battingAvg);
	 List<Teams> getSelectedUsers(int maxAge, double battingAvg);
	 String updateMaxAge(String name, int maxAge);
	 String deleteUserDetails(long teamId);
	 Teams getTeamAndPlayersDetails(String abbreviation);


}
