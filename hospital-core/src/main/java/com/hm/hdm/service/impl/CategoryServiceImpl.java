package com.hm.hdm.service.impl;

import com.hm.hdm.dao.CategoryDao;
import com.hm.hdm.entity.Category;
import com.hm.hdm.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author Administrator
 * @Date 2019/6/24/024 21:18
 */
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    public void insertCategory(Category category) {

        category.setCreateTime(new Date());
        category.setUpdateTime(new Date());
        categoryDao.insertCategory(category);

    }

    public void updateCategory(Category category) {
        category.setUpdateTime(new Date());
        categoryDao.updateCategory(category);

    }

    public void deleteCategory(Integer id) {
        categoryDao.deleteCategory(id);
    }

    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    public Category findById(Integer id) {
        return categoryDao.findById(id);
    }
}
