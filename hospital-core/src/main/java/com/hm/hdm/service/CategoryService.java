package com.hm.hdm.service;

import com.hm.hdm.entity.Category;

import java.util.List;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author Administrator
 * @Date 2019/6/24/024 21:17
 */
public interface CategoryService {

    /**
     * 新增科室
     *
     * @param category
     */
    void insertCategory(Category category);

    /**
     * 更新科室
     *
     * @param category
     */
    void updateCategory(Category category);

    /**
     * 删除科室
     *
     * @param id
     */
    void deleteCategory(Integer id);

    /**
     * 查询所有科室
     */

    List<Category> findAll();

    /**
     * 查询某个科室
     */
    Category findById(Integer id);
}
