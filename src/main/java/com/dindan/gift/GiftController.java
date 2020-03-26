package com.dindan.gift;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
public class GiftController {

    @Autowired
    private GiftService service;

    @RequestMapping("selectGiftPage")
    @ResponseBody
    public Object selectPage(int page,int limit,int xid){
        return service.selectPage(limit,page,xid);
    }

    @RequestMapping("insertGift")
    @ResponseBody
    public Object insertGift(String name,int number,String cname,int xid){
        return service.insertGift(name,number,cname,xid);
    }

    @RequestMapping("delGiftById")
    @ResponseBody
    public Object delById(int id){
        return service.delById(id);
    }
}
