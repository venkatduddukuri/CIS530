package com.bookclub.web;

import java.util.List;

import javax.validation.Valid;

import com.bookclub.service.dao.WishlistDao;
import com.bookclub.service.impl.MongoWishlistDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookclub.model.WishlistItem;

/**
*
* venkatduddukuri, (2023). CIS 530 Server Side Java Programming. Bellevue University, all
*
* rights reserved.
*
* Purpose: WishlistController class used to display/modify wish list Items.
*
*/
@Controller
@RequestMapping("/wishlist")
public class WishlistController {

	WishlistDao wishlistDao = new MongoWishlistDao();

	@Autowired
	private void setWishlistDao(WishlistDao wishlistDao) {
		this.wishlistDao = wishlistDao;
	}
	@GetMapping
    public String showWishlsit(Model model) {
		List<WishlistItem> wishlistItem = wishlistDao.list();

		model.addAttribute("wishlistItem", wishlistItem);
		return "wishlist/list";
    }
	@GetMapping(value="/new")
	public String wishlistForm(Model model) {
		System.out.println("new!!!!");
		model.addAttribute("wishlistItem", new WishlistItem());
		return "wishlist/new";
	}
	
	@PostMapping(value="/addWishlistItem")
	public String addWishlistItemm(@Valid WishlistItem wishlistItem, BindingResult bindingResults){

		if (bindingResults.hasErrors()) {
			return "wishlist/new";
		}

		wishlistDao.add(wishlistItem); // add the record to MongoDB

		return "redirect:/wishlist";
	}
}
