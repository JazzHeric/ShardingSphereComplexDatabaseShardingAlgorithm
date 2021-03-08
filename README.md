# ShardingSphereComplexDatabaseShardingAlgorithm

A test project for ShardingSphere 4.1.1 version 

一个测试ShardingSphere 4.1.1复杂分片的项目

mysql table script：
```sql

DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `merchant_id` varchar(64) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NOT NULL,
  `store_id` varchar(64) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NOT NULL,
  `order_no` varchar(64) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NOT NULL,
  `pay_time` datetime NULL DEFAULT NULL,
  `finish_time` datetime NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = gb2312 COLLATE = gb2312_chinese_ci ROW_FORMAT = Compact;

DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `merchant_id` varchar(64) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NOT NULL,
  `order_no` varchar(64) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NOT NULL,
  `goods_name` varchar(128) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NOT NULL,
  `goods_quantity` bigint(20) NOT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = gb2312 COLLATE = gb2312_chinese_ci ROW_FORMAT = Compact;

```

