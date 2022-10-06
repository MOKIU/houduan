package com.example.demo.controller;

import com.example.demo.bean.User;
import com.example.demo.service.ProService;
import com.example.demo.util.MD5Util;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import sun.security.provider.MD5;

import javax.servlet.http.HttpSession;

/**
 * @Author xun
 * @create 2022/7/19 16:33
 */
//@RestController = @ResponseBody + @Controller
@RestController
public class ProController {

    // 这里跟使用@Autowired注解是一样的效果
    private final ProService proService;
    public ProController(ProService proService) {
        this.proService = proService;
    }

    // 这是一个示例
    // 详细的Get、Post请求需要你们自己去了解
    // 返回商品名对应的id
    @GetMapping("/getProId/{proName}")
    public Integer getProId(@PathVariable String proName) {
        // 按住ctrl键进去看看具体调用的这个函数吧
        return proService.findProId(proName);
    }

    // 在这里仿照上面的getProId方法，进行controller层、service层和mapper层的完善吧，很有规律的！
    // 加入商品名与价格
    @GetMapping("/add/{proName}/{price}")
    public void uploadProName(@PathVariable("proName") String proName,
                                 @PathVariable("price") double price) {
        this.proService.insertProduct(proName, price);
    }

    // 删除product表中商品
    @GetMapping("/delete/{proName}")
    public void deleteProduct(@PathVariable("proName") String proName){
        this.proService.removeProduct(proName);
    }

    // 更新商品价格
    @GetMapping("/update/{proName}/{price}")
    public String updatePrice(@PathVariable("proName") String proName,
                              @PathVariable("price") double price){
        this.proService.updatePrice(proName, price);
        return "更新完成";
    }

    // 注册功能:并将密码进行MD5加密存入user表中
    @RequestMapping("/register/{userName}/{password}")
    public String register(@PathVariable("userName") String userName,
                         @PathVariable("password")  String password){
        String md5pwd= MD5Util.encode(password);
        this.proService.insertUser(userName, md5pwd);
        return "注册成功";
    }

    // 登录功能:
    @RequestMapping("/login/{userName}/{password}")
    public String login(@PathVariable("userName") String userName,
                        @PathVariable("password")  String password){
        // 根据用户名查找密码，密码不存在代表无此用户
        if(this.proService.getPassword(userName) != null) {
            // 密码相同 登录成功
            if ((MD5Util.encode(password)).equals(this.proService.getPassword(userName))) {
                return "登录成功";
            }else {
                return "密码错误";
            }
        }else {
            return "不存在此用户";
        }
    }
}
