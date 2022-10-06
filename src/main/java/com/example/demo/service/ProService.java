package com.example.demo.service;

import com.example.demo.bean.User;


/**
 * @Author xun
 * @create 2022/7/19 16:33
 */
public interface ProService {
     Integer findProId(String proName);
     void insertProduct(String proName, double price);
     void removeProduct(String proName);
     void updatePrice(String proName, double price);
     void insertUser(String userName, String password);
     String getPassword(String userName);
}
