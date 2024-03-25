package com.app.service;
import com.app.model.*;

public interface AddressService {
	
	Address saveAddress(Address address);
	
	Address findAddress(int id);
}
