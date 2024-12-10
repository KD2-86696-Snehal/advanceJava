package com.sunbeam.tester;



import java.util.Scanner;

import org.hibernate.SessionFactory;


import com.sunbeam.Dao.TeamsDao;
import com.sunbeam.Dao.TeamsDaoImpl;
import static com.sunbeam.utils.HibernateUtils.getSessionFactory;

public class DeleteTeambyId {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
			try (SessionFactory sf = getSessionFactory();
					Scanner sc=new Scanner(System.in)) {
				//create user dao instance
				TeamsDao teamdao=new TeamsDaoImpl();
				System.out.println("Enter Team id to Delete");			
				System.out.println(teamdao.deleteUserDetails(sc.nextLong()));
			} catch (Exception e) {
				e.printStackTrace();
			}

		
	}

}
