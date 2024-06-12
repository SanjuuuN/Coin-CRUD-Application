package com.dataAccessLayer;

import java.util.List;

import com.model.Coin;

public interface DataAccess {
	public void create(Coin coin);
	
	public boolean delete(String coinName);
	public List<Coin> getAllCoins();
	public void update(String coinnametoupdate, String coinvaluetoupdte);

	List<Coin> getAllcoins();
	
}
