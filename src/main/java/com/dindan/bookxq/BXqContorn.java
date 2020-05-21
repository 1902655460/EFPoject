package com.dindan.bookxq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
public class BXqContorn {

    @Autowired
    private BXqService service;

    @RequestMapping("selectBookXQ")
    @ResponseBody
    public Object selectPage(int page,int limit,int gid){
        return service.selectPage1(limit,page,gid);
    }

    @RequestMapping("ckBookXQ")
    @ResponseBody
    public Object ckGiftXQ(String name,String tname,int gid,String sa){
        return service.insertckXQ(name, tname, gid,sa);
    }

    @RequestMapping("rkBookXQ")
    @ResponseBody
    public Object rkGiftXQ(int number,int gid,String sa){
        return service.insertXQ(null, number, null, gid,sa);
    }

    @RequestMapping("delBookXQ")
    @ResponseBody
    public Object delXQById(int id){
        return service.delXQById(id);
    }

}
