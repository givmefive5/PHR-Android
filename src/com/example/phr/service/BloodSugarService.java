package com.example.phr.service;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import com.example.phr.model.BloodSugar;
import com.example.phr.model.User;

public interface BloodSugarService {
	
	public void addBloodSugar(User user, BigDecimal glucoseLevel, Date date, String description);
	
	public void updateBloodSugar(BloodSugar bloodSugar);
	
	public void deleteBloodSugar(BloodSugar bloodSugar);
	
	public List<BloodSugar> getBloodSugars(User user);
	
	public BloodSugar getBloodSugarGivenBloodSugarId(long id);
}
