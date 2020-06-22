package listeningrain.cn.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import listeningrain.cn.model.User;

import java.util.List;

/**
 * Author: listeningrain
 * Date: 2020/6/22 4:26 下午
 * Description:
 */
public interface UserMapper extends BaseMapper<User> {

    //查询全部的user表中的数据
    List<User> findAll();

}
