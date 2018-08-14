package com.imooc.miaosha.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.imooc.miaosha.access.AccessInterceptor;

/**
 * 启动项目时，会将此项注入。  WebMvcConfigurerAdapter在2.0版本之后废除，代替类为WebMvcConfigurationSupport。用法基本相同
 * 将此类装配，并且方法执行后，会自动将userArgumentResolver添加到response中，在下次请求是可
 * 直接获取此对象，不必在每个controller中都写这添加user的代码。
 */
@Configuration
public class WebConfig  extends WebMvcConfigurerAdapter{
	
	@Autowired
	UserArgumentResolver userArgumentResolver;
	
	@Autowired
	AccessInterceptor accessInterceptor;
	
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(userArgumentResolver);
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		/**
		 * 还有其他的拦截器，直接在此处添加
		 */
		registry.addInterceptor(accessInterceptor);
	}
	
}
