package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.Dao.TeamsDao;
import com.sunbeam.Dao.TeamsDaoImpl;



public class DisplayFewColsConstExpr {
	
	public static void main(String[] args) {
		try (SessionFactory sf = getSessionFactory();
				Scanner sc=new Scanner(System.in)) {
			//create team dao instance
			TeamsDao teamdao=new TeamsDaoImpl();
			System.out.println("Enter maxAge and Batting Average");			
//			teamdao.getSelectedUsers(sc.nextInt(),sc.nextDouble())
//					.forEach(team -> System.out.println(team.getOwner()+" "+team.getAbbreviation()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
