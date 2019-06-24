package com.hm.hdm.entity;

/**
 * @program: hospital-manager
 * @Date: 2019/6/24 15:56
 * @Author: Mr.Han
 * @Description: 分类对象
 */
public class Category {
 private int id;

 private String name;

 private String createTime;

 private String updateTime;

 public int getId() {
  return id;
 }

 public void setId(int id) {
  this.id = id;
 }

 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }

 public String getCreateTime() {
  return createTime;
 }

 public void setCreateTime(String createTime) {
  this.createTime = createTime;
 }

 public String getUpdateTime() {
  return updateTime;
 }

 public void setUpdateTime(String updateTime) {
  this.updateTime = updateTime;
 }
}
