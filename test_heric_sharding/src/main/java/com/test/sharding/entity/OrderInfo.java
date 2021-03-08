package com.test.sharding.entity;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

public class OrderInfo implements Serializable {

    private static final long serialVersionUID = 1608891426540L;


    /**
    * 主键
    * 
    * isNullAble:0
    */
    private Long id;

    /**
    * 
    * isNullAble:0
    */
    private String merchantId;

    /**
    * 
    * isNullAble:0
    */
    private String storeId;

    /**
    * 
    * isNullAble:0
    */
    private String orderNo;

    /**
    * 
    * isNullAble:1
    */
    private Date payTime;

    /**
    * 
    * isNullAble:1
    */
    private Date finishTime;

    /**
    * 
    * isNullAble:1
    */
    private Date createTime;

    private OrderInfo(Builder builder) {
        this.id = builder.id;
        this.merchantId = builder.merchantId;
        this.storeId = builder.storeId;
        this.orderNo = builder.orderNo;
        this.payTime = builder.payTime;
        this.finishTime = builder.finishTime;
        this.createTime = builder.createTime;
    }

    public static Builder builder() {
        return new Builder();
    }


    public void setId(Long id){this.id = id;}

    public Long getId(){return this.id;}

    public void setMerchantId(String merchantId){this.merchantId = merchantId;}

    public String getMerchantId(){return this.merchantId;}

    public void setStoreId(String storeId){this.storeId = storeId;}

    public String getStoreId(){return this.storeId;}

    public void setOrderNo(String orderNo){this.orderNo = orderNo;}

    public String getOrderNo(){return this.orderNo;}

    public void setPayTime(Date payTime){this.payTime = payTime;}

    public Date getPayTime(){return this.payTime;}

    public void setFinishTime(Date finishTime){this.finishTime = finishTime;}

    public Date getFinishTime(){return this.finishTime;}

    public void setCreateTime(Date createTime){this.createTime = createTime;}

    public Date getCreateTime(){return this.createTime;}


    @Override
    public String toString() {
        return "OrderInfo{" +
                "id='" + id + '\'' +
                "merchantId='" + merchantId + '\'' +
                "storeId='" + storeId + '\'' +
                "orderNo='" + orderNo + '\'' +
                "payTime='" + payTime + '\'' +
                "finishTime='" + finishTime + '\'' +
                "createTime='" + createTime + '\'' +
            '}';
    }

    public static final class Builder {
        private Long id;
        private String merchantId;
        private String storeId;
        private String orderNo;
        private Date payTime;
        private Date finishTime;
        private Date createTime;

        private Builder() {
        }

        public OrderInfo build() {
            return new OrderInfo(this);
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder merchantId(String merchantId) {
            this.merchantId = merchantId;
            return this;
        }

        public Builder storeId(String storeId) {
            this.storeId = storeId;
            return this;
        }

        public Builder orderNo(String orderNo) {
            this.orderNo = orderNo;
            return this;
        }

        public Builder payTime(Date payTime) {
            this.payTime = payTime;
            return this;
        }

        public Builder finishTime(Date finishTime) {
            this.finishTime = finishTime;
            return this;
        }

        public Builder createTime(Date createTime) {
            this.createTime = createTime;
            return this;
        }
    }

    public OrderInfo() {
    }

    public OrderInfo(Long id, String merchantId, String storeId, String orderNo, Date payTime, Date finishTime, Date createTime) {
        this.id = id;
        this.merchantId = merchantId;
        this.storeId = storeId;
        this.orderNo = orderNo;
        this.payTime = payTime;
        this.finishTime = finishTime;
        this.createTime = createTime;
    }
}
