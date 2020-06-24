package listeningrain.cn.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * RabbitMQ消费者实例
 */
@Component
@RabbitListener(queues = "test-queue", containerFactory="rabbitListenerContainerFactory")
public class RabbitMqReceiver {
    private static final Logger logger = LogManager.getLogger(RabbitMqReceiver.class);

    @RabbitHandler
    public void process(String Str) {
        logger.info("接收消息："+Str);
        logger.info("接收消息时间："+new Date());
    }
}