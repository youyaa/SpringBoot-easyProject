package listeningrain.cn.controller;

import listeningrain.cn.exception.AdminBaseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: listeningrain
 * Date: 2020/6/19 4:45 下午
 * Description: 示例Controller
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @GetMapping(path = "/testGet")
    public String testGet(){
        return "hello world";
    }

    @PostMapping(path = "/testPost")
    public String testPost(){
        return "hello world post 请求";
    }

    @GetMapping(path = "/testException")
    public String haha() throws Exception{
        throw new AdminBaseException("测试","测试错误");
    }
}