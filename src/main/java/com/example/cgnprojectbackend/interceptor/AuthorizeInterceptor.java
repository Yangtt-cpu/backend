package com.example.cgnprojectbackend.interceptor;

import com.example.cgnprojectbackend.entity.user.AccountUser;
import com.example.cgnprojectbackend.mapper.UserMapper;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

//@Component
//public class AuthorizeInterceptor implements HandlerInterceptor {
//
//    @Resource
//    UserMapper mapper;
//
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        SecurityContext context = SecurityContextHolder.getContext();
//        Authentication authentication = context.getAuthentication();
////        System.out.println(authentication.getPrincipal());
//        User user = (User) authentication.getPrincipal();
//        String username = user.getUsername();
//        AccountUser accountUser = mapper.findAccountUserByName(username);
//        request.getSession().setAttribute("account",accountUser);
//
//        return true;
//    }
//}
