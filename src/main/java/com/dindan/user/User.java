package com.dindan.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author：十亿少女的梦
 * @Date：2020/3/23 15:02
 */

@Data
@TableName("user")
public class User {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String pwd;
    private Integer stute;
}
