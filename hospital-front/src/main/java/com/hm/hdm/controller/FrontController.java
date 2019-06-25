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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: hospital-manager
 * @Date: 2019/6/25 15:33
 * @Author: Mr.Han
 * @Description:前台控制器
 */
@Controller("frontController")
public class FrontController {


 @Autowired
 private CategoryService categoryService;

 @Autowired
 private DeptService deptService;


 /**
  * 前台首页
  *
  * @param request
  * @param response
  * @throws ServletException
  * @throws IOException
  */
 public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  List<Category> categoryList = categoryService.findAll();

  request.setAttribute("CLIST", categoryList);

  Map<Integer, List<Dept>> map = new HashMap<>();

  //将科室信息封装进map
  for (Category category : categoryList) {
   map.put(category.getId(), deptService.findAllByCid(category.getId()));
  }
  request.setAttribute("MAP", map);
  request.getRequestDispatcher("../hospital_index.jsp").forward(request, response);


 }

}
