package listeningrain.cn.controller;

import listeningrain.cn.request.UserInputData;
import listeningrain.cn.response.ReturnData;
import listeningrain.cn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Author: listeningrain
 * Date: 2020/6/19 4:45 下午
 * Description: 示例Controller
 */
@RestController
@RequestMapping("/index")
public class IndexController {
    @Autowired
    private UserService userService;

    @GetMapping(path = "/testException")
    public ReturnData testDubboException() throws Exception{
        return userService.testDubboException();
    }

    @PostMapping(path = "/queryAllUser")
    public ReturnData queryAll(@RequestBody @Valid UserInputData userInputData){
        return userService.query(userInputData);
    }

    @GetMapping(path = "/sendMessage")
    public ReturnData sendMessage(@RequestParam String message){
        return userService.sendMessage(message);
    }
}
