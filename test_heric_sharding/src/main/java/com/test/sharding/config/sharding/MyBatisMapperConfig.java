package com.test.sharding.config.sharding;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * @author gxz
 * @date 2020/10/23 13:56
 */
@Configuration
@Order(4)
public class MyBatisMapperConfig {

    @Bean
    public MapperScannerConfigurer shardingMapperScannerConfigurer() {
      MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
      mapperScannerConfigurer.setSqlSessionFactoryBeanName("shardingSessionFactory");
      mapperScannerConfigurer.setBasePackage("com.test.sharding.mapper");
      return mapperScannerConfigurer;
    }



}
