package com.test.sharding.entity;


import java.io.Serializable;
import java.util.Date;

public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 1608891423021L;


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
    private String orderNo;

    /**
    * 
    * isNullAble:0
    */
    private String goodsName;

    /**
    * 
    * isNullAble:0
    */
    private Long goodsQuantity;

    /**
    * 
    * isNullAble:1
    */
    private Date createTime;

    private OrderDetail(Builder builder) {
        this.id = builder.id;
        this.merchantId = builder.merchantId;
        this.orderNo = builder.orderNo;
        this.goodsName = builder.goodsName;
        this.goodsQuantity = builder.goodsQuantity;
        this.createTime = builder.createTime;
    }

    public static Builder builder() {
        return new Builder();
    }


    public void setId(Long id){this.id = id;}

    public Long getId(){return this.id;}

    public void setMerchantId(String merchantId){this.merchantId = merchantId;}

    public String getMerchantId(){return this.merchantId;}

    public void setOrderNo(String orderNo){this.orderNo = orderNo;}

    public String getOrderNo(){return this.orderNo;}

    public void setGoodsName(String goodsName){this.goodsName = goodsName;}

    public String getGoodsName(){return this.goodsName;}

    public void setGoodsQuantity(Long goodsQuantity){this.goodsQuantity = goodsQuantity;}

    public Long getGoodsQuantity(){return this.goodsQuantity;}

    public void setCreateTime(Date createTime){this.createTime = createTime;}

    public Date getCreateTime(){return this.createTime;}


    @Override
    public String toString() {
        return "OrderDetail{" +
                "id='" + id + '\'' +
                "merchantId='" + merchantId + '\'' +
                "orderNo='" + orderNo + '\'' +
                "goodsName='" + goodsName + '\'' +
                "goodsQuantity='" + goodsQuantity + '\'' +
                "createTime='" + createTime + '\'' +
            '}';
    }


    public static final class Builder {
        private Long id;
        private String merchantId;
        private String orderNo;
        private String goodsName;
        private Long goodsQuantity;
        private Date createTime;

        private Builder() {
        }

        public OrderDetail build() {
            return new OrderDetail(this);
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder merchantId(String merchantId) {
            this.merchantId = merchantId;
            return this;
        }

        public Builder orderNo(String orderNo) {
            this.orderNo = orderNo;
            return this;
        }

        public Builder goodsName(String goodsName) {
            this.goodsName = goodsName;
            return this;
        }

        public Builder goodsQuantity(Long goodsQuantity) {
            this.goodsQuantity = goodsQuantity;
            return this;
        }

        public Builder createTime(Date createTime) {
            this.createTime = createTime;
            return this;
        }
    }

    public OrderDetail() {
    }

    public OrderDetail(Long id, String merchantId, String orderNo, String goodsName, Long goodsQuantity, Date createTime) {
        this.id = id;
        this.merchantId = merchantId;
        this.orderNo = orderNo;
        this.goodsName = goodsName;
        this.goodsQuantity = goodsQuantity;
        this.createTime = createTime;
    }
}
