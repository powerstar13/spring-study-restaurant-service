package spring.study.restaurant.wishlist.entity;

import lombok.*;
import spring.study.restaurant.db.MemoryDbEntity;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WishListEntity extends MemoryDbEntity {

    private String title;                   // 음식명, 장소명
    private String category;                // 카테고리
    private String address;                 // 주소
    private String roadAddress;             // 도로명
    private String homePageLink;            // 홈페이지 주소
    private String imageLink;               // 음식, 가게 이미지 주소
    private boolean visit;                  // 방문 여부
    private int visitCount;                 // 방문 카운트
    private LocalDateTime lastVisitedDate;  // 마지막 방문일

    public void modifyTitle(String title) {
        this.title = title;
    }

    public void visited() {
        this.visit = true;
    }

    public void visitCountUp() {
        this.visitCount++;
    }
}
