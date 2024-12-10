package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtils.getSessionFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.Dao.PlayerDao;
import com.sunbeam.Dao.PlayerDaoImpl;
import com.sunbeam.Dao.TeamsDao;
import com.sunbeam.Dao.TeamsDaoImpl;
import com.sunbeam.entities.Player;
import com.sunbeam.entities.Teams;

public class DisplayTeamWithPlayers {
	
	public static void main(String[]args)
	{
		try(SessionFactory sf= getSessionFactory();Scanner sc= new Scanner(System.in))
		{
			TeamsDao teamdao = new TeamsDaoImpl();
			System.out.println("Enter Team Abbreviation");
			String abbreviation=sc.next();
			Teams team=teamdao.getTeamAndPlayersDetails(abbreviation);
			System.out.println(team);
			team.getPlayers()
			.forEach(System.out::println);
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();

		}
	}

}
