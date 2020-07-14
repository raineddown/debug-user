package com.design.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


import java.io.File;

//@EnableSpringDataWebSupport
@Configuration
public class UploadConfiguration extends WebMvcConfigurationSupport  {
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**")//这个是虚拟路径图片路径
                .addResourceLocations("file:E:/upload/img/");//这个是图片真实路径
        super.addResourceHandlers(registry);
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");//项目内的图片去static下找
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/loginSuccess").setViewName("success");
        //registry.addViewController("/faceLogin").setViewName("faceLogin");

    }
    //自定义的国际化//
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login.html","/user/loginSuccess/**","/user/login/**","/user/noAssociation","/user/noPlatform","/user/noConsole",
                        "/css/*","/js/**","/img/**","/swagger-ui","/images/**","/user/noPrize","/user/noProcess","/login/toFaceLogin","/login/jumpGetFace",
                        "/login/faceSucceed","/login/searchFace","/swagger-ui.html","/swagger-ui.html#");
    }
}
