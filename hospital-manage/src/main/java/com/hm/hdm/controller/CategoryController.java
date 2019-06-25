package com.hm.hdm.controller;

import com.hm.hdm.entity.Category;
import com.hm.hdm.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Description: TODO(科室分类控制器)
 * @Author Administrator
 * @Date 2019/6/24/024 21:25
 */
@Controller("categoryController")
public class CategoryController {

 @Autowired
 private CategoryService categoryService;

 /**
  * 科室分类列表
  *
  * @param request
  * @param response
  * @throws ServletException
  * @throws IOException
  */
 public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  List<Category> categoryList = categoryService.findAll();
  request.setAttribute("CLIST", categoryList);
  request.getRequestDispatcher("../category_list.jsp").forward(request, response);
 }

 public void toEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  int id = Integer.parseInt(request.getParameter("id"));
  Category category = categoryService.findById(id);
  request.setAttribute("OBJ", category);
  request.getRequestDispatcher("../category_edit.jsp").forward(request, response);

 }


 /**
  * 科室分类编辑
  *
  * @param request
  * @param response
  * @throws ServletException
  * @throws IOException
  */
 public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  int id = Integer.parseInt(request.getParameter("id"));
  String name = request.getParameter("name");
  Category category = categoryService.findById(id);
  category.setName(name);
  categoryService.updateCategory(category);
  response.sendRedirect("list.do");
 }

 /**
  * 科室分类删除
  *
  * @param request
  * @param response
  * @throws ServletException
  * @throws IOException
  */
 public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  int id = Integer.parseInt(request.getParameter("id"));
  categoryService.deleteCategory(id);
  response.sendRedirect("list.do");
 }

 public void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  request.getRequestDispatcher("../category_add.jsp").forward(request, response);
 }

 /**
  * 科室分类增加
  *
  * @param request
  * @param response
  * @throws ServletException
  * @throws IOException
  */
 public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  String name = request.getParameter("name");
  Category category = new Category();
  category.setName(name);
  categoryService.insertCategory(category);
  response.sendRedirect("list.do");
 }

}
