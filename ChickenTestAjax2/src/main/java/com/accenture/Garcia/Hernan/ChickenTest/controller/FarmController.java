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

import com.accenture.Garcia.Hernan.ChickenTest.data.FarmDAO;
import com.accenture.Garcia.Hernan.ChickenTest.model.Farm;


@Controller
@RequestMapping("Farms")
public class FarmController {
	
	@Autowired
	FarmDAO farmDAO;
	
	/*
	@RequestMapping("/")
	public ModelAndView List(){
		List<Farm> farmList = farmDAO.listFarm();
		return new ModelAndView("Farms/List","farmList", farmList);
	}


	// delete sin ajax
	
	@RequestMapping("Delete/{id}")
	public String Delete (@PathVariable("id")String id){
		
		farmDAO.deleteFarm(Long.parseLong(id));
		return "redirect:/Farms/";
	}

	*/
	
	@RequestMapping("New")
	public ModelAndView newFarm(){
		
		ModelAndView m = new ModelAndView("Farms/New");
		m.addObject("farm", new Farm());
		return m;
	}
	/*
	@RequestMapping(path="New", method=RequestMethod.POST)
	public String newFarms(@ModelAttribute("farm")Farm farm){
		if(farm.getName().isEmpty()){
			return "redirect:/Farms/";
		}
		farmDAO.addFarm(farm);

		return "redirect:/Farms/";
	}
	


	@RequestMapping("Update/{id}")
	public ModelAndView updateFarm(@PathVariable("id")String Id){
		
		ModelAndView m = new ModelAndView("Farms/Update");
		m.addObject("farm", farmDAO.getFarm(Long.parseLong(Id)));
		return m;
	}
	
	@RequestMapping(path="Update", method=RequestMethod.POST)
	public String updateFarms(@ModelAttribute("farm")Farm farm){
		if(farm.getName().isEmpty()){
			return "redirect:/Farms/";

		}
		farmDAO.updateFarm(farm);

		return "redirect:/Farms/";
	}
	
	*/
	//list aJAx


	@RequestMapping("/")
	public ModelAndView List1(){
		ModelAndView m = new ModelAndView("Farms/List");

		m.addObject("farm", new Farm());

		return m;
	}
	
	@RequestMapping("/list")
	public @ResponseBody List<Farm> ListAjax(){
		List<Farm> farmList = farmDAO.listFarm();
		return farmList;
	}
		
		
		@RequestMapping("Delete/{id}")
	public @ResponseBody void DeleteAjax (@PathVariable("id")String id){
		
		farmDAO.deleteFarm(Long.parseLong(id));
		
	}

	
		@RequestMapping(path="New", method=RequestMethod.POST)
		public @ResponseBody Farm newFarmAjax(Farm farm){
			
			farmDAO.addFarm(farm);
			return farm;

		}
	
		@RequestMapping(path="Update", method=RequestMethod.POST)
		public @ResponseBody void updateFarmAjax(Farm farm){
		
			farmDAO.updateFarm(farm);

		}
	

}
