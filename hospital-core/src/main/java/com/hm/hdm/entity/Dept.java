package com.hm.hdm.entity;

import java.util.Date;

/**
 * @program: hospital-manager
 * @Date: 2019/6/24 15:59
 * @Author: Mr.Han
 * @Description:科室对象
 */
public class Dept {

 private int id;

 private int categoryId;

 private String name;

 private Date createTime;

 private Date updateTime;

 public int getId() {
  return id;
 }

 public void setId(int id) {
  this.id = id;
 }

 public int getCategoryId() {
  return categoryId;
 }

 public void setCategoryId(int categoryId) {
  this.categoryId = categoryId;
 }

 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }

 public Date getCreateTime() {
  return createTime;
 }

 public void setCreateTime(Date createTime) {
  this.createTime = createTime;
 }

 public Date getUpdateTime() {
  return updateTime;
 }

 public void setUpdateTime(Date updateTime) {
  this.updateTime = updateTime;
 }
}
