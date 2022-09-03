package spring.study.restaurant.wishlist.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.study.restaurant.wishlist.dto.WishListDto;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WishListServiceTest {

    @Autowired
    private WishListService wishListService;

    @Test
    void searchTest() {

        var result = wishListService.search("갈비집");

        System.out.println("result = " + result);

        assertNotNull(result);
    }
}