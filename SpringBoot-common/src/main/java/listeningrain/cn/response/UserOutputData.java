package listeningrain.cn.response;

import lombok.Data;

/**
 * Author: listeningrain
 * Date: 2020/6/23 9:37 上午
 * Description:
 */
@Data
public class UserOutputData extends BaseOutputData {
    private Integer id;
    private String name;
    private Integer age;
    private String sex;
}
