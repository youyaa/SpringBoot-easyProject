package listeningrain.cn.exception;

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
}
