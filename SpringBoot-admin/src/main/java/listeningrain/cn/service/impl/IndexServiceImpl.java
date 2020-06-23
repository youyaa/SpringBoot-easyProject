package listeningrain.cn.service.impl;

import listeningrain.cn.facade.IndexFacade;
import listeningrain.cn.response.ReturnData;
import listeningrain.cn.service.IndexService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * Author: listeningrain
 * Date: 2020/6/23 4:49 下午
 * Description:
 */
@Service
public class IndexServiceImpl implements IndexService {
    @Reference
    private IndexFacade indexFacade;

    @Override
    public ReturnData testDubboException() throws Exception{
        return indexFacade.sayHello("listeningrain");
    }
}
