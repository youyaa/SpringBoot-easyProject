package listeningrain.cn.service;

import listeningrain.cn.request.UserInputData;
import listeningrain.cn.response.ReturnData;

/**
 * Author: listeningrain
 * Date: 2020/6/23 4:45 下午
 * Description:
 */
public interface UserService {
    ReturnData<UserOutputData> query(UserInputData userInputData);
}
