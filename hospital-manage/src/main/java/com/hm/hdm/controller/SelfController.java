package com.hm.hdm.controller;

import com.hm.hdm.entity.User;
import com.hm.hdm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: hospital-manager
 * @Date: 2019/6/24 16:19
 * @Author: Mr.Han
 * @Description: 登录控制器
 */
@Controller("selfController")
public class SelfController {

 @Autowired
 private UserService userService;

 public void toLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  request.getRequestDispatcher("login.html").forward(request, response);
 }

 /**
  * 后台主页
  *
  * @param request
  * @param response
  * @throws ServletException
  * @throws IOException
  */
 public void main(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  response.sendRedirect("category/list.do");
 }

 /**
  * 登陆
  *
  * @param request
  * @param response
  * @throws ServletException
  * @throws IOException
  */

 public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  String userName = request.getParameter("username");
  String password = request.getParameter("password");

  User user = userService.login(userName, password);

  //用户名密码正确
  if (user != null) {
   HttpSession session = request.getSession();
   session.setAttribute("USER", user);
   response.sendRedirect("main.do");
  } else {
   PrintWriter out = response.getWriter();
   out.print("<script>alert('用户名或密码错误!');window.location.href='toLogin.do'</script>");
  }

 }

 /**
  * 登出
  *
  * @param request
  * @param response
  * @throws ServletException
  * @throws IOException
  */
 public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  HttpSession session = request.getSession();
  session.setAttribute("USER", null);
  response.sendRedirect("toLogin.do");
 }

}
