package com.hm.hdm.global;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @program: hospital-manager
 * @Date: 2019/6/25 14:56
 * @Author: Mr.Han
 * @Description:
 */
public class LoginFilter implements Filter {
 public void init(FilterConfig filterConfig) throws ServletException {

 }

 public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
  HttpServletRequest request = (HttpServletRequest) servletRequest;
  HttpServletResponse response = (HttpServletResponse) servletResponse;

  String path = request.getServletPath();

  //请求login业务相关
  if (path.toLowerCase().indexOf("login") != -1) {
   filterChain.doFilter(servletRequest, servletResponse);
  } else {
   HttpSession session = request.getSession();
   Object obj = session.getAttribute("USER");
   if (obj != null) {
    filterChain.doFilter(servletRequest, servletResponse);
   } else {
    response.sendRedirect(request.getContextPath() + "/toLogin.do");
   }
  }


 }

 public void destroy() {

 }
}
