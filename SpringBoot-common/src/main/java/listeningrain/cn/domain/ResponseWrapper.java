package listeningrain.cn.domain;

import listeningrain.cn.enums.ErrorCode;
import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseWrapper<T> implements Serializable {
    private String transactionUuid;
    private String code;
    private String msg;
    private T data;

    public ResponseWrapper() {
        this.code = ErrorCode.SUCCESS.getCode();
        this.msg = ErrorCode.SUCCESS.getMsg();
    }
}
