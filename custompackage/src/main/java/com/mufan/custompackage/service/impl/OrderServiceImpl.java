package com.mufan.custompackage.service.impl;

import com.mufan.custompackage.dao.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ Author     ：zyx.
 * @ Date       ：Created in 16:45 2019/1/14
 * @ Description：订单类service
 * % @author YuXingZh
 */
@Service
public class OrderServiceImpl {

    @Autowired
    private OrderMapper orderMapper;
}