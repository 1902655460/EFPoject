package com.dindan.ordel;

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
 * @Date：2019/11/4 14:14
 */
@Service
public class OrdelService {

    @Autowired
    private OrdelMapper mapper;

    Map<String,Object> map;

    public Object findPage(int page,int limit){
        Page<Ordel> pa = new Page<Ordel>(page,limit);
        IPage<Ordel> iPage = mapper.selectPage(pa,null);
        map = new HashMap<>(0);
        map.put("code",0);
        map.put("count",iPage.getTotal());
        map.put("data",iPage.getRecords());
        return map;
    }

    public Object findOrdel(int page,int limit,Ordel ordel){
        Page<Ordel> pa = new Page<Ordel>(page,limit);
        IPage<Ordel> iPage = mapper.selectPage(pa,new QueryWrapper<Ordel>().eq("ordel",ordel.getOrdel()));
        map = new HashMap<>(0);
        map.put("code",0);
        map.put("count",iPage.getTotal());
        map.put("data",iPage.getRecords());
        return map;
    }

    public Object delById(Ordel ordel){
        map = new HashMap<>(0);
        if(mapper.deleteById(ordel.getId())==1){
            map.put("code",1);
            map.put("msg","删除成功");
        }else{
            map.put("code",0);
            map.put("msg","删除失败");
        }
        return map;
    }

    public Object insert(Ordel ordel){
        map = new HashMap<>(0);
        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat ("yyyyMMddhhmmss");
        SimpleDateFormat ft2 = new SimpleDateFormat ("yyyy-MM-dd");
        if(ordel.getOrdel()==null||ordel.getOrdel().equals("")){
            ordel.setOrdel(ft.format(dNow));
        }
        if(ordel.getCreatDate()==null||ordel.getCreatDate().equals("")){
            ordel.setCreatDate(ft2.format(dNow));
        }
        if(mapper.insert(ordel)==1){
            map.put("code",0);
            map.put("msg","新增成功");
        }else{
            map.put("code",1);
            map.put("msg","新增失败");
        }
        return map;
    }

    public Object update(Ordel ordel){
        map = new HashMap<>(0);
        if(mapper.updateById(ordel)==1){
            map.put("code",0);
            map.put("msg","修改成功");
        }else{
            map.put("code",1);
            map.put("msg","修改失败");
        }
        return map;
    }
}
