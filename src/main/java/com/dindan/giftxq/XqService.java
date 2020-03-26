package com.dindan.giftxq;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dindan.gift.Gift;
import com.dindan.gift.GiftMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class XqService {

    @Autowired
    private XqMapper mapper;

    @Autowired
    private GiftMapper giftMapper;

    Map<String,Object> map;

    public Map selectPage1(int limit,int page,int gid){
        map = new HashMap<>(0);
        Page<Xq> pa = new Page<Xq>(page,limit);
        IPage<Xq> iPage = mapper.selectPage(pa,new QueryWrapper<Xq>().eq("gid",gid));
        List<Xq> list = iPage.getRecords();
        map.put("data",list);
        map.put("count",iPage.getTotal());
        map.put("code",0);
        return map;
    }

    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public Map insertXQ(String name,int number,String tname,int gid,String sa){
        map = new HashMap<>(0);
        try{
            Xq x = new Xq();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String da = sdf.format(new Date());
            x.setDate(da);
            x.setName(name);
            x.setNumber(number);
            x.setTname(tname);
            x.setGid(gid);
            x.setSa(sa);
            mapper.insert(x);
            Gift gi = giftMapper.selectById(gid);
            gi.setNumber(gi.getNumber()+number);
            gi.setUdate(da);
            giftMapper.updateById(gi);
            map.put("code",0);
            map.put("msg","新增成功！");
        }catch (Exception e){
            map.put("code",1);
            map.put("msg","程序错误，请联系十忆少女的梦！");
        }
        return map;
    }

    public Map delXQById(int id) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String da = sdf.format(new Date());
        map = new HashMap<>(0);
        Xq xq = mapper.selectById(id);
        int i = mapper.deleteById(id);
        Gift g = giftMapper.selectById(xq.getGid());
        g.setNumber(g.getNumber()-xq.getNumber());
        g.setUdate(da);
        giftMapper.updateById(g);
        map.put("code",i);
        return map;
    }
}
