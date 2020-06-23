package listeningrain.cn.aspect;

import listeningrain.cn.convert.CurrentControllerMethod;
import org.apache.dubbo.rpc.RpcContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.UUID;

/**
 * rest请求拦截器，打印日志
 */
@Component
public class WebInterceptor extends HandlerInterceptorAdapter {
    private static final Logger logger = LogManager.getLogger();
    ThreadLocal<Long> threadLocal = new ThreadLocal<Long>();


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        long startTimeMs = System.currentTimeMillis();
        /**
         * 生成全局唯一的请求id，将在整个请求过程中被传递和打印
         */
        String logId = UUID.randomUUID().toString();
        ThreadContext.put("logId", logId);
        RpcContext.getContext().setAttachment("traceId",logId);
        // 用于区分mvc:resources, 正常的Controller请求
        if (handler == null || !HandlerMethod.class.isAssignableFrom(handler.getClass())) {
            return true;
        }
        HandlerMethod hm = (HandlerMethod) handler;
        CurrentControllerMethod.setCurrentControllerClz(hm.getBeanType());
        CurrentControllerMethod.setCurrentControllerMethod(hm.getMethod());

        logger.info("******************************* REST START: {}.{} *******************************", hm.getBeanType().getSimpleName(), hm.getMethod().getName());
        threadLocal.set(startTimeMs);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        try {
            Class<?> controllerClz = CurrentControllerMethod.getCurrentControllerClz();
            Method controllerMethod = CurrentControllerMethod.getCurrentControllerMethod();
            Long startTime = threadLocal.get();

            logger.info("TIME CONSUME : " + (System.currentTimeMillis() - startTime)+"ms");
            logger.info("******************************* REST END: {}.{} *******************************", controllerClz.getSimpleName(), controllerMethod.getName());
        } finally {
            // 放后面才清，否则上面的log输出信息不够完整
            CurrentControllerMethod.clear();
            threadLocal.remove();
        }
    }
}
