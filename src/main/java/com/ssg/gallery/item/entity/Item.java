package com.ssg.gallery.item.entity;


import com.ssg.gallery.item.dto.ItemRead;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String img_path;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private Integer discount_per;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime created;


    public ItemRead  toRead() {
        return ItemRead.builder().id(id)
                .name(name)
                .img_path(img_path)
                .price(price)
                .discount_per(discount_per)
                .build();
    }


}
