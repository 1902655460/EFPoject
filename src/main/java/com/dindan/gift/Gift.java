package com.dindan.gift;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("gift")
public class Gift {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private Integer number;
    private String cdate;
    private String udate;
}
