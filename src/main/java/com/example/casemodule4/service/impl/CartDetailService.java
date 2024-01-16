package com.example.casemodule4.service.impl;

import com.example.casemodule4.model.CartDetail;
import com.example.casemodule4.service.ICartDetailService;
import org.springframework.stereotype.Service;

@Service
public class CartDetailService implements ICartDetailService {
    @Override
    public Iterable<CartDetail> findAllByStatus() {
        return null;
    }
}
