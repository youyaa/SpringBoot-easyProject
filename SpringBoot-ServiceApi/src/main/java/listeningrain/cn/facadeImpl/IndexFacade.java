package listeningrain.cn.facadeImpl;

import listeningrain.cn.request.StudentInputData;
import listeningrain.cn.response.ReturnData;

/**
 * Author: listeningrain
 * Date: 2020/6/20 2:32 下午
 * Description:
 */
public interface IndexFacade {
    ReturnData sayHello(String name) throws Exception;
    ReturnData sayHello(StudentInputData student);
}
