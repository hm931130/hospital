package com.hm.hdm.service.impl;

import com.hm.hdm.dao.DeptDao;
import com.hm.hdm.entity.Dept;
import com.hm.hdm.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author Administrator
 * @Date 2019/6/24/024 23:16
 */
@Repository("deptService")
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    public void insertDept(Dept dept) {
        dept.setCreateTime(new Date());
        dept.setUpdateTime(new Date());
        deptDao.insertDept(dept);
    }

    public void updateDept(Dept dept) {
        dept.setUpdateTime(new Date());
        deptDao.updateDept(dept);
    }

    public void deleteDept(Integer id) {
        deptDao.deleteDept(id);
    }

    public Dept findById(Integer id) {
        return deptDao.findById(id);
    }

    public List<Dept> findAll() {
        return deptDao.findAll();
    }

    public List<Dept> findAllByCid(Integer cid) {
        return deptDao.findAllByCid(cid);
    }
}
