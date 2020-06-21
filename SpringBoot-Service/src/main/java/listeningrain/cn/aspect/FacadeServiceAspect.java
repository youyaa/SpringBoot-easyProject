package listeningrain.cn.aspect;

import com.alibaba.fastjson.JSONObject;
import listeningrain.cn.exception.ServiceBaseException;
import listeningrain.cn.response.ReturnData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


/**
 * Author: listeningrain
 * Date: 2020/6/20 1:41 下午
 * Description:
 */
@Component
@Aspect
public class FacadeServiceAspect {
    private static final Logger logger = LogManager.getLogger(FacadeServiceAspect.class);
    /**
     * 拦截所有的facade service服务
     *
     * 功能描述： void
     *
     */
    @Pointcut(value = "execution(* listeningrain.cn.facadeImpl..*(..))")
    public void pointCut() {

    }

    /**
     * 环绕整个被调用的Facade方法，并处理所有未被Facade层内部处理的异常。
     *
     * @param joinPoint
     * @return
     * @author toney
     */
    @Around("pointCut()")
    public Object aroundFacadeMethod(ProceedingJoinPoint joinPoint) {
        final long startTimeMs = System.currentTimeMillis();
        String facadeClzShortName = joinPoint.getTarget().getClass().getSimpleName();
        String facadeMethodName = joinPoint.getSignature().getName();


        Object outputObject = null;
        try {
            logger.info("DUBBO Start: {}.{}", facadeClzShortName, facadeMethodName);

            Object[] parameters = joinPoint.getArgs();

            if (logger.isDebugEnabled()) {
                logger.debug("DUBBO Input: {}", parameters[0]);
            }
        } catch (Throwable e) {
            logger.error("facade aspect error ", e);
        }

        try{
            outputObject = joinPoint.proceed();
        } catch (Throwable ex) {
            logger.error("facade aspect error ", ex);
            ReturnData wrapper = new ReturnData();
            if (ex instanceof ServiceBaseException) {
                ServiceBaseException serviceBaseException = (ServiceBaseException)ex;
                wrapper.setCode(serviceBaseException.getCode());
                wrapper.setMsg(serviceBaseException.getMsg());
            } else{
                wrapper.setCode("00000000");
                wrapper.setMsg("服务层异常");
            }
            return wrapper;
        }finally {
            // 释放线程上的数据或标记位
            try {
                this.release(joinPoint, facadeClzShortName, facadeMethodName, startTimeMs, outputObject);
            } catch (Exception e) {
                logger.warn("Exception occurred when invoke release() in facade finally block, msg: {}", e.getMessage(),
                        e);
            }
        }

        return outputObject;
    }

    /**
     * 释放资源
     */
    private void release(ProceedingJoinPoint joinPoint, final String facadeClzShortName, final String facadeMethodName,
                         final long startTimeMs, Object outputObject) {
        logger.info("DUBBO Output: {}", JSONObject.toJSON(outputObject));
        long elapsedTimeMs = System.currentTimeMillis() - startTimeMs;
        logger.info("DUBBO End: {}.{}, Elapsed Time: {}ms.", facadeClzShortName, facadeMethodName, elapsedTimeMs);
    }
}
