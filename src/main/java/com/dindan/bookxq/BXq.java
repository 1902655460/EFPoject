package com.dindan.bookxq;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("bookxq")
public class BXq {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String date;
    private Integer number;
    private String tname;
    private Integer gid;
    private String sa;
}
