package spring.study.restaurant.naver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchLocalRes {

    private String lastBuildDate; // 검색 결과를 생성한 시간
    private int total; // 검색 결과 문서의 총 개수
    private int start; // 검색 결과 문서 중, 문서의 시작점
    private int display; // 검색 결과 개수
    private String category; // 검색 결과 업체, 기관의 분류 정보를 제공
    private List<SearchLocalItem> items; // 개별 검색 결과

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SearchLocalItem {

        private String title; // 검색 결과 업체, 기관명
        private String link; // 검색 결과 업체, 기관의 상세 정보가 제공되는 네이버 페이지의 링크
        private String description; // 검색 결과 업체, 기관명에 대한 설명
        private String address; // 검색 결과 업체, 기관명의 주소
        private String roadAddress; // 검색 결과 업체, 기관명의 도로명 주소
        private int mapx; // 검색 결과 업체, 기관명 위치 정보의 x좌표 (제공값은 카텍좌표계 값으로 제공되며, 지도 API와 연동 가능)
        private int mapy; // 검색 결과 업체, 기관명 위치 정보의 y좌표 (제공값은 카텍좌표계 값으로 제공되며, 지도 API와 연동 가능)
    }
}
