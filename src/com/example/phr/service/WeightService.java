package com.example.phr.service;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import com.example.phr.model.User;
import com.example.phr.model.Weight;

public interface WeightService {
	
	public void addWeight(User user, BigDecimal weight, Date date, String description);
	
	public void updateWeight(Weight weight);
	
	public void deleteWeight(Weight weight);
	
	public List<Weight> getWeights(User user);
	
	public Weight getWeightGivenWeightId(long id);
}
