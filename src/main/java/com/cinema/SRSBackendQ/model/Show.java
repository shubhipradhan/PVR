package com.cinema.SRSBackendQ.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Show {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int showId;
	private String area;
	private String city;
	private String movie;
	private int timing;
	private int noOfShow;
	
	public Show(){
		super();
	}

	public int getShowId() {
		return showId;
	}

	public void setShowId(int showId) {
		this.showId = showId;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getMovie() {
		return movie;
	}

	public void setMovie(String movie) {
		this.movie = movie;
	}

	public int getTiming() {
		return timing;
	}

	public void setTiming(int timing) {
		this.timing = timing;
	}

	public int getNoOfShow() {
		return noOfShow;
	}

	public void setNoOfShow(int noOfShow) {
		this.noOfShow = noOfShow;
	}
	
	

}
