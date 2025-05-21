package com.ssg.gallery.item.repository;

import com.ssg.gallery.item.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


//jpaRepository 인터페이스 확정 : 제너릭 타입으로 매개변수로 상품 item과 엔티티의 아이디의 데이터타입을 지정
public interface ItemRepository extends JpaRepository<Item, Integer> {
    //여러 아이디로 상품을 조회
    List<Item> findAllByIdIn(List<Integer> ids);
}
