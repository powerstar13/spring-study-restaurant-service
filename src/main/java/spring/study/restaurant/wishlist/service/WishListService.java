package spring.study.restaurant.wishlist.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.study.restaurant.naver.NaverClient;
import spring.study.restaurant.naver.dto.SearchImageReq;
import spring.study.restaurant.naver.dto.SearchLocalReq;
import spring.study.restaurant.wishlist.dto.WishListDto;

@Service
@RequiredArgsConstructor
public class WishListService {

    private final NaverClient naverClient;

    public WishListDto search(String query) {

        // 1. 지역 검색
        var searchLocalReq = new SearchLocalReq();
        searchLocalReq.setQuery(query);

        var searchLocalRes = naverClient.searchLocal(searchLocalReq);

        if (searchLocalRes.getTotal() > 0) { // 지역 검색 결과가 있을 경우

            var localItem = searchLocalRes.getItems().stream().findFirst().get();

            var imageQuery = localItem.getTitle().replaceAll("<[^>]*>", ""); // title의 이상한 문자열을 모두 없애버리기

            // 2. 이미지 검색
            var searchImageReq = new SearchImageReq();
            searchImageReq.setQuery(imageQuery);

            var searchImageRes = naverClient.searchImage(searchImageReq);

            if (searchImageRes.getTotal() > 0) { // 이미지 검색 결과가 있을 경우

                var imageItem = searchImageRes.getItems().stream().findFirst().get();

                // 3. 결과 반환
                return WishListDto.builder()
                    .title(localItem.getTitle())
                    .category(localItem.getCategory())
                    .address(localItem.getAddress())
                    .readAddress(localItem.getRoadAddress())
                    .homePageLink(localItem.getLink())
                    .imageLink(imageItem.getLink())
                    .build();
            }
        }

        // 검색 결과가 없는 반환
        return new WishListDto();
    }
}