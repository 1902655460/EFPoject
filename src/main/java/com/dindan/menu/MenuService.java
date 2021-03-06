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

    //index初始化接口
    public Map<String, Object> init(){
        map = new HashMap<>(0);
        Map<String,Object> map2 = new HashMap<>(0);
        Menu m2 = mapper.selectOne(new QueryWrapper<Menu>().eq("pid",-1));
        map2.put("title",m2.getTitle());
        map2.put("href",m2.getHref());
        Map<String,Object> map3 = new HashMap<>(0);
        Menu m3 = mapper.selectOne(new QueryWrapper<Menu>().eq("pid",-2));
        map3.put("title",m3.getTitle());
        map3.put("image",m3.getIcon());
        map3.put("href","");

        map.put("homeInfo", map2);
        map.put("logoInfo", map3);
        return map;
    }

    //获取菜单接口
    public List<Map<String,Object>> menu(int stute){
        map = new HashMap<>(0);
        //查询出所有的头部模块
        List<Map<String,Object>> listMap = new ArrayList<>(0);
        List<Menu> list = new ArrayList<>(0);
        if(stute==0){
            list = mapper.selectList(new QueryWrapper<Menu>().eq("pid",0));
        }else{
            list = mapper.selectList(new QueryWrapper<Menu>().eq("id",stute));
        }

        for (Menu menu : list){
            Map<String,Object> lmap = new HashMap<>(0);
            lmap.put("title",menu.getTitle());
            lmap.put("icon",menu.getIcon());
            lmap.put("href",menu.getHref());
            lmap.put("target",menu.getTarget());
            List<Map<String,Object>> listMenu1 = new ArrayList<>(0);
            List<Menu> list1 = mapper.selectList(new QueryWrapper<Menu>().eq("pid",menu.getId()));
            //该头部模块下的所有一级菜单
            for(Menu menu1 : list1){
                Map<String,Object> map1 = new HashMap<>(0);
                map1.put("title",menu1.getTitle());
                map1.put("icon",menu1.getIcon());
                map1.put("href",menu1.getHref());
                map1.put("target",menu1.getTarget());
                List<Map<String,Object>> listMenu2 = new ArrayList<>(0);
                List<Menu> list2 = mapper.selectList(new QueryWrapper<Menu>().eq("pid",menu1.getId()));
                for(Menu menu2 : list2){
                    Map<String,Object> map2 = new HashMap<>(0);
                    map2.put("title",menu2.getTitle());
                    map2.put("icon",menu2.getIcon());
                    map2.put("href",menu2.getHref());
                    map2.put("target",menu2.getTarget());
                    listMenu2.add(map2);
                }
                map1.put("child",listMenu2);
                listMenu1.add(map1);
            }
            lmap.put("child",listMenu1);
            listMap.add(lmap);
        }
        return listMap;
    }
}
