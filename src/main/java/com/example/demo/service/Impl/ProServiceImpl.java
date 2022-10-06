package com.example.demo.service.Impl;

import com.example.demo.bean.User;
import com.example.demo.mapper.ProMapper;
import com.example.demo.service.ProService;
import org.springframework.stereotype.Service;

/**
 * @Author xun
 * @create 2022/7/19 16:34
 */
@Service
public class ProServiceImpl implements ProService {

    private final ProMapper proMapper;
    public ProServiceImpl(ProMapper proMapper) {
        this.proMapper = proMapper;
    }

    @Override
    public Integer findProId(String proName) {
        return proMapper.selectProName(proName);
    }

    @Override
    public void insertProduct(String proName, double price) { this.proMapper.insertProduct(proName, price); }

    @Override
    public void removeProduct(String proName){ this.proMapper.removeProduct(proName); }

    @Override
    public void updatePrice(String proName, double price){ this.proMapper.updatePrice(proName, price); }

    @Override
    public void insertUser(String userName, String password) { this.proMapper.insertUser(userName, password);}

    @Override
    public String getPassword(String userName) {return this.proMapper.getPassword(userName);}
}
