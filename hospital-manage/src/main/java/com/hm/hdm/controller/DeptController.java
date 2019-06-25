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


 public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  //分类id
  int cid = 0;
  List<Category> categoryList = categoryService.findAll();
  try {
   cid = Integer.parseInt(request.getParameter("cid"));
  } catch (Exception e) {
   e.printStackTrace();
  }
  if (cid == 0) {
   cid = categoryList.get(0).getId();
  }
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

 public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  String name = request.getParameter("name");
  int cid = Integer.parseInt(request.getParameter("categoryId"));
  Dept dept = new Dept();
  dept.setCategoryId(cid);
  dept.setName(name);
  deptService.insertDept(dept);
  response.sendRedirect("list.do");
 }

 public void toEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  int id = Integer.parseInt(request.getParameter("id"));
  Dept dept = deptService.findById(id);
  request.setAttribute("OBJ", dept);
  List<Category> categoryList = categoryService.findAll();
  request.setAttribute("CLIST", categoryList);
  request.getRequestDispatcher("../dept_edit.jsp").forward(request, response);
 }

 public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  int id = Integer.parseInt(request.getParameter("id"));
  String name = request.getParameter("name");
  int categoryId = Integer.parseInt(request.getParameter("categoryId"));
  Dept dept = deptService.findById(id);
  dept.setName(name);
  dept.setCategoryId(categoryId);
  deptService.updateDept(dept);
  response.sendRedirect("list.do");
 }

 public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  int id = Integer.parseInt(request.getParameter("id"));
  deptService.deleteDept(id);
  response.sendRedirect("list.do");
 }
}
