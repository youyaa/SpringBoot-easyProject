package listeningrain.cn.service.impl;

import listeningrain.cn.facade.UserServiceFacade;
import listeningrain.cn.request.UserInputData;
import listeningrain.cn.response.ReturnData;
import listeningrain.cn.response.UserOutputData;
import listeningrain.cn.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * Author: listeningrain
 * Date: 2020/6/23 4:45 下午
 * Description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Reference
    private UserServiceFacade userServiceFacade;

    @Override
    public ReturnData<UserOutputData> query(UserInputData userInputData) {
        return userServiceFacade.query(userInputData);
    }

    public ReturnData testDubboException() throws Exception{
        return userServiceFacade.sayHello("listeningrain");
    }

    @Override
    public ReturnData sendMessage(String message) {
        return userServiceFacade.sendMessage(message);
    }
}
