package listeningrain.cn.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    SUCCESS("S0A00000", "操作成功!"),
    SYSTEM_ERROR("E0T00000","系统错误"),
    REQUEST_ERROR("ET00001","错误的请求方式"),
    SERVICE_ERROR("E0T00001","服务层异常");
    private String code;
    private String msg;
}
