package com.test.sharding.config.sharding;

import org.apache.commons.lang3.StringUtils;

public class ShardingUtil {

    private static final int DB_COUNT = 10;

    public static String getShardingNum(String routeKey) {
        if (StringUtils.isBlank(routeKey)) {
            throw new IllegalArgumentException("empty routeKey");
        }

        int hashValue = routeKey.hashCode();
        if (hashValue < 0) {
            hashValue = Math.abs(hashValue);
        }
        return String.format("%02d", hashValue % DB_COUNT);
    }

    public static void main(String[] args) {
        System.out.println(ShardingUtil.getShardingNum("1122"));
    }
}
