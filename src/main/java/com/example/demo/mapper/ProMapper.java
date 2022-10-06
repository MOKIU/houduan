package com.example.demo.mapper;

import com.example.demo.bean.User;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author xun
 * @create 2022/7/19 16:35
 */
@Mapper
public interface ProMapper {
    // 具体的sql文件在该mapper的同名文件中
    Integer selectProName(@Param("proName") String proName);
    // 插入商品
    void insertProduct(@Param("proName") String proName, @Param("price") double price);
    // 删除商品
    void removeProduct(@Param("proName") String proName);
    // 更新商品价格
    void updatePrice(@Param("proName") String proName, @Param("price") double price);
    // 注册用户
    void insertUser(@Param("userName") String userName, @Param("password") String password);
    // 得到用户存储密码
    String getPassword(@Param("userName") String userName);
}
