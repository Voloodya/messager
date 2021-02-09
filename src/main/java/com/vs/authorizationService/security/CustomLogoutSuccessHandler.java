package com.vs.authorizationService.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

/**
 *
 * Компонент отвечающий за определение места назначения, к которому пользователь направляется после выхода из системы
 * Пользовательская логика приложения, которая должна выполняться при успешном выходе пользователя из системы
 *Из-за этого сопряжение атрибута logoutSuccessHandler с logoutSuccessUrl не будет работать, так как оба они охватывают аналогичную функциональность.
 *
 * @autor vladimir.s
 * @version 1.0
 */

public class CustomLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler implements LogoutSuccessHandler{

    public CustomLogoutSuccessHandler() {
        super();
    }

    // API

    @Override
    public void onLogoutSuccess(final HttpServletRequest request, final HttpServletResponse response, final Authentication authentication) throws IOException, ServletException {
        final String refererUrl = request.getHeader("Referer");
        System.out.println(refererUrl);

        super.onLogoutSuccess(request, response, authentication);
    }

}
