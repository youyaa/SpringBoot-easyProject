package listeningrain.cn.service.impl;

import listeningrain.cn.facade.UserServiceFacade;
import listeningrain.cn.request.UserInputData;
import listeningrain.cn.response.ReturnData;
import listeningrain.cn.response.UserOutputData;
import listeningrain.cn.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public ReturnData<List<UserOutputData>> queryAll() {
        return userServiceFacade.queryAll();
    }

    @Override
    public ReturnData addUser(UserInputData userInputData) {
        return userServiceFacade.add(userInputData);
    }
}
