package com.sunbeam.Dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunbeam.entities.Player;
import com.sunbeam.entities.Teams;

import static com.sunbeam.utils.HibernateUtils.getSessionFactory;

import java.util.List;

public class PlayerDaoImpl implements PlayerDao {

	@Override
	public String addNewPlayer(Player newPlayer, String abbre) {
		// TODO Auto-generated method stub
		String msg="Player Register Failed!!!";
		
		String jpql= "select t from Teams t where t.abbreviation=:abbr";
		Session session = getSessionFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		
		try
		{
			
			//get team details from it's abbreviation
			Teams team= session.createQuery(jpql, Teams.class).setParameter("abbr", abbre).getSingleResult();
			
			//establish bi dir association team 1<---->* players
			team.addPlayer(newPlayer);
			//session.persist(newPlayer); // NOT required since added cascading- save|udate|delete
			
			tx.commit();
			
			msg="Player Registered!!!";
		}
		catch(RuntimeException e)
		{
			if(tx!=null)
			{
				tx.rollback();
			}
		}
		
		return msg;
	}

	@Override
	public String removePlayer(long teamId, long playerId) {
		// TODO Auto-generated method stub
		
		String mesg="Player Delete failed!!";
		
		Session session = getSessionFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		
		try
		{
			
			//get team details from it's team
			Teams team = session.get(Teams.class, teamId);
			
			Player player=session.get(Player.class, playerId);
			List<Player>pl=team.getPlayers();
			
			if(team!=null && player!=null)
			{
				for (Player player2 : pl) {
					if(player2.getId()!=player.getId())
					{
						mesg="player not Exist";
					
						//establish bi dir association team 1<---->* players
						team.removePlayer(player);
						mesg="Player Deleted!!!";
					}
				}
			
			
			}
			tx.commit();
			
			
		}
		catch(RuntimeException e)
		{
			if(tx!=null)
			{
				tx.rollback();
			}
			throw e;
		}
		
		
		
		
		return mesg;
	}
	
	

}
