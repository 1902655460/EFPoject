package com.dindan.menu;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@TableName("system_menu")
public class Menu {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer pid;
    private String title;
    private String icon;
    private String href;
    private String target;
    private Integer status;
    private String remark;

    @TableField(exist = false)
    private List<Map<String,Object>> list;
}
