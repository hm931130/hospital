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
        int cid = Integer.parseInt(request.getParameter("cid"));
        Category category = categoryService.findById(cid);
        List<Dept> deptList = deptService.findAllByCid(cid);
        List<Category> categoryList = categoryService.findAll();

        request.setAttribute("COBJ", category);
        request.setAttribute("CLIST", categoryList);
        request.setAttribute("DLIST", deptList);
        request.getRequestDispatcher("../dept_list.jsp").forward(request, response);

    }
}
