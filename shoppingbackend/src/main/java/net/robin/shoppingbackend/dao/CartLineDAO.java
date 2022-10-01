package net.robin.shoppingbackend.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import net.robin.shoppingbackend.dto.Cart;
import net.robin.shoppingbackend.dto.CartLine;
import net.robin.shoppingbackend.dto.OrderDetail;


@Service
public interface CartLineDAO {

	public List<CartLine> list(int cartId);
	public CartLine get(int id);	
	public boolean add(CartLine cartLine);
	public boolean update(CartLine cartLine);
	public boolean remove(CartLine cartLine);
	
	// fetch the CartLine based on cartId and productId
	public CartLine getByCartAndProduct(int cartId, int productId);		
		
	// updating the cart
	boolean updateCart(Cart cart);
	
	// list of available cartLine
	public List<CartLine> listAvailable(int cartId);
	
	// adding order details
	boolean addOrderDetail(OrderDetail orderDetail);

	
}
