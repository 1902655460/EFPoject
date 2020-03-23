package com.dindan.ordel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author：十亿少女的梦
 * @Date：2019/11/4 14:19
 */
@CrossOrigin
@Controller
public class OrdelController {

    @Autowired
    private OrdelService service;

    @ResponseBody
    @RequestMapping("/findPage")//分页查询
    public Object findPage(int page,int limit){
        return service.findPage(page,limit);
    }

    @ResponseBody
    @RequestMapping("/delById")//根据id删除
    public Object delById(Ordel ordel){
        return service.delById(ordel);
    }

    @ResponseBody
    @RequestMapping("/findOrdel")//根据条件分页查询
    public Object findOrdel(int page,int limit,Ordel ordel){
        return service.findOrdel(page,limit,ordel);
    }

    @ResponseBody
    @RequestMapping("/insert")//新增
    public Object insert(Ordel ordel){
        return service.insert(ordel);
    }

    @ResponseBody
    @RequestMapping("/update")//根据id修改
    public Object update(Ordel ordel){
        return service.update(ordel);
    }
}
