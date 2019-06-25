package com.hm.hdm.controller;

import com.hm.hdm.entity.Category;
import com.hm.hdm.entity.Dept;
import com.hm.hdm.service.CategoryService;
import com.hm.hdm.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Description: TODO(部科室控制器类)
 * @Author Administrator
 * @Date 2019/6/24/024 22:00
 */
@Controller("deptController")
public class DeptController {

 @Autowired
 private DeptService deptService;

 @Autowired
 private CategoryService categoryService;


 /**
  * 科室列表
  *
  * @param request
  * @param response
  * @throws ServletException
  * @throws IOException
  */
 public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  //分类id

  List<Category> categoryList = categoryService.findAll();
  int cid = Integer.parseInt(request.getParameter("cid"));
  Category category = categoryService.findById(cid);
  List<Dept> deptList = deptService.findAllByCid(cid);
  request.setAttribute("COBJ", category);
  request.setAttribute("CLIST", categoryList);
  request.setAttribute("DLIST", deptList);
  request.getRequestDispatcher("../dept_list.jsp").forward(request, response);

 }

 public void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  List<Category> categoryList = categoryService.findAll();
  request.setAttribute("CLIST", categoryList);
  request.getRequestDispatcher("../dept_add.jsp").forward(request, response);

 }

 /**
  * 科室增加
  *
  * @param request
  * @param response
  * @throws ServletException
  * @throws IOException
  */
 public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  String name = request.getParameter("name");
  int cid = Integer.parseInt(request.getParameter("categoryId"));
  Dept dept = new Dept();
  dept.setCategoryId(cid);
  dept.setName(name);
  deptService.insertDept(dept);
  response.sendRedirect("list.do?cid=" + cid);
 }

 public void toEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  int id = Integer.parseInt(request.getParameter("id"));
  Dept dept = deptService.findById(id);
  request.setAttribute("OBJ", dept);
  List<Category> categoryList = categoryService.findAll();
  request.setAttribute("CLIST", categoryList);
  request.getRequestDispatcher("../dept_edit.jsp").forward(request, response);
 }

 /**
  * 科室编辑
  *
  * @param request
  * @param response
  * @throws ServletException
  * @throws IOException
  */
 public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  int id = Integer.parseInt(request.getParameter("id"));
  String name = request.getParameter("name");
  int categoryId = Integer.parseInt(request.getParameter("categoryId"));
  Dept dept = deptService.findById(id);
  dept.setName(name);
  dept.setCategoryId(categoryId);
  deptService.updateDept(dept);
  response.sendRedirect("list.do?cid=" + categoryId);
 }

 /**
  * 科室删除
  *
  * @param request
  * @param response
  * @throws ServletException
  * @throws IOException
  */
 public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  int id = Integer.parseInt(request.getParameter("id"));
  int cid = Integer.parseInt(request.getParameter("cid"));
  deptService.deleteDept(id);
  response.sendRedirect("list.do?cid=" + cid);
 }
}
