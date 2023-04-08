package com.bookclub.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;

public class MemWishlistDao implements WishlistDao {

	private List<WishlistItem> wishlist;
	
	public MemWishlistDao() {
		wishlist = new ArrayList<WishlistItem>();
		wishlist.add(new WishlistItem("1234567890", "Book 1"));
		wishlist.add(new WishlistItem("2345678901", "Book 2"));
	}

	@Override
	public List<WishlistItem> list() {
		return this.wishlist;
	}

	@Override
	public WishlistItem find(String key) {
		 for (WishlistItem wishlistItem:this.wishlist){
	            if(wishlistItem.getIsbn().equals(key)){
	                return wishlistItem;
	            }
	        }
	        return new WishlistItem();
	}

}
