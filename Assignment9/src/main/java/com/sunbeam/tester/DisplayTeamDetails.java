package com.sunbeam.tester;

import org.hibernate.SessionFactory;

import com.sunbeam.Dao.TeamsDao;
import com.sunbeam.Dao.TeamsDaoImpl;

import static com.sunbeam.utils.HibernateUtils.getSessionFactory;

public class DisplayTeamDetails {
	
	public static void main(String args[])
	{
		try(SessionFactory sf = getSessionFactory())
		{
			TeamsDao teamdao = new TeamsDaoImpl();
			teamdao.getAllTeams().forEach(System.out::println);
		}
		catch(RuntimeException e)
		{
			e.printStackTrace();
		}

	}
}
