package com.dindan.giftxq;

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

    @RequestMapping("selectGiftXQ")
    @ResponseBody
    public Object selectPage(int page,int limit,int gid){
        return service.selectPage1(limit,page,gid);
    }

    @RequestMapping("ckGiftXQ")
    @ResponseBody
    public Object ckGiftXQ(String name,int number,String tname,int gid,String sa){
        return service.insertXQ(name, -number, tname, gid,sa);
    }

    @RequestMapping("rkGiftXQ")
    @ResponseBody
    public Object rkGiftXQ(int number,int gid,String sa){
        return service.insertXQ(null, number, null, gid,sa);
    }

    @RequestMapping("delGiftXQ")
    @ResponseBody
    public Object delXQById(int id){
        return service.delXQById(id);
    }

}
