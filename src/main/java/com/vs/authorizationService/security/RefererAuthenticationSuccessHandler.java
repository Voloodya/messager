package com.vs.authorizationService.security;

import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
/**
 *
 * Компонент отвечающий за обрабатку каждого раз, когда пользователь успешно входит в систему.
 *
 * @autor vladimir.s
 * @version 1.0
 */

public class RefererAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler{

    public RefererAuthenticationSuccessHandler() {
        super();
        setUseReferer(true);
    }

}
