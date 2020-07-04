package listeningrain.cn.service;


import listeningrain.cn.model.User;
import listeningrain.cn.request.UserInputData;
import listeningrain.cn.response.ReturnData;

import java.util.List;

/**
 * Author: listeningrain
 * Date: 2020/6/22 4:30 下午
 * Description:
 */
public interface UserService {
    List<User> queryAll();
    ReturnData add(UserInputData userInputData);
}
