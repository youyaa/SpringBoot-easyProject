package listeningrain.cn.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Author: listeningrain
 * Date: 2020/6/20 1:53 下午
 * Description:
 */
@Data
@AllArgsConstructor
public class ServiceBaseException extends Exception{

    private String code;
    private String msg;
}
