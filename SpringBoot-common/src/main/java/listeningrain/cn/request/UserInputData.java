package listeningrain.cn.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Author: listeningrain
 * Date: 2020/6/23 9:37 上午
 * Description:
 */
@Data
public class UserInputData extends BaseInputData {
    @NotNull(message = "id不能为空")
    private Integer id;
    private String name;
    private Integer age;
    private String sex;
}
