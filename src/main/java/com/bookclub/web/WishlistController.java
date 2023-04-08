package com.bookclub.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookclub.model.WishlistItem;
import com.bookclub.service.impl.MemWishlistDao;
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
	
	@GetMapping
    public String showWishlsit(Model model) {
		System.out.println("list");
		MemWishlistDao memWishlistDao = new MemWishlistDao();
		List<WishlistItem> wishlist = memWishlistDao.list();
		model.addAttribute("wishlist", wishlist);
		System.out.println(wishlist);
		return "wishlist/list";
    }
	@GetMapping(value="/new")
	public String wishlistForm(Model model) {
		System.out.println("new!!!!");
		model.addAttribute("wishlistItem", new WishlistItem());
		return "wishlist/new";
	}
	
	@PostMapping(value="/addWishlistItem")
	public String addWishlistItemm(@Valid WishlistItem wishlistItem, BindingResult bindingResults) {
		System.out.println("empty");
		System.out.println(wishlistItem.toString());
		System.out.println(bindingResults.toString());
		if(bindingResults.hasErrors()) {
			return "wishlist/new";
		}
		return "redirect:/wishlist";
	}
}
