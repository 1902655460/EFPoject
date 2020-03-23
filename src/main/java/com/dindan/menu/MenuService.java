package com.dindan.menu;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MenuService {

    @Autowired
    private MenuMapper mapper;

    Map<String,Object> map;

    public Map<String, Object> init(){
        map = new HashMap<>(0);
        Map<String,Object> map2 = new HashMap<>(0);
        map2.put("title","首页");
        map2.put("href","http://www.baidu.com/");
        Map<String,Object> map3 = new HashMap<>(0);
        map3.put("title","E  F");
        map3.put("image","images/eflog.png");

        map.put("homeInfo", map2);
        map.put("logoInfo", map3);
        return map;
    }

    public Map<String,Object> menu(){
        map = new HashMap<>(0);
        //查询出所有的头部模块
        List<Map<String,Object>> listMap = new ArrayList<>(0);
        List<Menu> list = mapper.selectList(new QueryWrapper<Menu>().eq("pid",0));
        for (Menu menu : list){
            Map<String,Object> lmap = new HashMap<>(0);
            lmap.put("title",menu.getTitle());
            lmap.put("icon",menu.getIcon());
            lmap.put("href",menu.getHref());
            lmap.put("target",menu.getTarget());
            List<Map<String,Object>> listMenu = new ArrayList<>(0);
            lmap.put("child",listMenu);

        }
        return new HashMap<>();
    }
}
