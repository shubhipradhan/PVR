package com.cinema.PVRFrontend.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cinema.SRSBackendQ.dao.ShowDAO;
import com.cinema.SRSBackendQ.model.Show;

@Controller
public class HomeController {
	
	@Autowired
	ShowDAO showDAO;
	
	@RequestMapping("/")
	public ModelAndView indexPage()
	{
		List<Show> listShows=showDAO.listShows();
		ModelAndView model=new ModelAndView("index");
		model.addObject("show",new Show());
		model.addObject("listShows", listShows);
		return model;
	}
	
	/*@RequestMapping(value="/show/add")
	public ModelAndView addShowPage(){
		ModelAndView model=new ModelAndView("add");
		model.addObject("show",new Show());
		model.addObject("addShows",addShows);
	}*/
	
	@RequestMapping(value="login")
	public ModelAndView loginPage(){
		ModelAndView model=new ModelAndView("login");
		return model;
	}

}

