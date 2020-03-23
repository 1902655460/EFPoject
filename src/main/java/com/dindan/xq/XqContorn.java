package com.dindan.xq;

import com.dindan.gift.GiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
public class XqContorn {

    @Autowired
    private XqService service;

    @ResponseBody
    @RequestMapping("/se")
    public Object Gift(int page,int limit){
        return service.selectPage(limit,page);
    }

    @RequestMapping("selectXQPage")
    @ResponseBody
    public Object selectPage(int page,int limit,int tid){
        return service.selectPage1(limit,page,tid);
    }

    @RequestMapping("insertXQ")
    @ResponseBody
    public Object insertXQ(String name,int number,String tname,int gid,String sa){
        return service.insertXQ(name, number, tname, gid,sa);
    }

    @RequestMapping("delXQById")
    @ResponseBody
    public Object delXQById(int id){
        return service.delXQById(id);
    }

}
