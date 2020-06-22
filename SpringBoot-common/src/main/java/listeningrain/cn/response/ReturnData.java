package listeningrain.cn.response;

import listeningrain.cn.enums.ErrorCode;
import lombok.Data;

import java.io.Serializable;

@Data
public class ReturnData<T> implements Serializable {
    private String transactionUuid;
    private String code;
    private String msg;
    private T data;

    public ReturnData() {
        this.code = ErrorCode.SUCCESS.getCode();
        this.msg = ErrorCode.SUCCESS.getMsg();
    }

    public ReturnData(T data) {
        this.code = ErrorCode.SUCCESS.getCode();
        this.msg = ErrorCode.SUCCESS.getMsg();
        this.data = data;
    }
}
