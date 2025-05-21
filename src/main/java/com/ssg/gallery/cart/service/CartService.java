package com.ssg.gallery.cart.service;

import com.ssg.gallery.cart.entity.Cart;

import java.util.List;

public interface CartService {

    List<Cart> findAll(Integer memberId);

    void removeAll(Integer memberId);

    void remove(Integer memberId, Integer itId);


    void save(Cart cart);
}
