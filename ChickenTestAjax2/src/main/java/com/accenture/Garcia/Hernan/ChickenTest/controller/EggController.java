package com.accenture.Garcia.Hernan.ChickenTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.Garcia.Hernan.ChickenTest.data.ChickenDAO;
import com.accenture.Garcia.Hernan.ChickenTest.data.EggDAO;
import com.accenture.Garcia.Hernan.ChickenTest.data.FarmDAO;
import com.accenture.Garcia.Hernan.ChickenTest.model.Chicken;
import com.accenture.Garcia.Hernan.ChickenTest.model.Egg;
import com.accenture.Garcia.Hernan.ChickenTest.model.Farm;

@Controller
@RequestMapping("Eggs")
public class EggController {
	
	@Autowired
	EggDAO eggDAO;
	@Autowired
	ChickenDAO chickenDAO;

	
	
	
	@RequestMapping("/{id}")
	public ModelAndView eggList(@PathVariable("id")String chickenId){
		
		ModelAndView m = new ModelAndView("Eggs/List");
		return m;
	}
	
	@RequestMapping("/list/{id}")
	public @ResponseBody Chicken ListAjax(@PathVariable("id")String chickenId){
		Chicken chicken = chickenDAO.getChicken(Long.parseLong(chickenId));
		return chicken;
	}
	
	@RequestMapping("Delete/{id}")
	public @ResponseBody void DeleteAjax (@PathVariable("id")String id){
		
		eggDAO.deleteEgg(Long.parseLong(id));
		
	}
	

	@RequestMapping(path="New/{id}", method=RequestMethod.POST)
	public @ResponseBody Egg newEggAjax(@PathVariable("id")String chickenId, Egg egg){
		
		Chicken chicken = chickenDAO.getChicken(Long.parseLong(chickenId));
		
		egg.setChicken(chicken);
		
		
		eggDAO.addEgg(egg);
		return egg ;

	}
	
	@RequestMapping(path="Update/{id}", method=RequestMethod.POST)
	public @ResponseBody void updateEggAjax(@PathVariable("id")String chickenId, Egg egg){
	
		Chicken chicken = chickenDAO.getChicken(Long.parseLong(chickenId));
		egg.setChicken(chicken);


		eggDAO.updateEgg(egg);

	}



	

}
