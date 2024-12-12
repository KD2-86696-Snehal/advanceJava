package com.sunbeam.Dao;

import static com.sunbeam.utils.HibernateUtils.getSessionFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunbeam.entities.Owner;
import com.sunbeam.entities.Teams;

public class OwnerDaoImpl implements OwnerDao {

	@Override
	public String addNewOwner(Owner owner, Long teamId) {
		// TODO Auto-generated method stub
		String msg="Owner Registration Failed...";
		Session session= getSessionFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		
		try {
			Teams team=session.get(Teams.class, teamId);
			if(team!=null)
			{
			owner.setTeam(team);
			
			session.persist(owner);
			}
			tx.commit();
			msg="Owner Registration Done!!! owner of Team  - "+team.getName();
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

}
