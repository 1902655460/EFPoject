package com.dindan.commodity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author：十亿少女的梦
 * 商品Controller
 * @Date：2019/11/13 11:44
 */
@CrossOrigin
@Controller
public class CommodityController {

    @Autowired
    private CommodityService service;

    @ResponseBody
    @RequestMapping("/findComPage")//分页查询
    public Object findComPage(int page,int limit){
        return service.findPage(page,limit);
    }

    @ResponseBody
    @RequestMapping("/delComById")//根据id删除
    public Object delComById(Commodity commodity){
        return service.delById(commodity);
    }

    @ResponseBody
    @RequestMapping("/findCom")//根据条件分页查询
    public Object findCom(int page,int limit,Commodity commodity){
        return service.findCommodity(page,limit,commodity);
    }

    @ResponseBody
    @RequestMapping("/insertCom")//新增
    public Object insertCom(Commodity commodity, HttpServletRequest request){
        return service.insert(commodity,request);
    }

    @ResponseBody
    @RequestMapping("/updateCom")//根据id修改
    public Object updateCom(Commodity commodity){
        return service.update(commodity);
    }
}
