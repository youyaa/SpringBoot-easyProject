package listeningrain.cn.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    SUCCESS("S0A00000", "操作成功!"),
    SYSTEM_ERROR("E0T00000","系统错误");
    private String code;
    private String msg;
}
