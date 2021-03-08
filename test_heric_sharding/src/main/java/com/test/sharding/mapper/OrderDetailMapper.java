package com.test.sharding.mapper;

import com.test.sharding.entity.OrderDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderDetailMapper {



    int insert(OrderDetail orderDetail);

    int update(OrderDetail orderDetail);

    List<OrderDetail> queryDetail(@Param("orderNo") String orderNo, @Param("merchantId") String merchantId);
}