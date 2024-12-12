package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtils.getSessionFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.Dao.OwnerDao;
import com.sunbeam.Dao.OwnerDaoImpl;
import com.sunbeam.entities.Owner;


public class AddOwnerWithTeamId {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(SessionFactory sf= getSessionFactory();Scanner sc= new Scanner(System.in))
		{
			OwnerDao ownerdao= new OwnerDaoImpl();
			System.out.println("Enter Team Id");
			Long teamId=sc.nextLong();
			System.out.println("Add Owner Details String Name, String email, String CompanyName,");
			Owner owner=new Owner(sc.next(),sc.next(),sc.next());
			System.out.println(ownerdao.addNewOwner(owner,teamId));
			
		}
		catch(Exception e)
		{
			e.printStackTrace();

		}


		
		
	}

}
