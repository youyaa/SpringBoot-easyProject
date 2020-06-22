package listeningrain.cn.facadeImpl;


import com.alibaba.fastjson.JSONObject;
import listeningrain.cn.facade.IndexFacade;
import listeningrain.cn.request.StudentInputData;
import listeningrain.cn.response.ReturnData;
import listeningrain.cn.response.StudentOutputData;
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
        //throw new ServiceBaseException("E000000067", "测试dubbo层异常处理");
        return new ReturnData<String>("hello world");
    }

    @Override
    public ReturnData sayHello(StudentInputData student) {
        System.out.println("hello world: "+ JSONObject.toJSONString(student));
        return new ReturnData<StudentOutputData>(new StudentOutputData("listeningrain",25));
    }
}
