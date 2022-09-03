package spring.study.restaurant.naver;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.study.restaurant.naver.dto.SearchImageReq;
import spring.study.restaurant.naver.dto.SearchLocalReq;

@SpringBootTest
class NaverClientTest {

    @Autowired
    private NaverClient naverClient;

    @Test
    void searchLocalTest() {

        var search = new SearchLocalReq();
        search.setQuery("갈비집");

        var result = naverClient.searchLocal(search);
        System.out.println("result = " + result);
    }

    @Test
    void searchImageTest() {

        var search = new SearchImageReq();
        search.setQuery("갈비집");

        var result = naverClient.searchImage(search);
        System.out.println("result = " + result);
    }
}