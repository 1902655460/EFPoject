package com.dindan.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@CrossOrigin
public class MenuContoller {

    @Autowired
    private MenuService service;


    /**
     * 页面初始化接口
     * @return
     */
    @ResponseBody
    @RequestMapping("/init")
    public Map<String, Object> init(int stute){
        System.out.println(stute);
        Map<String,Object> map = service.init();
        map.put("menuInfo",service.menu(stute));
        return map;
    }

}
