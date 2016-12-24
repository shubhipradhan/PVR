package com.cinema.SRSBackendQ.dao;

import java.util.List;

import com.cinema.SRSBackendQ.model.Show;

public interface ShowDAO {

	// TO SEE LIST OF SHOWS
	public List<Show> listShows();
	
	// TO GET SHOW FROM SHOW-ID
	public Show getShowById(int showId);
	
	// TO ADD NEW SHOW
	public void addShow(Show s);
	
	// TO UPDATE A SHOW
	public void updateShow(Show s);
	
	// To DELETE SHOW BY SHOW-ID
	public void deleteShow(Show s);
	
	
}
