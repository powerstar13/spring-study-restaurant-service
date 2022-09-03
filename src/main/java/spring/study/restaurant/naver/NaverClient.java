package spring.study.restaurant.naver;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import spring.study.restaurant.naver.dto.SearchImageReq;
import spring.study.restaurant.naver.dto.SearchImageRes;
import spring.study.restaurant.naver.dto.SearchLocalReq;
import spring.study.restaurant.naver.dto.SearchLocalRes;

@Component
@RequiredArgsConstructor
public class NaverClient {

    @Value("${naver.client.id}")
    private String naverClientId;
    @Value("${naver.client.secret}")
    private String naverSecret;

    @Value("${naver.url.search.local}")
    private String naverSearchLocalUrl;
    @Value("${naver.url.search.image}")
    private String naverSearchImageUrl;

    private final RestTemplate restTemplate;

    /**
     * 지역 검색 API 연동
     */
    public SearchLocalRes searchLocal(SearchLocalReq request) {

        var uri = UriComponentsBuilder.fromUriString(naverSearchLocalUrl)
            .queryParams(request.toMultiValueMap())
            .encode()
            .build()
            .toUri();

        var headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", naverClientId);
        headers.set("X-Naver-Client-Secret", naverSecret);
        headers.setContentType(MediaType.APPLICATION_JSON);

        var httpEntity = new HttpEntity<>(headers);
        var responseType = new ParameterizedTypeReference<SearchLocalRes>(){};

        var responseEntity = restTemplate.exchange(uri, HttpMethod.GET, httpEntity, responseType);

        return responseEntity.getBody();
    }

    /**
     * 이미지 검색 API 연동
     */
    public SearchImageRes searchImage(SearchImageReq request) {

        var uri = UriComponentsBuilder.fromUriString(naverSearchImageUrl)
            .queryParams(request.toMultiValueMap())
            .encode()
            .build()
            .toUri();

        var headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", naverClientId);
        headers.set("X-Naver-Client-Secret", naverSecret);
        headers.setContentType(MediaType.APPLICATION_JSON);

        var httpEntity = new HttpEntity<>(headers);
        var responseType = new ParameterizedTypeReference<SearchImageRes>(){};

        var responseEntity = restTemplate.exchange(uri, HttpMethod.GET, httpEntity, responseType);

        return responseEntity.getBody();
    }
}
