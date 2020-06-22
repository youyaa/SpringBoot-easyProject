package listeningrain.cn.response;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Author: listeningrain
 * Date: 2020/6/21 7:16 下午
 * Description:
 */
@Data
@AllArgsConstructor
public class StudentOutputData extends BaseOutputData{
    private String name;
    private Integer age;
}
