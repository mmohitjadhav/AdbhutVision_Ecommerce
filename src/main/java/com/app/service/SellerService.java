package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.dto.SellerDto;
import com.app.model.Seller;

public interface SellerService {

	Seller registerSeller(SellerDto sellerDto);

	Seller validate(String email, String password);

	List<Seller> findAllSellers();

	Optional<Seller> findSellerById(int id);

	void updateProfile(Seller seller, int id);

	Seller findByEmail(String email);

	void resetPassword(Seller seller, String password);

}

