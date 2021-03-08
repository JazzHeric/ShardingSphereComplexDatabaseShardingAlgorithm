import com.test.sharding.TestApplication;
import com.test.sharding.entity.OrderDetail;
import com.test.sharding.entity.OrderInfo;
import com.test.sharding.mapper.OrderDetailMapper;
import com.test.sharding.mapper.OrderInfoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@SpringBootTest(classes = TestApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringJUnit4ClassRunner.class)
public class TestSharding {


    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Test
    public void insert() {
        OrderInfo orderInfo = OrderInfo.builder().merchantId("1122").storeId("334455").orderNo("20210301142308").payTime(new Date())
                .finishTime(new Date()).createTime(new Date()).build();
        orderInfoMapper.insert(orderInfo);

/*        OrderDetail orderDetail = OrderDetail.builder().orderNo("202103011423").merchantId("1122").goodsName("M6").goodsQuantity(1L)
                .createTime(new Date()).build();
        orderDetailMapper.insert(orderDetail);*/
    }

    @Test
    public void update() {
        OrderInfo orderInfo = OrderInfo.builder().merchantId("1122").orderNo("202103011423")
                .finishTime(new Date()).createTime(new Date()).build();
        orderInfoMapper.update(orderInfo);

        OrderDetail orderDetail = OrderDetail.builder().merchantId("1122").orderNo("202103011423").goodsName("AMG GT").build();
        orderDetailMapper.update(orderDetail);
    }

    @Test
    public void queryOrderDetail() {
        String orderNo = "202103011423";
        String merchantId = "1122";
        List<OrderDetail> orderDetailList = orderDetailMapper.queryDetail(orderNo, merchantId);
        System.out.println(orderDetailList);
    }

    @Test
    public void queryOrder() {
        String orderNo = "202103011102";
        String merchantId = "1122";
        List<OrderInfo> orderInfoList = orderInfoMapper.queryOrder(orderNo, merchantId);
        System.out.println(orderInfoList);

    }

    @Test
    public void  queryOrderWithoutMerchantId() {
        String orderNo = "20210301142308";
        List<OrderInfo> orderInfoList = orderInfoMapper.queryOrder(orderNo, null);
        System.out.println(orderInfoList);
    }
}
