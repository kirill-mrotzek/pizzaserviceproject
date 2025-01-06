package org.telran.pizzaservice.de.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String header = request.getHeader("Authorization");

        if(StringUtils.isEmpty(header) || !header.startsWith("Bearer ")) { //есть ли токен в заголовке
            filterChain.doFilter(request, response);
            return;
        }

        String jwt = header.substring("Bearer ".length()); //вырезаем токен
        String userName = jwtService.extractUserName(jwt); //извлекаем имя пользователя

        if(!userName.isEmpty() &&
                SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(userName);//есть ли пользователь в БД
            if(jwtService.isTokenValid(jwt, userDetails)){ //проверяем валидность токена
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails,
                        null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authenticationToken); //идентифицируем пользователя
            }
        }

        filterChain.doFilter(request, response);
    }
}
