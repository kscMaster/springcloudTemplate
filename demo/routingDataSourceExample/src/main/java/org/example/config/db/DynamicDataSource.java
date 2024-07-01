package org.example.config.db;//package com.example.config.db;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
/**
 * 动态数据源类
 * @date 2022/2/11
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        
        return DataSourceUtil.getDB();
    }
}