package com.test.sharding.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.google.common.collect.Maps;
import com.test.sharding.config.sharding.ComplexDatabaseShardingAlgorithm;
import com.test.sharding.config.sharding.PreciseDatabaseShardingAlgorithm;
import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.TableRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.ComplexShardingStrategyConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.StandardShardingStrategyConfiguration;
import org.apache.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

@Configuration
public class DataSourceConfig {

    @Bean("dataSource00")
    public DataSource druidDataSource00(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(dbUrl00);
        setConnectionProperty(druidDataSource);
        return druidDataSource;
    }

    @Bean("dataSource01")
    public DataSource druidDataSource01(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(dbUrl01);
        setConnectionProperty(druidDataSource);
        return druidDataSource;
    }

    @Bean("dataSource02")
    public DataSource druidDataSource02(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(dbUrl02);
        setConnectionProperty(druidDataSource);
        return druidDataSource;
    }

    @Bean("dataSource03")
    public DataSource druidDataSource03(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(dbUrl03);
        setConnectionProperty(druidDataSource);
        return druidDataSource;
    }

    @Bean("dataSource04")
    public DataSource druidDataSource04(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(dbUrl04);
        setConnectionProperty(druidDataSource);
        return druidDataSource;
    }

    @Bean("dataSource05")
    public DataSource druidDataSource05(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(dbUrl05);
        setConnectionProperty(druidDataSource);
        return druidDataSource;
    }

    @Bean("dataSource06")
    public DataSource druidDataSource06(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(dbUrl06);
        setConnectionProperty(druidDataSource);
        return druidDataSource;
    }

    @Bean("dataSource07")
    public DataSource druidDataSource07(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(dbUrl07);
        setConnectionProperty(druidDataSource);
        return druidDataSource;
    }

    @Bean("dataSource08")
    public DataSource druidDataSource08(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(dbUrl08);
        setConnectionProperty(druidDataSource);
        return druidDataSource;
    }

    @Bean("dataSource09")
    public DataSource druidDataSource09(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(dbUrl09);
        setConnectionProperty(druidDataSource);
        return druidDataSource;
    }

    private void setConnectionProperty(DruidDataSource druidDataSource) {
        druidDataSource.setUsername(userName);
        druidDataSource.setPassword(password);
        druidDataSource.setDriverClassName(driverClassName);
        druidDataSource.setInitialSize(initialSize);
        druidDataSource.setMinIdle(minIdle);
        druidDataSource.setMaxActive(maxActive);
        druidDataSource.setMaxWait(maxWait);
        druidDataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        druidDataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        druidDataSource.setValidationQuery(validationQuery);
        druidDataSource.setTestWhileIdle(testWhileIdle);
        druidDataSource.setTestOnBorrow(testOnBorrow);
        druidDataSource.setTestOnReturn(testOnReturn);
    }


    private Map<String, DataSource> buildDataSourceMap() {
        Map<String, DataSource> result = Maps.newHashMap();
        result.put("db_source_00", druidDataSource00());
        result.put("db_source_01", druidDataSource01());
        result.put("db_source_02", druidDataSource02());
        result.put("db_source_03", druidDataSource03());
        result.put("db_source_04", druidDataSource04());
        result.put("db_source_05", druidDataSource05());
        result.put("db_source_06", druidDataSource06());
        result.put("db_source_07", druidDataSource07());
        result.put("db_source_08", druidDataSource08());
        result.put("db_source_09", druidDataSource09());
        return result;
    }

    @Bean("shardingDataSource")
    DataSource getShardingDataSource() throws SQLException {

        //设置表精准sharding规则
        TableRuleConfiguration orderDetailTableRule = new TableRuleConfiguration("order_detail");
        StandardShardingStrategyConfiguration standardShardingStrategyConfiguration =
                new StandardShardingStrategyConfiguration("merchant_id",
                new PreciseDatabaseShardingAlgorithm());
        orderDetailTableRule.setDatabaseShardingStrategyConfig(standardShardingStrategyConfiguration);

        //设置表复杂sharding规则
        TableRuleConfiguration orderInfoTableRule = new TableRuleConfiguration("order_info");
        ComplexShardingStrategyConfiguration complexShardingStrategyConfiguration =
                new ComplexShardingStrategyConfiguration("order_no,merchant_id",
                new ComplexDatabaseShardingAlgorithm());
        orderInfoTableRule.setDatabaseShardingStrategyConfig(complexShardingStrategyConfiguration);

        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        shardingRuleConfig.getTableRuleConfigs().add(orderDetailTableRule);
        shardingRuleConfig.getTableRuleConfigs().add(orderInfoTableRule);

        shardingRuleConfig.getBindingTableGroups().add("order_detail,order_info");
        //设置默认规则
        shardingRuleConfig.setDefaultDatabaseShardingStrategyConfig(standardShardingStrategyConfiguration);

        return ShardingDataSourceFactory.createDataSource(buildDataSourceMap(), shardingRuleConfig, new Properties());
    }

    @Bean
    public PlatformTransactionManager shardingTransactionManager() throws Exception {
        return new DataSourceTransactionManager(getShardingDataSource());
    }



    /** ---------------------数据库连接配置----------------------*/
    @Value("${spring.datasource.url_00}")
    private String dbUrl00;

    @Value("${spring.datasource.url_01}")
    private String dbUrl01;

    @Value("${spring.datasource.url_02}")
    private String dbUrl02;

    @Value("${spring.datasource.url_03}")
    private String dbUrl03;

    @Value("${spring.datasource.url_04}")
    private String dbUrl04;

    @Value("${spring.datasource.url_05}")
    private String dbUrl05;

    @Value("${spring.datasource.url_06}")
    private String dbUrl06;

    @Value("${spring.datasource.url_07}")
    private String dbUrl07;

    @Value("${spring.datasource.url_08}")
    private String dbUrl08;

    @Value("${spring.datasource.url_09}")
    private String dbUrl09;

    @Value("${spring.datasource.username}")
    private String userName;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.initialSize}")
    private int initialSize;

    @Value("${spring.datasource.minIdle}")
    private int minIdle;

    @Value("${spring.datasource.maxActive}")
    private int maxActive;

    @Value("${spring.datasource.maxWait}")
    private int maxWait;

    @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;

    @Value("${spring.datasource.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;

    @Value("${spring.datasource.validationQuery}")
    private String validationQuery;

    @Value("${spring.datasource.testWhileIdle}")
    private boolean testWhileIdle;

    @Value("${spring.datasource.testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${spring.datasource.testOnReturn}")
    private boolean testOnReturn;
}
