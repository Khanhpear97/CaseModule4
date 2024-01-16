package com.example.casemodule4.service;

import com.example.casemodule4.model.CartDetail;

public interface ICartDetailService {
    Iterable<CartDetail> findAllByStatus();
}
