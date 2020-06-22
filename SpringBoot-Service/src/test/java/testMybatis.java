import listeningrain.cn.BootStrap;
import listeningrain.cn.model.User;
import listeningrain.cn.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Author: listeningrain
 * Date: 2020/6/22 4:40 下午
 * Description:
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BootStrap.class)
public class testMybatis {

    @Autowired
    private UserService userService;

    @Test
    public void test(){
        User user = userService.queryAll();
        System.out.println(user);
    }

    @Test
    public void test2(){
        User user = userService.queryById(1);
        System.out.println(user);
    }
}
