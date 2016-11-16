package com.accenture.Garcia.Hernan.ChickenTest.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.accenture.Garcia.Hernan.ChickenTest.model.Chicken;
import com.accenture.Garcia.Hernan.ChickenTest.model.Egg;
import com.accenture.Garcia.Hernan.ChickenTest.model.Farm;

public class FarmTest {

	Farm farm;
	
	@Before 
	public void setUp(){
		System.out.println("before");
		farm= new Farm();
		
		Chicken chick = new Chicken();
		
		Egg egg1 = new Egg();
		Egg egg2 = new Egg();
		Egg egg3 = new Egg();

		chick.getEggList().add(egg1);
		chick.getEggList().add(egg2);
		chick.getEggList().add(egg3);

		farm.getChickenList().add(chick);
		
	}
	
	@Test
	public void countTest(){
		
		long result = farm.totalEggs();
		System.out.println(result);
		long expected = 3;
		
		assertEquals(expected, result);
		
	}
}
