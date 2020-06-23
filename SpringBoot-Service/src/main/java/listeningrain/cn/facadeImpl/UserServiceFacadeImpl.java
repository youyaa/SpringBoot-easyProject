package listeningrain.cn.facadeImpl;

import listeningrain.cn.enums.ErrorCode;
import listeningrain.cn.exception.ServiceBaseException;
import listeningrain.cn.facade.UserServiceFacade;
import listeningrain.cn.model.User;
import listeningrain.cn.request.UserInputData;
import listeningrain.cn.response.ReturnData;
import listeningrain.cn.response.UserOutputData;
import listeningrain.cn.service.UserService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

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
    public ReturnData sayHello(String name) throws Exception{
        System.out.println("hello world: "+name);
        throw new ServiceBaseException(ErrorCode.TEST_DUBBO_EXCEPTION);
    }

    @Override
    public ReturnData<UserOutputData> query(UserInputData userInputData) {
        ReturnData<UserOutputData> returnData = new ReturnData<>();
        User user = userService.queryById(userInputData.getId());
        if(null != user){
            UserOutputData userOutputData = new UserOutputData();
            BeanUtils.copyProperties(user,userOutputData);
            returnData.setData(userOutputData);
        }
        return returnData;
    }
}
