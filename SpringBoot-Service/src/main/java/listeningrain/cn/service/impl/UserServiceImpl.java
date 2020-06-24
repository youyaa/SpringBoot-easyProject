package listeningrain.cn.service.impl;

import com.alibaba.fastjson.JSONObject;
import listeningrain.cn.dao.UserMapper;
import listeningrain.cn.model.User;
import listeningrain.cn.service.RabbitMqReceiver;
import listeningrain.cn.service.UserService;
import listeningrain.cn.utils.MqUtils;
import listeningrain.cn.utils.RedisUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private MqUtils mqUtils;

    @Override
    public User queryAll() {
        redisUtils.set("name","啊啊啊啊风风feng");
        return userMapper.findAll().get(0);
    }

    @Override
    public User queryById(Integer id) {
        System.out.println(redisUtils.get("name"));
        return userMapper.selectById(id);
    }

    @Override
    public void sendMessage(String message) {
        for(int i=0; i<10; i++){
            String send = JSONObject.toJSONString(message+i);
            mqUtils.send("test-exchange","",send);
        }
        logger.info("发送消息结束");
    }
}
