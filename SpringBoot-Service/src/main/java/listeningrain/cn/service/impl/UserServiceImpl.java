package listeningrain.cn.service.impl;

import listeningrain.cn.dao.UserMapper;
import listeningrain.cn.model.User;
import listeningrain.cn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author: listeningrain
 * Date: 2020/6/22 4:28 下午
 * Description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryAll() {
        return userMapper.findAll().get(0);
    }

    @Override
    public User queryById(Integer id) {
        return userMapper.selectById(id);
    }
}
