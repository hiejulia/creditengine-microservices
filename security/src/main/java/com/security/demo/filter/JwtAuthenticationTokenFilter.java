package com.security.demo.filter;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * jwt authentication token filter
 */
public class JwtAuthenticationTokenFilter extends UsernamePasswordAuthenticationFilter {


    @Autowired
    AuthenticationManagerBuilder authBuilder;


    //filter
    @Override
    public void filter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;//request object

        String header_authorization = httpServletRequest.getHeader("Authorization");
        //token
        String token = (StringUtils.isBlank(header_authorization) ? null : header_authorization.split(" ")[1]);
//token is not found in the header
        if (StringUtils.isBlank(header_authorization) && token == null) {
            logger.info("Token Not found in header.");
        } else {
            UserDetails userDetails = null;

            try {
                userDetails = authBuilder.getDefaultUserDetailsService().loadUserByUsername(token);//get userdetail service by token
                UsernamePasswordAuthenticationToken userAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, "", userDetails.getAuthorities());
                userAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                SecurityContextHolder.getContext().setAuthentication(userAuthenticationToken);
            } catch (Exception e) {
                HttpServletResponse httpresposne = (HttpServletResponse) response;
                httpresposne.setContentType("application/json");
                httpresposne.setStatus(HttpServletResponse.SC_UNAUTHORIZED);//unauthorized
                ObjectMapper jsonMapper = new ObjectMapper();
                PrintWriter out = httpresposne.getWriter();
                Map<String, String> jsonResponse = new HashMap<String, String>();
                jsonResponse.put("msg", "Invalid Token");//in valid token
                out.write(jsonMapper.writeValueAsString(jsonResponse));
                out.flush();
                out.close();
                return;
            }
            chain.doFilter(request, response);
        }
        }



    }

}
