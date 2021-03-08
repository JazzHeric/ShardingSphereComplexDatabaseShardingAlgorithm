package com.test.sharding.mapper;

import com.test.sharding.entity.OrderInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderInfoMapper {


    int insert(OrderInfo orderInfo);

    int update(OrderInfo orderInfo);

    List<OrderInfo> queryOrder(@Param("orderNo")String orderNo, @Param("merchantId") String merchantId);
}