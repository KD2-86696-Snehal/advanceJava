package com.sunbeam.tester;

import org.hibernate.SessionFactory;

import com.sunbeam.Dao.PlayerDao;
import com.sunbeam.Dao.PlayerDaoImpl;
import com.sunbeam.entities.Player;

import static com.sunbeam.utils.HibernateUtils.getSessionFactory;

import java.time.LocalDate;
import java.util.Scanner;

public class PlayerRegistration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try(SessionFactory sf= getSessionFactory();Scanner sc= new Scanner(System.in))
		{
			PlayerDao playerdao = new PlayerDaoImpl();
			System.out.println("Enter Team Abbreviation");
			String abbreviation=sc.next();
			System.out.println("Add player's String firstName, String LastName, LocalDate DateOfBirth, double battingAvg ,int WicketTaken-");
			Player player=new Player(sc.next(),sc.next(),LocalDate.parse(sc.next()),sc.nextDouble(),sc.nextInt());
			System.out.println(playerdao.addNewPlayer(player,abbreviation));
			
		}
		catch(Exception e)
		{
			e.printStackTrace();

		}

	
	

}
}
