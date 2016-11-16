package com.accenture.Garcia.Hernan.ChickenTest.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.Garcia.Hernan.ChickenTest.data.ChickenDAO;
import com.accenture.Garcia.Hernan.ChickenTest.data.FarmDAO;
import com.accenture.Garcia.Hernan.ChickenTest.model.Chicken;
import com.accenture.Garcia.Hernan.ChickenTest.model.Farm;

@Controller
@RequestMapping("Chickens")
public class ChickenController {
	
	@Autowired
	ChickenDAO chickenDAO;
	@Autowired
	FarmDAO farmDAO;
	
	@RequestMapping("/{id}")
	public ModelAndView chickenList(@PathVariable("id")String farmId){
		ModelAndView m = new ModelAndView("Chickens/List");
		return m;
	}
	
	
	
	@RequestMapping("/list/{id}")
	public @ResponseBody Farm ListAjax(@PathVariable("id")String farmId){
		Farm farm = farmDAO.getFarm(Long.parseLong(farmId));
		return farm;
	}
		
		@RequestMapping("Delete/{id}")
	public @ResponseBody void DeleteAjax (@PathVariable("id")String id){
		
		chickenDAO.deleteChicken(Long.parseLong(id));
		
	}

	
		@RequestMapping(path="New/{id}", method=RequestMethod.POST)
		public @ResponseBody Chicken newChickenAjax(@PathVariable("id")String farmId, Chicken chicken){
			
			Farm farm =farmDAO.getFarm(Long.parseLong(farmId));
			
			chicken.setFarm(farm);
			
			
			chickenDAO.addChicken(chicken);
			return chicken ;

		}
	
		@RequestMapping(path="Update/{id}", method=RequestMethod.POST)
		public @ResponseBody void updateChickenAjax(@PathVariable("id")String farmId, Chicken chicken){
		
			Farm farm =farmDAO.getFarm(Long.parseLong(farmId));
			chicken.setFarm(farm);


			chickenDAO.updateChicken(chicken);

		}
	
	
	
	
	/*
	@RequestMapping("/{id}")
	public ModelAndView chickenList(@PathVariable("id")String farmId){
		ModelAndView m = new ModelAndView("Chickens/List");
		m.addObject("farm", farmDAO.getFarm(Long.parseLong(farmId)));

		return m;
	}
	
	
	@RequestMapping("Delete/{id}")
	public String Delete (@PathVariable("id")String id){
		
		Chicken c = chickenDAO.getChicken(Long.parseLong(id));
		long farmID = c.getFarm().getId();
		chickenDAO.deleteChicken(Long.parseLong(id));
		String redirect="redirect:/Chickens/"+farmID;
		return redirect;
	
	}
	
	@RequestMapping("New/{id}")
	public ModelAndView newChicken(@PathVariable("id")String farmId){
		
		ModelAndView m = new ModelAndView("Chickens/New");
		m.addObject("chicken", new Chicken());
		m.addObject("farm", farmDAO.getFarm(Long.parseLong(farmId)));
		return m;
	}

	@RequestMapping(path="New", method=RequestMethod.POST)
	public String newChickens(@ModelAttribute("chicken")Chicken chicken){
		String redirect="redirect:/Chickens/"+chicken.getFarm().getId();

		if(chicken.getName().isEmpty()){
			return redirect;

		}
		chickenDAO.addChicken(chicken);

		return redirect;
	}
	
	@RequestMapping("Update/{id}")
	public ModelAndView updateChicken(@PathVariable("id")String Id){
		
		ModelAndView m = new ModelAndView("Chickens/Update");
		m.addObject("chicken", chickenDAO.getChicken(Long.parseLong(Id)));
		return m;
	}
	
	@RequestMapping(path="Update", method=RequestMethod.POST)
	public String updateChickens(@ModelAttribute("chicken")Chicken chicken){
		String redirect="redirect:/Chickens/"+chicken.getFarm().getId();

		if(chicken.getName().isEmpty()){
			return redirect;

		}
		chickenDAO.updateChicken(chicken);

		return redirect;
	}
	
	*/
	
}
