package com.vs.authorizationService.security.configuration;

import com.vs.authorizationService.security.CustomAccessDeniedHandler;
import com.vs.authorizationService.security.CustomAuthenticationFailureHandler;
import com.vs.authorizationService.security.CustomLogoutSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

/**
 *Класс, который настраивает конфигурация безопасности:
 * WebSecurityConfigКласс аннотируется с @EnableWebSecurityтем, чтобы включить поддержку веб-безопасности Spring Security
 * и обеспечить интеграцию Spring MVC. Он также расширяет WebSecurityConfigurerAdapterи переопределяет несколько своих методов,
 * чтобы задать некоторые особенности конфигурации веб-безопасности.
 * Этот configure(HttpSecurity)метод определяет, какие пути URL-адресов должны быть защищены, а какие-нет.
 * Когда пользователь успешно входит в систему, он перенаправляется на ранее запрошенную страницу, которая требует проверки подлинности.
 * Существует пользовательская /login страница (которая задается loginPage()), и каждый может ее просмотреть.
 *
 *  userDetailsService() метод создает хранилище пользователей в памяти с одним пользователем. Этому пользователю присваивается имя userпользователя,
 *  пароль passwordи роль USER.
 *
 *  loginPage() – пользовательская страница входа в систему
 * loginProcessingUrl() – URL-адрес для отправки имени пользователя и пароля
 * defaultSuccessUrl() – целевая страница после успешного входа в систему
 * failureUrl() – целевая страница после неудачного входа в систему
 * logoutUrl() – пользовательский выход из системы
 *
 * @autor vladimir.s
 * @version 1.0
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/admin/**").hasAnyAuthority("ADMIN")
                .antMatchers("/UIS56").anonymous()
                .antMatchers("/","/login", "/UIS56","/registration","/api/v1/item/users","/api/v1/item/add","/api/v1/item/*").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login.html").permitAll() //Страница авторизации, должен быть контроллер, который её будет выдавать
                .loginProcessingUrl("/authenticateTheUser") // Это адрес конечной точки, куда по методу POST отправляются имя и пароль при нажатии кнопки входа. Адрес переопределен, но сама точка осталась автогенерируемой (ее генерирует Spring Security).
                .usernameParameter("username").passwordParameter("password")
                .defaultSuccessUrl("/home.html", true)// Страница по умолчанию, куда перенаправляется пользователь, если он начал со страницы login, а не собирался накакую-то закрытыю стр
                .failureUrl("/login.html?error=true") //Если были введены неправильные имя и пароль, необходимо перенаправить на страницу с ошибкой. По умолчанию этот тот же адрес /login, но с параметром
                //.failureHandler(authenticationFailureHandler())
                .and()
                .logout()
                .logoutUrl("/logoutTheUser") //URL – адрес Spring Security, который фактически запускает механизм выхода из системы
                .deleteCookies("JSESSIONID") // Очиска Coockies после logout
                .logoutSuccessUrl("/UIS56");

//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/admin/**").hasAnyAuthority("ADMIN")
//                .antMatchers("/UIS56").anonymous()
//                .antMatchers("/", "/UIS56","/registration","/api/v1/item/users","/api/v1/item/add").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .usernameParameter("username").passwordParameter("password")
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();
    }

//    @Bean
//    public LogoutSuccessHandler logoutSuccessHandler() {
//        return new CustomLogoutSuccessHandler();
//    }
//
//    @Bean
//    public AccessDeniedHandler accessDeniedHandler() {
//        return new CustomAccessDeniedHandler();
//    }
//
//    @Bean
//    public AuthenticationFailureHandler authenticationFailureHandler() {
//        return new CustomAuthenticationFailureHandler();
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("vs")
                        .password("654")
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }

}
