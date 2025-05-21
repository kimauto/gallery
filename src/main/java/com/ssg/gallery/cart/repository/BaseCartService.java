package com.ssg.gallery.cart.repository;

import com.ssg.gallery.cart.entity.Cart;
import com.ssg.gallery.cart.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BaseCartService implements CartService {

    private final CartRepository cartRepository;
    @Override
    public List<Cart> findAll(Integer memberId) {
        List<Cart> allByMemberId = cartRepository.findAllByMemberId(memberId);
        return allByMemberId;
    }

    @Override
    public void removeAll(Integer memberId) {

    }

    @Override
    public void remove(Integer memberId, Integer itId) {

    }

    @Override
    public void save(Cart cart) {

    }
}
