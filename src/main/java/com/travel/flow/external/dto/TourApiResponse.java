package com.travel.flow.external.dto;

import lombok.Data;
import java.util.List;

@Data
public class TourApiResponse {
    private List<Item> items;
    @Data
    public static class Item {
        private Long contentid;
        private String title;
        private String addr1;
        private String mapx;
        private String mapy;
        private String cat3; // 카테고리 코드
        private String areacode;
    }
}