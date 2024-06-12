package com.businessLogic;

import java.util.List;

import com.dataAccessLayer.DataAccess;
import com.dataAccessLayer.DataConnect;
import com.model.Coin;
public class CRUD {
	public void add(Coin coin) {
		DataAccess ref = new DataConnect();
		ref.create(coin);
	}
//	
//	public Coin read(String coinName) {
//        DataAccess ref = new DataConnect();
//        return ref.read(coinName);
//    }

   

	public static boolean delete(String coinName) {
	    DataAccess ref = new DataConnect();
	    return ref.delete(coinName); // Assuming DataAccess.delete(coinName) returns boolean
	}

//
//	public void update(String coinnametoupdate,String coinvaluetoupdte) {
//		
//		DataAccess ref=new DataConnect();
//		ref.update(coinnametoupdate, coinvaluetoupdte);
//		
//	}


    public static List<Coin> getAllCoins() {
        DataAccess ref = new DataConnect();
        return ref.getAllCoins();
    }



	public void update(String nm, String val) {
		// TODO Auto-generated method stub

		DataAccess ref=new DataConnect();
		ref.update(nm, val);
	}

	

}
