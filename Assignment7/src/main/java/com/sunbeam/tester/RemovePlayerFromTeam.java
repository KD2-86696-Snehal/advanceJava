package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.Dao.PlayerDao;
import com.sunbeam.Dao.PlayerDaoImpl;




public class RemovePlayerFromTeam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try (SessionFactory sf = getSessionFactory();
				Scanner sc=new Scanner(System.in)) {
			PlayerDao playerdao = new PlayerDaoImpl();
			System.out.println("Enter Team Abbreviation n player id");			
			System.out.println(playerdao.removePlayer(sc.nextLong(),sc.nextLong()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

}
