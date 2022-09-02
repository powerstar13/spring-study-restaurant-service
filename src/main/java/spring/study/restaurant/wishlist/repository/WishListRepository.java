package spring.study.restaurant.wishlist.repository;

import org.springframework.stereotype.Repository;
import spring.study.restaurant.db.MemoryDbRepositoryAbstract;
import spring.study.restaurant.wishlist.entity.WishListEntity;

@Repository
public class WishListRepository extends MemoryDbRepositoryAbstract<WishListEntity> {
}
