package listeningrain.cn.service;


import listeningrain.cn.model.User;

/**
 * Author: listeningrain
 * Date: 2020/6/22 4:30 下午
 * Description:
 */
public interface UserService {
    User queryAll();
    User queryById(Integer id);
}
