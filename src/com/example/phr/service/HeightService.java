package com.example.phr.service;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import com.example.phr.model.Height;
import com.example.phr.model.User;

public interface HeightService {
	
	public void addHeight(User user, BigDecimal heightInInches, Date date, String description);
	
	public void updateHeight(Height height);
	
	public void deleteHeight(Height height);
	
	public List<Height> getHeights(User user);
	
	public Height getHeightGivenHeightId(long id);
}
