package com.atguigu.admin;

import com.alibaba.druid.pool.DruidDataSource;
import com.atguigu.admin.bean.User;
import com.atguigu.admin.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
class BootWebAdminApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    DataSource dataSource;
    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        Long aLong = jdbcTemplate.queryForObject("select count(*) from t_user", Long.class);
        log.info("记录总数:{}",aLong);
        log.info("数据源类型:{}",dataSource.getClass());
    }

    @Test
    void maTest(){
        User user = userMapper.selectById(1);
        log.info("用户信息:{}",user);
    }

}
