package com.hm.hdm.service;

import com.hm.hdm.entity.Dept;

import java.util.List;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author Administrator
 * @Date 2019/6/24/024 23:15
 */
public interface DeptService {


    /**
     * 增加科室
     *
     * @param dept
     */
    void insertDept(Dept dept);

    /**
     * 更新科室
     *
     * @param dept
     */
    void updateDept(Dept dept);

    /**
     * 删除科室
     *
     * @param id
     */
    void deleteDept(Integer id);

    /**
     * 查找科室 根据id
     *
     * @param id
     * @return
     */
    Dept findById(Integer id);

    /**
     * 查找所有科室
     *
     * @return
     */
    List<Dept> findAll();


    /**
     * 通过分类Id
     *
     * @param id
     * @return
     */
    List<Dept> findAllByCid(Integer cid);

}
