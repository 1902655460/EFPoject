package com.dindan.commodity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @Author：十亿少女的梦
 * 商品实体类
 * @Date：2019/11/13 10:36
 */
@TableName("commodity")
public class Commodity {

    @TableId(type = IdType.AUTO)//mybatis-plus注解  该属性对应表主键，默认为数据库自增
    private Integer id;
    private String name;
    private String type;
    private String jjia;
    private String sjia;
    private String num;
    private String admin;

    @Override
    public String toString() {
        return "Commodity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", jjia='" + jjia + '\'' +
                ", sjia='" + sjia + '\'' +
                ", num='" + num + '\'' +
                ", admin='" + admin + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getJjia() {
        return jjia;
    }

    public void setJjia(String jjia) {
        this.jjia = jjia;
    }

    public String getSjia() {
        return sjia;
    }

    public void setSjia(String sjia) {
        this.sjia = sjia;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getNum() {
        return num;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }
}
