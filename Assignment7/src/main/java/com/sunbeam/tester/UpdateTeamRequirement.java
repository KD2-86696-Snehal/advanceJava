package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.Dao.TeamsDao;
import com.sunbeam.Dao.TeamsDaoImpl;

public class UpdateTeamRequirement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try (SessionFactory sf = getSessionFactory();
				Scanner sc=new Scanner(System.in)) {
			//create team dao instance
			TeamsDao teamdao=new TeamsDaoImpl();
			System.out.println("Enter Team name and maxAge to be updated");			
			System.out.println(teamdao.updateMaxAge(sc.next(),sc.nextInt())); 
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
