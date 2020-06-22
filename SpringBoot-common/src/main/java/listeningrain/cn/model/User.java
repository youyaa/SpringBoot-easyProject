package listeningrain.cn.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data //set/get/toString
@Accessors(chain = true) //链式加载
@NoArgsConstructor //无参构造
@AllArgsConstructor //有参构造
@TableName("user") //对象与数据表完成映射
public class User implements Serializable {
    @TableId(type = IdType.AUTO) //主键自动
    private Integer id;
    @TableField("name")
    private String name;
    @TableId("age")
    private Integer age;
    private String sex;
}
