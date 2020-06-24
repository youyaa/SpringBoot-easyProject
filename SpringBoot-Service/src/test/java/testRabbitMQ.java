import listeningrain.cn.BootStrap;
import listeningrain.cn.utils.MqUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Author: listeningrain
 * Date: 2020/6/24 5:12 下午
 * Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BootStrap.class)
public class testRabbitMQ {

    @Autowired
    private MqUtils mqUtils;

    @Test
    public void test(){
        mqUtils.send("aaaa","","hello world");
    }
}
