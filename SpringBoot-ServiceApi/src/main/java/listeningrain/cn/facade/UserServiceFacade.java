package listeningrain.cn.facade;

import listeningrain.cn.request.UserInputData;
import listeningrain.cn.response.ReturnData;
import listeningrain.cn.response.UserOutputData;

/**
 * Author: listeningrain
 * Date: 2020/6/23 9:35 上午
 * Description:
 */
public interface UserServiceFacade {
    ReturnData<UserOutputData> query(UserInputData userInputData);
    ReturnData sayHello(String name) throws Exception;
}
