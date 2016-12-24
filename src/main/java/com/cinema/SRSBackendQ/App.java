package com.cinema.SRSBackendQ;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;


import com.cinema.SRSBackendQ.model.Show;
import com.cinema.SRSBackendQ.dao.ShowDAO;
import com.cinema.SRSBackendQ.config.AppContextConfig;

/**
 * Hello world!
 *
 */
public class App 
{
	
	
	
    public static void main( String[] args )
    {
    	 AbstractApplicationContext context=new AnnotationConfigApplicationContext(AppContextConfig.class);    	
    	
    	 ShowDAO showDAO=(ShowDAO)context.getBean("showDAO");
    	/*
    	Show show=new Show();
    	show.setMovie("RAMLEELA");
    	show.setCity("DELHI");
    	show.setArea("Uttar Pradesh");
    	show.setTiming(2);
    	show.setNoOfShow(5);
    	
        System.out.println( "Hello World!" );
        
        showDAO.addShow(show);
        */
    	 List<Show> shows=showDAO.listShows();
         for(Show show:shows)
         {
         	System.out.println("ID:"+show.getShowId());
         	System.out.println("Name:"+show.getMovie());
         	System.out.println("Country:"+show.getArea());
         }
         
    }
    
}
