package com.security.demo.filter;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * ENTRY POINT
 */

@Component
public class JwtEntryPoint  implements AuthenticationEntryPoint, Serializable {
    private static final long serialVersionUID = -7905925380166052059L;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {

        /**
         * WHEN USE ACCESS SECURE GET ENDPOINT WITH NO CREDENTIALS , SEND 401 / LOGIN PAGE
         */

        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        ObjectMapper jsonMapper = new ObjectMapper();
        PrintWriter out = response.getWriter();
        Map<String, String> jsonResponse = new HashMap<String, String>();
        jsonResponse.put("message", "Invalid Token");
        out.write(jsonMapper.writeValueAsString(jsonResponse));
        out.flush();
        out.close();


    }
    }
}
