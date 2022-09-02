package spring.study.restaurant.wishlist.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.study.restaurant.wishlist.entity.WishListEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WishListRepositoryTest {

    @Autowired
    private WishListRepository wishListRepository;

    private WishListEntity create() {

        return WishListEntity.builder()
            .title("title")
            .category("category")
            .address("address")
            .readAddress("readAddress")
            .homePageLink("")
            .imageLink("")
            .visit(false)
            .visitCount(0)
            .lastVisitedDate(null)
            .build();
    }

    @Test
    void saveTest() {

        var wishListEntity = this.create();
        var expected = wishListRepository.save(wishListEntity);

        assertAll(() -> {
            assertNotNull(expected);
            assertEquals(1, expected.getIndex());
        });
    }

    @Test
    void updateTest() {

        var wishListEntity = this.create();
        var savedEntity = wishListRepository.save(wishListEntity);

        savedEntity.modifyTitle("update title");
        var expected = wishListRepository.save(savedEntity);

        assertAll(() -> {
            assertNotNull(expected);
            assertEquals("update title", expected.getTitle());
            assertEquals(1, wishListRepository.findAll().size());
        });
    }

    @Test
    void findByIdTest() {

        var wishListEntity = this.create();
        wishListRepository.save(wishListEntity);

        var expected = wishListRepository.findById(1);

        assertAll(() -> {
            assertTrue(expected.isPresent());
            assertEquals(1, expected.get().getIndex());
        });
    }

    @Test
    void deleteByIdTest() {

        var wishListEntity = this.create();
        wishListRepository.save(wishListEntity);

        wishListRepository.deleteById(1);

        int count = wishListRepository.findAll().size();

        assertEquals(0, count);
    }

    @Test
    void findAllTest() {

        var wishListEntity1 = this.create();
        wishListRepository.save(wishListEntity1);
        var wishListEntity2 = this.create();
        wishListRepository.save(wishListEntity2);

        int count = wishListRepository.findAll().size();

        assertEquals(2, count);
    }
}