package com.cyx.mall.common.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.cyx.mall.mapper")
public class MybatisConfig {
}
