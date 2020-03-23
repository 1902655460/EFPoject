package com.dindan.consumer;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author：十亿少女的梦
 * 用户Service
 * @Date：2019/11/13 11:06
 */
@Service
public class ConsumerService {

    @Autowired
    private ConsumerMapper mapper;

    Map<String,Object> map;

    public Object findPage(int page,int limit){
        Page<Consumer> pa = new Page<Consumer>(page,limit);
        IPage<Consumer> iPage = mapper.selectPage(pa,null);
        map = new HashMap<>(0);
        map.put("code",0);
        map.put("count",iPage.getTotal());
        map.put("data",iPage.getRecords());
        return map;
    }

    public Object findConsumer(int page,int limit,Consumer consumer){
        Page<Consumer> pa = new Page<Consumer>(page,limit);
        IPage<Consumer> iPage = mapper.selectPage(pa,new QueryWrapper<Consumer>().eq("name",consumer.getName()));
        map = new HashMap<>(0);
        map.put("code",0);
        map.put("count",iPage.getTotal());
        map.put("data",iPage.getRecords());
        return map;
    }

    public Object delById(Consumer consumer){
        map = new HashMap<>(0);
        if(mapper.deleteById(consumer.getId())==1){
            map.put("code",1);
            map.put("msg","删除成功");
        }else{
            map.put("code",0);
            map.put("msg","删除失败");
        }
        return map;
    }

    public Object insert(Consumer consumer){
        map = new HashMap<>(0);
        if(mapper.insert(consumer)==1){
            map.put("code",0);
            map.put("msg","新增成功");
        }else{
            map.put("code",1);
            map.put("msg","新增失败");
        }
        return map;
    }

    public Object update(Consumer consumer){
        map = new HashMap<>(0);
        if(mapper.updateById(consumer)==1){
            map.put("code",0);
            map.put("msg","修改成功");
        }else{
            map.put("code",1);
            map.put("msg","修改失败");
        }
        return map;
    }
}
