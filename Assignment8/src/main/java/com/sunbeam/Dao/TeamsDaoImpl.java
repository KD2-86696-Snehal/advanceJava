package com.sunbeam.Dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.io.Serializable;
import java.util.List;

import static com.sunbeam.utils.HibernateUtils.getSessionFactory;

import com.sunbeam.entities.Teams;

public class TeamsDaoImpl implements TeamsDao {
	
	
	
	

	@Override
	public String addTeam(Teams team) {
		// TODO Auto-generated method stub
		String msg="Team Registration Failed...";
		Session session= getSessionFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		
		try {
			
			 session.persist(team);
			tx.commit();
			msg="Team Registration Done!!! Team Id - "+team.getId();
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
	public List<Teams> getAllTeams() {
		// TODO Auto-generated method stub
		List<Teams>teamList=null;
		String jpql= "select t from Teams t";
		
		Session session= getSessionFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		try {
			teamList=session.createQuery(jpql,Teams.class).getResultList();
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
		
		
		return teamList;
	}

	@Override
	public List<Teams> getSelectedTeams(int maxAge, double battingAvg) {
		// TODO Auto-generated method stub
		
		
		String jpql= "select t from Teams t where t.maxPlayerAge<:age and t.battingAvg>:avg";
		
		List<Teams>teamList=null;
		
		Session session= getSessionFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		
		try
		{
			teamList = session.createQuery(jpql, Teams.class)
					.setParameter("age", maxAge)
					.setParameter("avg", battingAvg)
					.getResultList();
			
			tx.commit();
			
		}
		catch(RuntimeException e)
		{
			if (tx!=null)
			{
				tx.rollback();
			}
			throw e;
		}
		
		return teamList;
	}

	@Override
	public List<Teams> getSelectedUsers(int maxAge, double battingAvg) {
		// TODO Auto-generated method stub
		
		List<Teams> team = null;
		String jpql="select new com.sunbeam.entities.Teams(owner, abbreviation) from Teams t where t.maxPlayerAge<:age and t.battingAvg>:avg";
		
		Session session = getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try
		{
			team = session.createQuery(jpql, Teams.class)
					.setParameter("age", maxAge)
					.setParameter("avg", battingAvg)
					.getResultList();
			
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
		
		return team;
	}

	@Override
	public String updateMaxAge(String name, int maxAge) {
		// TODO Auto-generated method stub
		Teams team=null;
		String msg="Team Updation Failed!!";
		
		String jpql= "select t from Teams t where t.name=:name";
		
		Session session= getSessionFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		
		try
		{
			team = session.createQuery(jpql, Teams.class)
					.setParameter("name", name)
					.getSingleResult();
			
			team.setMaxPlayerAge(maxAge);
			
			tx.commit();
			msg="Team Updated";
			
		}
		catch(RuntimeException e)
		{
			if (tx!=null)
			{
				tx.rollback();
			}
			throw e;
		}
		
		return msg;
	}

	@Override
	public String deleteUserDetails(long teamId) {
		// TODO Auto-generated method stub
		Teams team=null;
		String msg="Team Deletion Failed!!";
		
		
		
		Session session= getSessionFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		
		try
		{
			team=session.get(Teams.class, teamId);
			
			if(team!=null)
			{
				session.delete(team);
			}
			
			tx.commit();
			msg="Team details Deleted!!!";
			
		}
		catch(RuntimeException e)
		{
			if (tx!=null)
			{
				tx.rollback();
			}
			throw e;
		}
		
		return msg;

	}

	@Override
	public Teams getTeamAndPlayersDetails(String abbreviation) {
		// TODO Auto-generated method stub
		
		Teams team=null;
		String jpql="select t from Teams t left join fetch t.players where t.abbreviation=:abbr";
		
		Session session=getSessionFactory().getCurrentSession();
		
		Transaction tx= session.beginTransaction();
		
			try
			{
				team=session.createQuery(jpql,Teams.class).setParameter("abbr",abbreviation ).getSingleResult();
				
				
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
		
		
		
		return team;
	}

}
