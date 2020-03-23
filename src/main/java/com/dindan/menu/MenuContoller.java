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


    @ResponseBody
    @RequestMapping("/init")
    public Map<String, Object> init(){
        return service.init();
    }

}
