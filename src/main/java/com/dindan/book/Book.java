package com.dindan.book;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("book")
public class Book {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private Integer number;
    private String cdate;
    private String udate;
    private Integer xid;
}
