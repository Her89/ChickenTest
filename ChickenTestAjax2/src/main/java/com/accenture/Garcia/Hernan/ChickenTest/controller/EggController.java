package com.accenture.Garcia.Hernan.ChickenTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.Garcia.Hernan.ChickenTest.data.ChickenDAO;
import com.accenture.Garcia.Hernan.ChickenTest.data.EggDAO;
import com.accenture.Garcia.Hernan.ChickenTest.data.FarmDAO;
import com.accenture.Garcia.Hernan.ChickenTest.model.Egg;
import com.accenture.Garcia.Hernan.ChickenTest.model.Farm;

@Controller
@RequestMapping("Eggs")
public class EggController {
	
	@Autowired
	EggDAO eggDAO;
	@Autowired
	ChickenDAO chickenDAO;
	@Autowired
	FarmDAO farmDAO;
	
	
	
	@RequestMapping("/{id}")
	public ModelAndView eggList(@PathVariable("id")String chickenId){
		
		ModelAndView m = new ModelAndView("Eggs/List");
		m.addObject("chicken", chickenDAO.getChicken(Long.parseLong(chickenId)));
		return m;
	}
	
	@RequestMapping("Delete/{id}")
	public String Delete (@PathVariable("id")String id){
		
		Egg egg = eggDAO.getEgg(Long.parseLong(id));
		long chickenID = egg.getChicken().getId();
		eggDAO.deleteEgg(Long.parseLong(id));
		String redirect="redirect:/Eggs/"+chickenID;
		return redirect;
	
	}
	
	@RequestMapping("New/{id}")
	public ModelAndView newEgg(@PathVariable("id")String chickenId){
		
		ModelAndView m = new ModelAndView("Eggs/New");
		m.addObject("egg", new Egg());
		m.addObject("chicken", chickenDAO.getChicken(Long.parseLong(chickenId)));
		return m;
	}
	
	@RequestMapping(path="New", method=RequestMethod.POST)
	public String newEggs(@ModelAttribute("egg")Egg egg){
		String redirect="redirect:/Eggs/"+egg.getChicken().getId();

		if(egg.getColor().isEmpty()){
			return redirect;

		}
		eggDAO.addEgg(egg);

		return redirect;
	}
	
	@RequestMapping("Update/{id}")
	public ModelAndView updateEgg(@PathVariable("id")String eggId){
		
		Egg egg = eggDAO.getEgg(Long.parseLong(eggId));
		ModelAndView m = new ModelAndView("Eggs/Update");
		Farm farm =farmDAO.getFarm(egg.getChicken().getFarm().getId());
		m.addObject("egg", egg );
		m.addObject("farm", farm);
		return m;
	}
	
	@RequestMapping(path="Update", method=RequestMethod.POST)
	public String updateEggs(@ModelAttribute("egg")Egg egg){
		String redirect="redirect:/Eggs/"+egg.getChicken().getId();

		if(egg.getColor().isEmpty()){
			return redirect;

		}
		eggDAO.updateEgg(egg);

		return redirect;
	}
	
	

	

}
