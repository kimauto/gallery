package com.ssg.gallery.item.dto;

//상품을 조회 DTO
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ItemRead {
    private  Integer id;
    private  String name;
    private  String img_path;
    private  Integer price;
    private Integer discount_per;

}
