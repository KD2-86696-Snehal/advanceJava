package com.sunbeam.tester;

import org.hibernate.SessionFactory;

import com.sunbeam.Dao.TeamsDao;
import com.sunbeam.Dao.TeamsDaoImpl;

import static com.sunbeam.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

public class GetTeamsSelectedByAgeAndBattingAvg {
	
	
	public static void main(String[]args)
	{
		
	
		try(SessionFactory sf = getSessionFactory(); Scanner sc = new Scanner(System.in))
		{
			TeamsDao teamdao = new TeamsDaoImpl();
			System.out.println("Enter Max age and Batting Average");
			teamdao.getSelectedTeams(sc.nextInt(), sc.nextDouble()).forEach(System.out::println);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
