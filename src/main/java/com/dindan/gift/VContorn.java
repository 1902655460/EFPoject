package com.dindan.gift;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
public class VContorn {

    @Autowired
    private GiftService service;

    @RequestMapping("/gift")
    public String Gift(){
        return "/gift.html";
    }

    @RequestMapping("selectPage")
    @ResponseBody
    public Object selectPage(int page,int limit){
        return service.selectPage(limit,page);
    }

    @RequestMapping("insertGift")
    @ResponseBody
    public Object insertGift(String name,int number){
        return service.insertGift(name,number);
    }

    @RequestMapping("delById")
    @ResponseBody
    public Object delById(int id){
        return service.delById(id);
    }
}
