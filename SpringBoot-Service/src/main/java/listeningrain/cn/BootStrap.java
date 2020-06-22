package listeningrain.cn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Author: listeningrain
 * Date: 2020/6/20 2:34 下午
 * Description:
 */
@SpringBootApplication
@MapperScan("listeningrain.cn.dao")
public class BootStrap {
    public static void main(String[] args) {
        SpringApplication.run(BootStrap.class,args);
    }
}
