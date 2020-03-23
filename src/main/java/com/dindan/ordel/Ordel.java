package com.dindan.ordel;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @Author：十亿少女的梦
 * 订单实体类
 * @Date：2019/11/4 14:11
 */
@TableName("ordel")
public class Ordel {
    @TableId
    private int id;
    private String ordel;
    private String creatDate;
    private String name;
    private String state;

    @Override
    public String toString() {
        return "Ordel{" +
                "id=" + id +
                ", ordel='" + ordel + '\'' +
                ", creatDate='" + creatDate + '\'' +
                ", name='" + name + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrdel() {
        return ordel;
    }

    public void setOrdel(String ordel) {
        this.ordel = ordel;
    }

    public String getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(String creatDate) {
        this.creatDate = creatDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
