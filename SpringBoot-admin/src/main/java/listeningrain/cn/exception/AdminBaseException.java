package listeningrain.cn.exception;

import listeningrain.cn.enums.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Author: listeningrain
 * Date: 2020/6/19 5:16 下午
 * Description:
 */
@Data
@AllArgsConstructor
public class AdminBaseException extends Exception{
    private String code;
    private String msg;

    public AdminBaseException(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
    }
}
