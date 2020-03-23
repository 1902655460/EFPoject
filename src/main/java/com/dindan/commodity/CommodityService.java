package com.dindan.commodity;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dindan.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author：十亿少女的梦
 * 商品Service
 * @Date：2019/11/13 11:43
 */
@Service
public class CommodityService {

    @Autowired
    private CommodityMapper mapper;

    Map<String,Object> map;

    public Object findPage(int page,int limit){
        Page<Commodity> pa = new Page<Commodity>(page,limit);
        IPage<Commodity> iPage = mapper.selectPage(pa,null);
        map = new HashMap<>(0);
        map.put("code",0);
        map.put("count",iPage.getTotal());
        map.put("data",iPage.getRecords());
        return map;
    }

    public Object findCommodity(int page,int limit,Commodity commodity){
        Page<Commodity> pa = new Page<Commodity>(page,limit);
        IPage<Commodity> iPage = mapper.selectPage(pa,new QueryWrapper<Commodity>().eq("name",commodity.getName()));
        map = new HashMap<>(0);
        map.put("code",0);
        map.put("count",iPage.getTotal());
        map.put("data",iPage.getRecords());
        return map;
    }

    public Object delById(Commodity commodity){
        map = new HashMap<>(0);
        if(mapper.deleteById(commodity.getId())==1){
            map.put("code",1);
            map.put("msg","删除成功");
        }else{
            map.put("code",0);
            map.put("msg","删除失败");
        }
        return map;
    }

    public Object insert(Commodity commodity, HttpServletRequest request){
        map = new HashMap<>(0);
        User u = (User)request.getSession().getAttribute("user");
        commodity.setAdmin(u.getuName());
        if(mapper.insert(commodity)==1){
            map.put("code",0);
            map.put("msg","新增成功");
        }else{
            map.put("code",1);
            map.put("msg","新增失败");
        }
        return map;
    }

    public Object update(Commodity commodity){
        map = new HashMap<>(0);
        if(mapper.updateById(commodity)==1){
            map.put("code",0);
            map.put("msg","修改成功");
        }else{
            map.put("code",1);
            map.put("msg","修改失败");
        }
        return map;
    }
}
