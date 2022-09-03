package spring.study.restaurant.naver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchLocalReq {

    private String query = ""; // 검색을 원하는 문자열로서 UTF-8로 인코딩해서 보내야 함
    private int display = 1; // 검색 결과 출력 건수 지정 (기본값 1, 최대 5)
    private int start = 1; // 검색 시작 위치로 1만 가능 (기본값 1, 최대 1)
    private String sort = "random"; // 정렬 옵션: random(유사도순), comment(카페/블로그 리뷰 개수 순)

    public MultiValueMap<String, String> toMultiValueMap() {

        var map = new LinkedMultiValueMap<String, String>();

        map.add("query", query);
        map.add("display", String.valueOf(display));
        map.add("start", String.valueOf(start));
        map.add("sort", sort);

        return map;
    }
}
