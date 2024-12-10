package com.sunbeam.Dao;

import com.sunbeam.entities.Player;

public interface PlayerDao {

	String addNewPlayer(Player player, String Abbreviation);

	String removePlayer(long teamId, long playerId);

}
