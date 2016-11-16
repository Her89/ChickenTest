package com.accenture.Garcia.Hernan.ChickenTest.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name="chicken")
@Proxy(lazy=false)
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class Chicken {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="farmID")
	private Farm farm;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="chicken", cascade=CascadeType.REMOVE)
    @JsonManagedReference
	private List<Egg> eggList=new ArrayList<Egg>();
	
	
	public Chicken () {}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Egg> getEggList() {
		return eggList;
	}


	public void setEggList(List<Egg> eggList) {
		this.eggList = eggList;
	}


	public Farm getFarm() {
		return farm;
	}


	public void setFarm(Farm farm) {
		this.farm = farm;
	};
	
	
	

}
