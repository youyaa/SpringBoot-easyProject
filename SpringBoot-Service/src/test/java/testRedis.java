import listeningrain.cn.BootStrap;
import listeningrain.cn.utils.RedisUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Author: listeningrain
 * Date: 2020/6/23 7:52 下午
 * Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BootStrap.class)
public class testRedis {

    @Autowired
    private RedisUtils redisUtils;

    @Test
    public void testRedis(){
        redisUtils.set("age","122");
        System.out.println(redisUtils.get("age"));
    }
}
