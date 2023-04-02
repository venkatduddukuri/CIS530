package com.bookclub.web;

import com.bookclub.model.Book;
import com.bookclub.service.dao.BookDao;
import com.bookclub.service.impl.MemBookDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.nio.file.Files;
import java.util.List;


/**
 *
 * Venkatarao, (2023). CIS 530 Server Side Java Programming. Bellevue University, all
 *
 * rights reserved.
 *
 * Purpose: HomeController class used to land home page.
 *
 */
@Controller
@RequestMapping("/")
public class HomeController {



  @RequestMapping(method = RequestMethod.GET)
  public String showHome(Model model) {
    BookDao booksDao = new MemBookDao();
    List<Book> books = booksDao.list();
    for (Book book : books){

    System.out.println(book.toString());
    }
    model.addAttribute("books", books);
    return "index";
  }
  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  public String getMonthlyBook(@PathVariable("id") String id, Model model) {
    String isbn=id;
    System.out.println(id);
    MemBookDao booksDao = new MemBookDao();
    Book book = booksDao.find(isbn);
    System.out.println(book.toString());

    model.addAttribute("book", book);

    return "monthly-books/view";
  }
   @RequestMapping(method = RequestMethod.GET, path = "/about")
  public String showAboutUs() {
    return "about";
  }

  @RequestMapping(method = RequestMethod.GET, path = "/contact")
  public String showContactUs() {
    return "contact";
  }
}
