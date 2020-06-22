package listeningrain.cn.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Author: listeningrain
 * Date: 2020/6/21 7:14 下午
 * Description:
 */
@Data
public class StudentInputData extends BaseInputData{

    @NotNull(message = "name不能为空")
    private String name;
    @NotNull(message = "age不能为空")
    private Integer age;
}
