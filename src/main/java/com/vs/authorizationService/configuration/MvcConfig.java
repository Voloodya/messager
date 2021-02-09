package com.vs.authorizationService.configuration;
/**
 *Класс, который настраивает Spring MVC в приложении (первичную маршрутизацию):
 * addViewControllers() Метод (который переопределяет метод с тем же именем в WebMvcConfigurer)
 * добавляет четыре контроллера представления. Два контроллера вида ссылаются на представление,
 * имя которого "UIS56" (определено В UIS56.html), а другой ссылается на представление с именем
 * "login" (определено в login.html). Четвертый контроллер вида ссылается на другое названное представление "regestration".
 *
 * @autor vladimir.s
 * @version 1.0
 */
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public MvcConfig() {
        super();
    }

    // API

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("UIS56");
        registry.addViewController("/UIS56").setViewName("UIS56");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/regestration").setViewName("regestration");
        registry.addViewController("/accessDenied").setViewName("accessDenied");
    }


}
