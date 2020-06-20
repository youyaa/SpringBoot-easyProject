package listeningrain.cn.aspect;
import listeningrain.cn.domain.ResponseWrapper;
import listeningrain.cn.enums.ErrorCode;
import listeningrain.cn.exception.AdminBaseException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 捕获并处理Controller所有可能出现的且未被Controller方法内部消化的异常。
 */
@ControllerAdvice
public class WebExceptionHandler {

	protected final Logger logger = LogManager.getLogger(getClass());
	private final boolean isLoggerDebugEnabled = logger.isDebugEnabled();

	/**
	 * 捕获并处理Controller所有可能出现的且未被Controller方法内部消化的异常。
	 * @return String
	 */
	@ExceptionHandler(Throwable.class)
	@ResponseBody
	protected ResponseWrapper<Object> handleControllerException(Throwable ex) {
		return handleExceptionInternal(ex);
	}

	/**
	 * @param exception 抛出的异常
	 * @return 将异常转化为最终可以响应给REST客户端的JSON结果。
	 */
	private ResponseWrapper<Object> handleExceptionInternal(Throwable exception) {
		/**
		 * 通过拦截的异常信息转换成的输出对象
		 */
		ResponseWrapper<Object> outputDTO = new ResponseWrapper<>();
        logger.debug("捕获到的异常, 转为JSON", exception);

		if (exception instanceof AdminBaseException) {
			//自定义的异常;
			AdminBaseException adminBaseException = (AdminBaseException)exception;
			logger.error("REST层捕获到异常，错误码: {}, 错误信息: {}", adminBaseException.getCode(),
					adminBaseException.getMsg());
			outputDTO.setCode(adminBaseException.getCode());
			outputDTO.setMsg(adminBaseException.getMsg());
		} else {
			//其余异常全部转成系统异常
			logger.error("REST层捕获到未知异常，异常信息: {}", exception);
			outputDTO.setCode(ErrorCode.SYSTEM_ERROR.getCode());
			outputDTO.setMsg(ErrorCode.SYSTEM_ERROR.getMsg());
		}
		return outputDTO;
	}

}
