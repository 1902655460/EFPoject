package com.dindan.xq;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("xq")
public class Xq {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String date;
    private Integer number;
    private String tname;
    private Integer gid;
    private String sa;
}
