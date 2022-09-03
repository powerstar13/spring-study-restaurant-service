package spring.study.restaurant.naver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchImageRes {

    private String lastBuildDate; // 검색 결과를 생성한 시간
    private int total; // 검색 결과 문서의 총 개수
    private int start; // 검색 결과 문서 중, 문서의 시작점
    private int display; // 검색 결과 개수
    private List<SearchImageItem> items; // 개별 검색 결과

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SearchImageItem {

        private String title; // 검색 결과 이미지의 제목
        private String link; // 검색 결과 이미지의 링크
        private String thumbnail; // 검색 결과 이미지의 썸네일 링크
        private String sizeheight; // 검색 결과 이미지의 썸네일 높이
        private String sizewidth; // 검색 결과 이미지의 너비 (단위는 pixel)
    }
}
