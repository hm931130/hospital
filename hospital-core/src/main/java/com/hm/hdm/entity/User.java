package com.hm.hdm.entity;

/**
 * @program: hospital-manager
 * @Date: 2019/6/24 16:00
 * @Author: Mr.Han
 * @Description:用户类
 */
public class User {
 private int id;
 private String userName;
 private String passWord;


 public String getPassWord() {
  return passWord;
 }

 public void setPassWord(String passWord) {
  this.passWord = passWord;
 }

 public int getId() {
  return id;
 }

 public void setId(int id) {
  this.id = id;
 }

 public String getUserName() {
  return userName;
 }

 public void setUserName(String userName) {
  this.userName = userName;
 }

}
