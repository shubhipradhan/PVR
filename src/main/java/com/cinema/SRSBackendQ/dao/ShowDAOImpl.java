package com.cinema.SRSBackendQ.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;


import com.cinema.SRSBackendQ.model.Show;

@Repository("showDAO")
@EnableTransactionManagement
@Transactional
public class ShowDAOImpl implements ShowDAO {

	@Autowired
	SessionFactory sessionFactory;

	
	public List<Show> listShows() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		List<Show> shows=session.createQuery("from Show").getResultList();	
		return shows;
	}

	public Show getShowById(int showId) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Show show=(Show)session.createQuery("from Show where showId="+showId).getSingleResult();
		
		return show;
	}

	
	public void addShow(Show s) {
		
		Session session=sessionFactory.getCurrentSession();
		session.persist(s);
	}


	public void updateShow(Show s) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.update(s);
	}


	public void deleteShow(Show s) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.delete(s);
	}
	
	
	
}
