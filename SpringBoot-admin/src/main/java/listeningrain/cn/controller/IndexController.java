package listeningrain.cn.controller;

import listeningrain.cn.exception.AdminBaseException;
import listeningrain.cn.facadeImpl.IndexFacade;
import listeningrain.cn.response.ReturnData;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

/**
 * Author: listeningrain
 * Date: 2020/6/19 4:45 下午
 * Description: 示例Controller
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @Reference
    private IndexFacade indexFacade;

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

    @GetMapping(path = "/testDubbo")
    public ReturnData testDubbo(@RequestParam String name) throws Exception{
        ReturnData returnData = indexFacade.sayHello(name);
        return returnData;
    }
}
