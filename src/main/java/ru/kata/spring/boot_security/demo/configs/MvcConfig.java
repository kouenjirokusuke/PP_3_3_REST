package ru.kata.spring.boot_security.demo.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.kata.spring.boot_security.demo.converter.StringToRolesConverter;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    private final StringToRolesConverter stringToRolesConverter;

    public MvcConfig(StringToRolesConverter stringToRolesConverter) {
        this.stringToRolesConverter = stringToRolesConverter;
    }

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/user").setViewName("user");
        registry.addViewController("/admin").setViewName("admin");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(stringToRolesConverter);
    }
}
