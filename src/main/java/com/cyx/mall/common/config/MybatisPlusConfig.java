package com.cyx.mall.common.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: MybatisPlus配置
 * @author: cyx
 * @create: 2020/07/31
 */
@Configuration
public class MybatisPlusConfig {
    /**
     * @Author: cyx
     * @Description: 配置分页
     * @Date: 2020-07-31
     * @param:
     * @return: com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
