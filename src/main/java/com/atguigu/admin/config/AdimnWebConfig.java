package com.atguigu.admin.config;

import com.atguigu.admin.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器的使用步骤:
 * 1.编写一个拦截器实现HandlerInterceptor接口
 * 2.拦截器注册到容器中(实现WebMvcConfigurer的addInterceptors)
 * 3.指定拦截规则【如果是拦截所有(默认)，静态资源也会被拦截】
 */
@Configuration
public class AdimnWebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //默认拦截所有请求资源，包括静态资源
        registry.addInterceptor(new LoginInterceptor()) //添加拦截器类
                .addPathPatterns("/**")
                //添加放行的请求资源
                .excludePathPatterns("/","/login","/css/**","/fonts/**",
                        "/images/**","/js/**","/sql");
    }
}
