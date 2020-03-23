package com.dindan.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author：十亿少女的梦
 * @Date：2019/11/13 11:12
 */
@Controller
@CrossOrigin
public class ConsumerController {

    @Autowired
    private ConsumerService service;

    @ResponseBody
    @RequestMapping("/findConPage")//分页查询
    public Object findConPage(int page,int limit){
        return service.findPage(page,limit);
    }

    @ResponseBody
    @RequestMapping("/delConById")//根据id删除
    public Object delConById(Consumer consumer){
        return service.delById(consumer);
    }

    @ResponseBody
    @RequestMapping("/findCon")//根据条件分页查询
    public Object findCon(int page,int limit,Consumer consumer){
        return service.findConsumer(page,limit,consumer);
    }

    @ResponseBody
    @RequestMapping("/insertCon")//新增
    public Object insertCon(Consumer consumer){
        return service.insert(consumer);
    }

    @ResponseBody
    @RequestMapping("/updateCon")//根据id修改
    public Object updateCon(Consumer consumer){
        return service.update(consumer);
    }
}
