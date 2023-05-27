package com.bookclub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.BookDao;
import com.bookclub.service.impl.MongoBookOfTheMonthDao;
import com.bookclub.service.impl.MongoWishlistDao;
import com.bookclub.web.HomeController;


@SpringBootTest
class BookclubApplicationTests {


  @Mock
  private BookDao bookDao;

  @Autowired
  private MongoWishlistDao mongoWishlistDao;

  @Mock
  private MongoBookOfTheMonthDao mongoBookOfTheMonthDao;

  @Mock
  private com.bookclub.model.WishlistItem wishlistItem;
  


  @Mock
  private MongoTemplate mongoTemplate;

  

  @Test
  public void test_getlist() {
    Query query = new Query();

    query.addCriteria(Criteria.where("username").is("username"));
    when(mongoTemplate.find(query, WishlistItem.class)).thenReturn(new ArrayList<>());

    assertEquals(0, mongoWishlistDao.list("username").size());

  }

  @Test
  public void test_remove() {
    Query query = new Query();

    query.addCriteria(Criteria.where("id").is("key"));

    when(mongoBookOfTheMonthDao.remove("key")).thenReturn(true);

    assertEquals(true, mongoBookOfTheMonthDao.remove("key"));
  }
  

}
