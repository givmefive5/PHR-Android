package com.example.phr.service;

import java.util.List;

import com.example.phr.model.Weight;

public interface WeightService {

	//no Id
	public void addWeight(String username, Weight weight);
	
	//Id cannot be left blank, will update the values of old weight with that Id
	public void updateWeight(String username, Weight weight);
	
	//should never have invalid weightId
	public void deleteWeight(String username, long weightId);
	
	//get all inputted weights of user
	public List<Weight> getWeights(String username);
	
	public Weight getWeight(String username, long weightId);
}
