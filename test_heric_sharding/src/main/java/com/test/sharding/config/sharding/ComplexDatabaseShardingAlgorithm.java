package com.test.sharding.config.sharding;

import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;


public class ComplexDatabaseShardingAlgorithm implements ComplexKeysShardingAlgorithm<String> {

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames,
                                         ComplexKeysShardingValue<String> shardingValue) {
        final String merchantIdColumnName = "merchant_id";
        final String orderNoColumnName = "order_no";
        Map<String, Collection<String>> columnNameAndShardingValuesMap = shardingValue.getColumnNameAndShardingValuesMap();
        String shardingNum = null;
        for(Map.Entry<String, Collection<String>> entry: columnNameAndShardingValuesMap.entrySet()) {
            if(CollectionUtils.isEmpty(entry.getValue())) continue;
            if(merchantIdColumnName.equals(entry.getKey())) {
                //不去支持in语法(项目中约定不使用in语法分库字段) 分表字段参数值只取第一位
                shardingNum = ShardingUtil.getShardingNum(entry.getValue().iterator().next());
                break;
            }
            if(orderNoColumnName.equals(entry.getKey())) {
                String orderNo = entry.getValue().iterator().next();
                shardingNum = orderNo.substring(orderNo.length() - 2);
            }
        }
        final String finalShardingNum = shardingNum;
        List<String> resultDataSource = Optional.ofNullable(availableTargetNames).orElse(Collections.emptyList()).stream()
                .filter(e -> e.endsWith(finalShardingNum)).collect(Collectors.toList());
        if(CollectionUtils.isEmpty(resultDataSource)) throw new IllegalStateException();
        return resultDataSource;
    }

}
