package listeningrain.cn.facadeImpl;


import listeningrain.cn.exception.ServiceBaseException;
import listeningrain.cn.facade.IndexFacade;
import listeningrain.cn.response.ReturnData;
import org.apache.dubbo.config.annotation.Service;

/**
 * Author: listeningrain
 * Date: 2020/6/20 2:30 下午
 * Description:
 */
@Service
public class IndexFacadeImpl implements IndexFacade {

    @Override
    public ReturnData sayHello(String name) throws Exception{
        System.out.println("hello world: "+name);
        throw new ServiceBaseException("E000000067", "测试dubbo层异常处理");
    }
}
