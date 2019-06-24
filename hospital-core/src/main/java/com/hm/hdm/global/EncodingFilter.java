package com.hm.hdm.global;

import javax.servlet.*;
import java.io.IOException;

/**
 * @program: hospital-manager
 * @Date: 2019/6/24 16:05
 * @Author: Mr.Han
 * @Description: 字符过滤器
 */
public class EncodingFilter implements Filter {
 private String encoding = "UTF-8";

 public void init(FilterConfig filterConfig) throws ServletException {
  if (filterConfig.getInitParameter("ENCODING") != null) {
   encoding = filterConfig.getInitParameter("ENCODING");
  }
 }

 public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
  servletRequest.setCharacterEncoding(encoding);
  servletResponse.setCharacterEncoding(encoding);
  filterChain.doFilter(servletRequest, servletResponse);
 }

 public void destroy() {
  encoding = null;
 }
}
