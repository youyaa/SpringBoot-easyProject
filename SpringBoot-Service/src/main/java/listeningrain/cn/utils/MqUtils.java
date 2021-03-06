package listeningrain.cn.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Author: listeningrain
 * Date: 2020/6/24 4:59 下午
 * Description:
 */
@Component
public class MqUtils {
    @Autowired
    private AmqpTemplate amqpTemplate;

    private static final Logger logger = LogManager.getLogger(MqUtils.class);
    //发送消息
    public void send(String exchangeName,String routingKey, String message){
        Message sendMessge = new Message(message.getBytes(),new MessageProperties());
        amqpTemplate.convertAndSend(exchangeName,routingKey,sendMessge);
    }
}
