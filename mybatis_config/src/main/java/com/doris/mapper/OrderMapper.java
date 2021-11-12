package com.doris.mapper;

import com.doris.domain.Order;

import java.util.List;

public interface OrderMapper {
    public List<Order> findAll();
}
