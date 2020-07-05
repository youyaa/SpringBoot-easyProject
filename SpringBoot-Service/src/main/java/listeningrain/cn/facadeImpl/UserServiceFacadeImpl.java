package listeningrain.cn.facadeImpl;

import listeningrain.cn.facade.UserServiceFacade;
import listeningrain.cn.model.User;
import listeningrain.cn.request.UserInputData;
import listeningrain.cn.response.ReturnData;
import listeningrain.cn.response.UserOutputData;
import listeningrain.cn.service.UserService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: listeningrain
 * Date: 2020/6/23 9:35 上午
 * Description:
 */
@Service
public class UserServiceFacadeImpl implements UserServiceFacade {
    @Autowired
    private UserService userService;

    @Override
    public ReturnData<List<UserOutputData>> queryAll(){
        List<User> users = userService.queryAll();
        List<UserOutputData> result = new ArrayList<>(users.size());
        for(User user : users){
            UserOutputData userOutputData = new UserOutputData();
            BeanUtils.copyProperties(user,userOutputData);
            result.add(userOutputData);
        }
        return new ReturnData<>(result);
    }

    @Override
    public ReturnData add(UserInputData userInputData) {
        userService.add(userInputData);
        return new ReturnData();
    }
}
