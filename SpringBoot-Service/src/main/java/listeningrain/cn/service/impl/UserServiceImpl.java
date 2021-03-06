package listeningrain.cn.service.impl;

import listeningrain.cn.dao.UserMapper;
import listeningrain.cn.model.User;
import listeningrain.cn.request.UserInputData;
import listeningrain.cn.response.ReturnData;
import listeningrain.cn.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Author: listeningrain
 * Date: 2020/6/22 4:28 下午
 * Description:
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> queryAll() {
        return userMapper.findAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(UserInputData userInputData) {
        User user = new User();
        BeanUtils.copyProperties(userInputData,user);
        //使用mybatis-plus
        userMapper.insert(user);
        //测试事务
        throw new RuntimeException("测试事务，手动抛出异常");
        //return new ReturnData();
    }
}
