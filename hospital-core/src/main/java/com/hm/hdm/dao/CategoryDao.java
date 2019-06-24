package com.hm.hdm.dao;

import com.hm.hdm.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author Administrator
 * @Date 2019/6/24/024 21:07
 */
@Repository("categoryDao")
public interface CategoryDao {

    /**
     * 新增科室类别
     *
     * @param category
     */
    void insertCategory(Category category);

    /**
     * 更新科室信息
     *
     * @param category
     */
    void updateCategory(Category category);

    /**
     * 通过id删除科室
     *
     * @param id
     */
    void deleteCategory(Integer id);

    /**
     * 查询所有科室
     *
     * @return
     */
    List<Category> findAll();

    /**
     * 查询某个科室
     */
    Category findById(Integer id);

}
