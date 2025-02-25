//package org.example;
//
//
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import javax.sql.DataSource;
//import java.util.List;
//import java.util.Map;
//
//
//@Slf4j
//@SpringBootTest
//public class Springboot2AdminStudyApplicationTests {
//
//    @Autowired
//    JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    @Qualifier("dynamicDataSource")
//    DataSource dataSource;
//    @Test
//    void contextLoads() {
//      // 执行一条sql语句，检查是否正常
//        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from adm_employee");
//        for (Map<String, Object> map : maps) {
//            System.out.println(map);
//        }
//
//      // 查看当前数据源，如果是Druid连接池，会出现下面两种提示的其中一种：
//      // 1. 当使用Starter整合的：当前数据源：com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceWrapper
//			// 2. 当使用自定义整合时：当前数据源：com.alibaba.druid.pool.DruidDataSource
//        log.info("当前数据源：{}",dataSource.getClass().getName());
//    }
//
//}