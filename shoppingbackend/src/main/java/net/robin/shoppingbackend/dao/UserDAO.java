package net.robin.shoppingbackend.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import net.robin.shoppingbackend.dto.Address;
import net.robin.shoppingbackend.dto.User;

@Service
public interface UserDAO {

	// user related operation
	User getByEmail(String email);
	User get(int id);

	boolean add(User user);
	
	// adding and updating a new address
	Address getAddress(int addressId);
	boolean addAddress(Address address);
	boolean updateAddress(Address address);
	Address getBillingAddress(int userId);
	List<Address> listShippingAddresses(int userId);
	

	
}
