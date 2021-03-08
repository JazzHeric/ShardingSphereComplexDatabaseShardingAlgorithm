package com.test.sharding.config.sharding;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;


public class PreciseDatabaseShardingAlgorithm implements PreciseShardingAlgorithm<String> {

    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<String> preciseShardingValue) {
        String shardingNum = ShardingUtil.getShardingNum(preciseShardingValue.getValue());
        for (String dbName : collection) {
            if (dbName.endsWith(shardingNum)) {
                return dbName;
            }
        }
        throw new IllegalStateException();
    }

}
